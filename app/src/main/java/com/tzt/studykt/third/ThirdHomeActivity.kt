package com.tzt.studykt.third

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.tzt.studykt.R
import kotlinx.android.synthetic.main.activity_third_home.*

class ThirdHomeActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third_home)
        init()
    }

    private fun init() {
        Util.doAction2()

        btnToast.setOnClickListener {
            val intent = Intent(this, IntentActivity::class.java).apply {
                putExtra("intent_sss", "我是传来的数据")
            }
            startActivityForResult(intent, 1)
        }

        btnExplore.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse("https://www.baidu.com")
            }
            startActivity(intent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.add -> Toast.makeText(this, "添加", Toast.LENGTH_SHORT).show()
            R.id.remove -> Toast.makeText(this, "删除", Toast.LENGTH_SHORT).show()
        }
        return true
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1 && resultCode == 2) {
            data?.getStringExtra("result")?.let {
                Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
            }
        }
    }
}
