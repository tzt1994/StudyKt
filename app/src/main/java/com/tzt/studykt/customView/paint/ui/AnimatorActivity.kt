package com.tzt.studykt.customView.paint.ui

import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.tzt.studykt.R
import com.tzt.studykt.customView.data.PaintModel
import com.tzt.studykt.customView.paint.fragment.animator.DurationFragment
import com.tzt.studykt.customView.paint.fragment.animator.InterpolatorFragment
import com.tzt.studykt.customView.paint.fragment.animator.ViewPropertyFragment
import com.tzt.studykt.customView.paint.fragment.effect.PaintEffectFragment
import com.tzt.studykt.customView.paint.fragment.effect.ShadowLayerFragment
import com.tzt.studykt.customView.paint.fragment.text.PaintTextFragment
import com.tzt.studykt.third.BaseActivity
import kotlinx.android.synthetic.main.activity_bezier.*


/**
 * Description: 属性动画1
 *
 * @author tangzhentao
 * @since 2020/5/8
 */
class AnimatorActivity: BaseActivity() {
    private var paintModels = ArrayList<PaintModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bezier)

        paintModels.apply {
            // 绘制文字方式
            add(PaintModel("View.animate()", ViewPropertyFragment()))
            add(PaintModel("setDuration()", DurationFragment()))
            add(PaintModel("interpolator", InterpolatorFragment()))
        }

        VpBezier.adapter = BezierAdapter(supportFragmentManager)
        tabBezier.setupWithViewPager(VpBezier)
    }

    inner class BezierAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {
        override fun getPageTitle(position: Int): CharSequence? {
            return paintModels[position].title
        }

        override fun getItem(position: Int) = paintModels[position].fragment

        override fun getCount() = paintModels.size
    }
}