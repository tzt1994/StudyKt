package com.tzt.studykt.customView.inaction.ui

import android.os.Bundle
import android.widget.FrameLayout
import com.tzt.studykt.R
import com.tzt.studykt.customView.inaction.widget.ScrapingCardView
import com.tzt.studykt.third.BaseActivity
import kotlinx.android.synthetic.main.activity_heart.*
import kotlinx.android.synthetic.main.activity_scraping_card.*


/**
 * Description: 心跳
 *
 * @author tangzhentao
 * @since 2020/5/13
 */
class HeartXfermodeActivity: BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_heart)

        hbvHeartBeat.startAnimation()
    }

    override fun onDestroy() {
        super.onDestroy()
        hbvHeartBeat.stopAnimation()
    }
}