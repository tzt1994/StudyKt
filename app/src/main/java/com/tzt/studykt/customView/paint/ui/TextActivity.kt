package com.tzt.studykt.customView.paint.ui

import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.tzt.studykt.R
import com.tzt.studykt.customView.data.PaintModel
import com.tzt.studykt.customView.paint.fragment.effect.PaintEffectFragment
import com.tzt.studykt.customView.paint.fragment.effect.ShadowLayerFragment
import com.tzt.studykt.customView.paint.fragment.text.PaintTextFragment
import com.tzt.studykt.third.BaseActivity
import kotlinx.android.synthetic.main.activity_bezier.*


/**
 * Description: 文字
 *
 * @author tangzhentao
 * @since 2020/5/8
 */
class TextActivity: BaseActivity() {
    private var paintModels = ArrayList<PaintModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bezier)

        paintModels.apply {
            // 绘制文字方式
            val styleFragment = PaintTextFragment()
            val styleBundle = Bundle()
            styleBundle.putInt("text_type", PaintTextFragment.TEXT_STYLE)
            styleFragment.arguments = styleBundle
            add(PaintModel("绘制文字方式", styleFragment))
            // 文字显示效果类
            val effectFragment = PaintTextFragment()
            val effectBundle = Bundle()
            effectBundle.putInt("text_type", PaintTextFragment.TEXT_EFFECT)
            effectFragment.arguments = effectBundle
            add(PaintModel("文字显示效果类", effectFragment))
            // 测量文字尺寸类
            val fontFragment = PaintTextFragment()
            val fontBundle = Bundle()
            fontBundle.putInt("text_type", PaintTextFragment.TEXT_FONT)
            fontFragment.arguments = fontBundle
            add(PaintModel("测量文字尺寸类", fontFragment))
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