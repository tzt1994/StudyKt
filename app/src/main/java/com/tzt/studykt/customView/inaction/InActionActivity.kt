package com.tzt.studykt.customView.inaction

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tzt.studykt.R
import com.tzt.studykt.customView.data.CustomModel
import com.tzt.studykt.customView.inaction.ui.HeartXfermodeActivity
import com.tzt.studykt.customView.inaction.ui.ScrapingCardXfermodeActivity
import com.tzt.studykt.third.BaseActivity
import kotlinx.android.synthetic.main.activity_custom.*


/**
 * Description: 实战高级UI效果
 *
 * @author tangzhentao
 * @since 2020/5/13
 */
class InActionActivity: BaseActivity() {
    private val uiList = ArrayList<CustomModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom)

        uiList.apply {
            add(CustomModel("刮刮卡", "xfermode", ScrapingCardXfermodeActivity::class.java))
            add(CustomModel("心跳", "xfermode", HeartXfermodeActivity::class.java))
        }

        recyclerCustomView.layoutManager = LinearLayoutManager(context).apply {
            orientation = LinearLayoutManager.VERTICAL
        }
        recyclerCustomView.adapter = UIAdapter()
    }

    inner class UIAdapter: RecyclerView.Adapter<UIViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)= UIViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.recycler_item_custom_view, parent, false)
        )

        override fun getItemCount()= uiList.size

        override fun onBindViewHolder(holder: UIViewHolder, position: Int) {
            val model = uiList[position]
            holder.title.text = model.title
            holder.subTitle.text = model.subTitle

            holder.itemView.setOnClickListener {
                startActivity(Intent(this@InActionActivity, model.clazz))
            }
        }

    }

    inner class UIViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.tvTitle)
        val subTitle: TextView = itemView.findViewById(R.id.tvSubTitle)
    }
}