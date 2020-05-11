package com.tzt.studykt.six

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.tzt.studykt.R
import com.tzt.studykt.third.BaseActivity
import kotlinx.android.synthetic.main.activity_six_home.*
import java.text.DateFormat
import java.text.SimpleDateFormat

class SixHomeActivity : BaseActivity() {
    private lateinit var timeChangeReceiver: TimeChangeReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_six_home)

        tvSystemTime.text = getCureentTime()

        val intentFilter = IntentFilter("android.intent.action.TIME_TICK")
        timeChangeReceiver = TimeChangeReceiver()
        registerReceiver(timeChangeReceiver, intentFilter)

        btnStard.setOnClickListener {
            val startIntent = Intent(BroadUtil.STARD_BROAD_CAST).apply {
                setPackage(packageName)
            }
            sendBroadcast(startIntent)
        }

        btnOrder.setOnClickListener {
            val startIntent = Intent(BroadUtil.ORDER_BROAD_CAST).apply {
                setPackage(packageName)
            }
            sendOrderedBroadcast(startIntent, null)
        }

        val result1 = num1AndNum2(1,5) { n1, n2 ->
            n1 + n2
        }
        val result2 = num1AndNum2(10, 4) { n1, n2 ->
            n1 - n2
        }
        Log.v("TAAAAA", "结果1: $result1 \n 结果2: $result2")

    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(timeChangeReceiver)
    }

    /**
     * 获取当前时间
     */
    private fun getCureentTime() : String {
        val format = DateFormat.getDateInstance() as SimpleDateFormat
        format.applyPattern("yyyy-MM-dd HH:mm:ss")
        return  System.currentTimeMillis().run {
            format.format(this)
        }
    }

    inner class TimeChangeReceiver : BroadcastReceiver() {
        override fun onReceive(p0: Context?, p1: Intent?) {
            tvSystemTime.text = getCureentTime()
        }
    }
}
