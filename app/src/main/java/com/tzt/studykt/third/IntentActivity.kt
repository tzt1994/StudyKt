package com.tzt.studykt.third

import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.tzt.studykt.R
import kotlinx.android.synthetic.main.activity_intent.*
import java.lang.StringBuilder

class IntentActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent)


        val obj = listOf("apple", "orange", "pear", "banana")
        var result = with(StringBuilder()) {
            append("开始吃水果")
            for(fruit in obj) {
                append(fruit)
                append("\n")
            }
            append("所有的水果都被吃完")
            toString()
        }

        var result2 = StringBuilder().run {
            append("开始吃水果")
            for(fruit in obj) {
                append(fruit)
                append("\n")
            }
            append("所有的水果都被吃完")
            toString()
        }

        Log.v("TAAAA", "$result \n $result2")

        tvIntent.text= intent.getStringExtra("intent_sss") ?: "第二个页面"

        tvIntent.setOnClickListener {
            val intent = Intent()
            intent.putExtra("result", "这是返回值")
            setResult(2, intent)
            finish()
        }

        btnExit.setOnClickListener {
            ActivityController.finishAllActivity()
        }
    }
}
