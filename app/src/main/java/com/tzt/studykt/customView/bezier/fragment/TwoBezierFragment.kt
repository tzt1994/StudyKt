package com.tzt.studykt.customView.bezier.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.tzt.studykt.R
import kotlinx.android.synthetic.main.fragment_one_bezier.*
import kotlin.properties.Delegates


/**
 * Description: 一阶贝塞尔
 *
 * @author tangzhentao
 * @since 2020/4/26
 */
class TwoBezierFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_two_bezier, container, false)
    }
}