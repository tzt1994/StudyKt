package com.tzt.studykt.six

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class OrderReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        Toast.makeText(context, "有序广播1 ${javaClass.simpleName}", Toast.LENGTH_SHORT).show()
        abortBroadcast()
    }
}
