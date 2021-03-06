package com.tzt.studykt.customView.paint.fragment.animator

import android.animation.Keyframe
import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import com.tzt.studykt.R
import com.tzt.studykt.customView.widget.BaseFragment
import kotlinx.android.synthetic.main.fragment_property_values_holders.*


/**
 * Description: 属性拆分
 *
 * @author tangzhentao
 * @since 2020/5/8
 */
class PropertyValuesHoldersFragment: BaseFragment() {
    private lateinit var holderAnimator: ObjectAnimator
    private var mProgress = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_property_values_holders, container, false)
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mProgress = seekBarProgress.progress
        tvProgress.text = "进度值：$mProgress"
        holderAnimator = ObjectAnimator.ofPropertyValuesHolder(hpvProgress, getPropertyValuesHolder()).apply {
            duration = 1500
        }

        seekBarProgress.setOnSeekBarChangeListener(object :SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                mProgress = progress
                tvProgress.text = "进度值：$mProgress"
                holderAnimator.setValues(getPropertyValuesHolder())
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }

        })

        btnHAnimate.setOnClickListener {
            holderAnimator.start()
        }

        holderAnimator.start()
    }

    fun getPropertyValuesHolder(): PropertyValuesHolder {
        val keyframe1 = Keyframe.ofInt(0f, 0)
        val keyframe2 = Keyframe.ofInt(0.5f, 100)
        val keyframe3 = Keyframe.ofInt(1f, mProgress)
        return PropertyValuesHolder.ofKeyframe("progress", keyframe1, keyframe2, keyframe3)
    }
}