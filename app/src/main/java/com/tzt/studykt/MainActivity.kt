package com.tzt.studykt

import android.content.Intent
import android.os.Bundle
import com.tzt.studykt.customView.CustomActivity
import com.tzt.studykt.four.FourHomeActivity
import com.tzt.studykt.seven.SevenHomeActivity
import com.tzt.studykt.six.SixHomeActivity
import com.tzt.studykt.third.BaseActivity
import com.tzt.studykt.third.ThirdHomeActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnThird.setOnClickListener {
            startActivity(Intent(this, ThirdHomeActivity::class.java))
        }

        btnFour.setOnClickListener {
            startActivity(Intent(this, FourHomeActivity::class.java))
        }

        btnSix.setOnClickListener {
            startActivity(Intent(this, SixHomeActivity::class.java))
        }

        btnSeven.setOnClickListener {
            startActivity(Intent(this, SevenHomeActivity::class.java))
        }

        btnCustom.setOnClickListener {
            startActivity(Intent(this, CustomActivity::class.java))
        }
    }
}
