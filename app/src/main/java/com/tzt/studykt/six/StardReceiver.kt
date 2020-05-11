package com.tzt.studykt.six

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class StardReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        Toast.makeText(context, "标准广播${javaClass.simpleName}", Toast.LENGTH_SHORT).show()
    }
}
