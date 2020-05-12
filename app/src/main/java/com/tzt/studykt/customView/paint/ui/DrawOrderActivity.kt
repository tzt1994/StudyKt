package com.tzt.studykt.customView.paint.ui

import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.tzt.studykt.R
import com.tzt.studykt.customView.data.PaintModel
import com.tzt.studykt.customView.paint.fragment.cliptransform.ClipTransFormFragment
import com.tzt.studykt.customView.paint.fragment.cliptransform.TransFormShowFragment
import com.tzt.studykt.customView.paint.fragment.draworder.DrawFragment
import com.tzt.studykt.customView.paint.fragment.draworder.DrawOrderFragment
import com.tzt.studykt.customView.paint.fragment.draworder.DrawProcessFragment
import com.tzt.studykt.customView.paint.fragment.effect.PaintEffectFragment
import com.tzt.studykt.customView.paint.fragment.effect.ShadowLayerFragment
import com.tzt.studykt.customView.paint.fragment.text.PaintTextFragment
import com.tzt.studykt.third.BaseActivity
import kotlinx.android.synthetic.main.activity_bezier.*


/**
 * Description: 绘制顺序
 *
 * @author tangzhentao
 * @since 2020/5/8
 */
class DrawOrderActivity: BaseActivity() {
    private var paintModels = ArrayList<PaintModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bezier)

        paintModels.apply {
            // super.onDraw()
            val onDrawFragment = DrawOrderFragment()
            val onDrawBundle = Bundle()
            onDrawBundle.putInt("draw_order_type", DrawOrderFragment.SUPER_ONDRAW)
            onDrawFragment.arguments = onDrawBundle
            add(PaintModel("super.onDraw()", onDrawFragment))
            // dispatchDraw()
            val dispatchDrawFragment = DrawOrderFragment()
            val dispatchDrawBundle = Bundle()
            dispatchDrawBundle.putInt("draw_order_type", DrawOrderFragment.DISPATCH_DRAW)
            dispatchDrawFragment.arguments = dispatchDrawBundle
            add(PaintModel("dispatchDraw()", dispatchDrawFragment))
            // 绘制过程简述
            add(PaintModel("绘制过程简述", DrawProcessFragment()))
            // onDrawForeground()
            val onDrawForegroundFragment = DrawOrderFragment()
            val onDrawForegroundBundle = Bundle()
            onDrawForegroundBundle.putInt("draw_order_type", DrawOrderFragment.ONDRAW_FOREGROUND)
            onDrawForegroundFragment.arguments = onDrawForegroundBundle
            add(PaintModel("onDrawForeground()", onDrawForegroundFragment))
            // draw() 总调度方法
            add(PaintModel("draw()", DrawFragment()))
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