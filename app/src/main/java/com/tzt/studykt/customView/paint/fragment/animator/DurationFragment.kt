package com.tzt.studykt.customView.paint.fragment.animator

import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import com.tzt.studykt.R
import com.tzt.studykt.customView.widget.BaseFragment
import kotlinx.android.synthetic.main.fragment_duration.*


/**
 * Description: 属性动画设置时长
 *
 * @author tangzhentao
 * @since 2020/5/8
 */
class DurationFragment: BaseFragment() {
    private lateinit var animator: ObjectAnimator

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_duration, container, false)
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        animator = ObjectAnimator.ofFloat(ivDuration, "rotation", 0f, 360f)
        tvProgress.text = seekbarDuration.progress.toString()
        seekbarDuration.setOnSeekBarChangeListener(object :SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                tvProgress.text = progress.toString()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }

        })

        btnDurationAnimate.setOnClickListener {
            startAniamtion(seekbarDuration.progress.toLong())
        }
    }

    private fun startAniamtion(time: Long) {
        animator.apply {
            duration = time
            start()
        }
    }
}