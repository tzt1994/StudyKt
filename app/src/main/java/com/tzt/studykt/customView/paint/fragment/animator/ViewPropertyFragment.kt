package com.tzt.studykt.customView.paint.fragment.animator

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
import com.tzt.studykt.customView.paint.widget.text.DrawTextView
import com.tzt.studykt.customView.paint.widget.text.FontTextView
import com.tzt.studykt.customView.paint.widget.text.ShowTextView
import com.tzt.studykt.customView.widget.BaseFragment
import com.tzt.studykt.dpToPx
import kotlinx.android.synthetic.main.fragment_shader.*
import kotlinx.android.synthetic.main.fragment_view_property.*


/**
 * Description: view的动画
 *
 * @author tangzhentao
 * @since 2020/5/8
 */
class ViewPropertyFragment: BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_view_property, container, false)
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnViewPro.setOnClickListener {
            ivAnimator.animate()
                .translationX(500f)
                .translationY(500f)
                .scaleX(1f)
                .scaleY(1f)
                .alpha(1f)
                .rotation(360f)
                .duration = 1000
        }
    }
}