package com.tzt.studykt.customView.paint.fragment.cliptransform

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.LinearInterpolator
import com.tzt.studykt.R
import com.tzt.studykt.customView.widget.BaseFragment
import kotlinx.android.synthetic.main.fragment_transform_show.*

/**
 * Description:
 *
 * @author tangzhentao
 * @since 2020/5/11
 */
class TransFormShowFragment: BaseFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_transform_show, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val rightAnimator = ObjectAnimator.ofFloat(fbavFlip, "degreeRightY", 0f, -45f)
        rightAnimator.duration = 1000
        val canvasAnimator = ObjectAnimator.ofFloat(fbavFlip, "degreeCanvas", 0f, 270f)
        canvasAnimator.duration = 800
        val leftAnimator = ObjectAnimator.ofFloat(fbavFlip, "degreeLeftY", 0f, 45f)
        leftAnimator.duration = 1000
        val animatorSet = AnimatorSet().apply {
            interpolator = LinearInterpolator()
            playSequentially(rightAnimator, canvasAnimator, leftAnimator)
        }

        btnRotate.setOnClickListener {
            ravRotate.startAnimatior()
        }

        btnFlipBorad.setOnClickListener {
            fbavFlip.reset()
            animatorSet.start()
        }
    }
}