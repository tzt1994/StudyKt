package com.tzt.studykt.customView.inaction.ui

import android.os.Bundle
import android.widget.FrameLayout
import com.tzt.studykt.R
import com.tzt.studykt.customView.inaction.widget.ScrapingCardView
import com.tzt.studykt.third.BaseActivity
import kotlinx.android.synthetic.main.activity_scraping_card.*


/**
 * Description: 刮刮卡
 *
 * @author tangzhentao
 * @since 2020/5/13
 */
class ScrapingCardXfermodeActivity: BaseActivity() {
    private lateinit var scrapingCardView: ScrapingCardView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scraping_card)

        val params = FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT)
        scrapingCardView = ScrapingCardView(context)
        scrapingCardView.setImageResource(R.mipmap.spider_black)
        flScrapingCard.addView(scrapingCardView, params)
    }

    override fun onDestroy() {
        super.onDestroy()
        scrapingCardView.recycle()
    }
}