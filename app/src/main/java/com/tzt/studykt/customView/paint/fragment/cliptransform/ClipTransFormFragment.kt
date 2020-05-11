package com.tzt.studykt.customView.paint.fragment.cliptransform

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tzt.studykt.R
import com.tzt.studykt.customView.data.PaintItemModel
import com.tzt.studykt.customView.paint.widget.cliptransform.ClipView
import com.tzt.studykt.customView.paint.widget.text.DrawTextView
import com.tzt.studykt.customView.paint.widget.text.FontTextView
import com.tzt.studykt.customView.paint.widget.text.ShowTextView
import com.tzt.studykt.customView.widget.BaseFragment
import com.tzt.studykt.dpToPx
import kotlinx.android.synthetic.main.fragment_shader.*


/**
 * Description: 裁剪和几何变换
 *
 * @author tangzhentao
 * @since 2020/5/8
 */
class ClipTransFormFragment: BaseFragment() {
    companion object {
        const val CLIP = 0
        const val CANVAS_TRANSFORM = 1
        const val MATRIX_TRANSFORM = 2
        const val CAMERA_TRANSFORM = 3
    }

    private val mList = ArrayList<PaintItemModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_shader, container, false)
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val effect = arguments?.getInt("clip_transform_type", -1)
        titleTv.visibility = View.GONE
        mList.clear()
        effect?.let {
            when (it) {
                CLIP -> {
                    // 范围裁剪
                    mList.apply {
                        add(PaintItemModel("矩形裁剪\n" +
                                "", ClipView(mContext, type = ClipView.CLIP_RECT)))
                    }
                }
                CANVAS_TRANSFORM -> {
                    // 画布几何变换
                    mList.apply {
                    }
                }
                MATRIX_TRANSFORM -> {
                    // matrix几何变换
                    mList.apply {

                    }
                }
                CAMERA_TRANSFORM -> {
                    // camera几何变换
                    mList.apply {

                    }
                }
                else -> {}
            }
        }

        recyclerShader.layoutManager = LinearLayoutManager(mContext).apply {
            orientation = LinearLayoutManager.VERTICAL
        }
        recyclerShader.adapter = EffectAdapter()

        recyclerShader.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val layoutManager = recyclerView.layoutManager as LinearLayoutManager
                val position = layoutManager.findFirstCompletelyVisibleItemPosition()
                if (position >=0 && position < mList.size) {
                    val model = mList[position]
                    when {
                        model.title.contains("strokeWidth") -> {
                            titleTv.text = "线条宽度\nstrokeWidth = Float"
                        }
                        model.title.contains("Paint.Cap") -> {
                            titleTv.text = "线头形状\nstrokeCap = Paint.Cap"
                        }
                        model.title.contains("Paint.Join") -> {
                            titleTv.text = "拐角的形状\nstrokeJoin = Paint.Join"
                        }
                        model.title.contains("strokeMiter") -> {
                            titleTv.text = "MITER 型拐角的延长线的最大值\nstrokeMiter = Float"
                        }
                    }
                }
            }
        })
    }

    inner class EffectAdapter: RecyclerView.Adapter<EffectAdapter.ShaderViewHolder>() {
        inner class ShaderViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
            val title: TextView = itemView.findViewById(R.id.shaderTypeTv)
            val contextView: FrameLayout = itemView.findViewById(R.id.shaderContentView)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ShaderViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.recycler_item_shader, parent, false)
        )

        override fun getItemCount() = mList.size

        override fun onBindViewHolder(holder: ShaderViewHolder, position: Int) {
            val model = mList[position]

            holder.title.setTextColor(Color.parseColor("#006400"))
            holder.title.text = model.title
            if (model.view == null) {
                holder.contextView.visibility = View.GONE
            } else {
                holder.contextView.visibility = View.VISIBLE
                val viewParent = model.view.parent
                if (viewParent != null) {
                    val vp = viewParent as ViewGroup
                    vp.removeView(model.view)
                }
                holder.contextView.removeAllViews()
                val params = FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, dpToPx(200).toInt())
                holder.contextView.addView(model.view, params)
            }
        }
    }
}