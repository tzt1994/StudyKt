package com.tzt.studykt.seven

import android.content.Context
import android.os.Bundle
import com.tzt.studykt.R
import com.tzt.studykt.third.BaseActivity
import kotlinx.android.synthetic.main.activity_seven_home.*
import java.io.*
import java.lang.StringBuilder

class SevenHomeActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seven_home)

        btnSave.setOnClickListener {
            save()
        }

        btnRead.setOnClickListener {
            read()
        }
    }

    private fun save() {
        try {
            etFileInput.text?.let { str ->
                val output = openFileOutput("数据文本.txt", Context.MODE_PRIVATE)
                val writer = BufferedWriter(OutputStreamWriter(output))
                writer.use {
                    it.write(str.toString())
                }
            }

            etFileInput.setText("")
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    private fun read() {
        val sb = StringBuilder()
        try {
            val input = openFileInput("数据文本.txt")
            val reader = BufferedReader(InputStreamReader(input))
            reader.use {
                reader.forEachLine {
                    sb.append(it)
                }
            }

            etFileInput.setText(sb.toString())
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}
