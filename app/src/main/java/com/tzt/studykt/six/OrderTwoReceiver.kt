package com.tzt.studykt.six

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class OrderTwoReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        Toast.makeText(context, "有序广播2 ${javaClass.simpleName}", Toast.LENGTH_SHORT).show()
    }
}
