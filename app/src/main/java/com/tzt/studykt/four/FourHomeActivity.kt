package com.tzt.studykt.four

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tzt.studykt.R
import kotlinx.android.synthetic.main.activity_four_home.*

class FourHomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_four_home)

        btnStag.setOnClickListener {
            startActivity(Intent(this, StaggeredGridActivity::class.java))
        }

        btnBestUI.setOnClickListener {
            startActivity(Intent(this, BestUIActivity::class.java))
        }
    }
}
