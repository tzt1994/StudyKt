package com.tzt.studykt.customView.paint.ui

import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.tzt.studykt.R
import com.tzt.studykt.customView.data.PaintModel
import com.tzt.studykt.customView.paint.fragment.cliptransform.ClipTransFormFragment
import com.tzt.studykt.customView.paint.fragment.effect.PaintEffectFragment
import com.tzt.studykt.customView.paint.fragment.effect.ShadowLayerFragment
import com.tzt.studykt.customView.paint.fragment.text.PaintTextFragment
import com.tzt.studykt.third.BaseActivity
import kotlinx.android.synthetic.main.activity_bezier.*


/**
 * Description: 裁剪和几何变换
 *
 * @author tangzhentao
 * @since 2020/5/8
 */
class ClipTransFormActivity: BaseActivity() {
    private var paintModels = ArrayList<PaintModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bezier)

        paintModels.apply {
            // 范围裁剪
            val clipFragment = ClipTransFormFragment()
            val clipBundle = Bundle()
            clipBundle.putInt("clip_transform_type", ClipTransFormFragment.CLIP)
            clipFragment.arguments = clipBundle
            add(PaintModel("范围裁剪", clipFragment))
            // 画布几何变换
            val canvasTransFormFragment = ClipTransFormFragment()
            val canvasTransFormBundle = Bundle()
            canvasTransFormBundle.putInt("clip_transform_type", ClipTransFormFragment.CANVAS_TRANSFORM)
            canvasTransFormFragment.arguments = canvasTransFormBundle
            add(PaintModel("Canvas几何变换", canvasTransFormFragment))
            // Matrix几何变换
            val matrixTransFormFragment = ClipTransFormFragment()
            val matrixTransFormBundle = Bundle()
            matrixTransFormBundle.putInt("clip_transform_type", ClipTransFormFragment.MATRIX_TRANSFORM)
            matrixTransFormFragment.arguments = matrixTransFormBundle
            add(PaintModel("Matrix几何变换", matrixTransFormFragment))
            // Camera几何变换
            val cameraTransFormFragment = ClipTransFormFragment()
            val cameraTransFormBundle = Bundle()
            cameraTransFormBundle.putInt("clip_transform_type", ClipTransFormFragment.CAMERA_TRANSFORM)
            cameraTransFormFragment.arguments = cameraTransFormBundle
            add(PaintModel("Camera几何变换", cameraTransFormFragment))
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