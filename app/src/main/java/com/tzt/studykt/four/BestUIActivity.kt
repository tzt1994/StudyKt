package com.tzt.studykt.four

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tzt.studykt.R
import kotlinx.android.synthetic.main.activity_best_u_i.*

class BestUIActivity : AppCompatActivity() {
    private val msgList = ArrayList<Msg>()
    // 延迟加载
    private lateinit var adapter: MsgAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_best_u_i)

        initList()
        val manager = LinearLayoutManager(this).apply {
            orientation = LinearLayoutManager.VERTICAL
        }
        recyclerChat.layoutManager = manager
        adapter = MsgAdapter(msgList)
        recyclerChat.adapter = adapter
        btnSend.setOnClickListener {
            val content = etInput.text.toString()
            if (content.isNotEmpty()) {
                msgList.add(Msg(content, Msg.TYPE_SEND))
                adapter.notifyItemChanged(msgList.size - 1)
                recyclerChat.scrollToPosition(msgList.size - 1)
                etInput.setText("")
            }
        }


        val money1 = Money(3)
        val money2 = Money(5)
        val money = money1 + money2
        Log.v("TAAA", "字符串长度:${"字符串长度".lettersCount()} \t 钱数${money.value}")

    }

    private fun initList(){
        msgList.add(Msg("Hello guy.", Msg.TYPE_RECEIVED))
        msgList.add(Msg("Hello. Who is that?", Msg.TYPE_SEND))
        msgList.add(Msg("This is Tom. Nice talking to you. ", Msg.TYPE_RECEIVED))
    }

    class MsgAdapter(private val msgList: List<Msg>) : RecyclerView.Adapter<MsgViewHolder>() {

        override fun getItemViewType(position: Int): Int {
            val msg = msgList[position]
            return msg.type
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            if (viewType == Msg.TYPE_RECEIVED) {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.msg_left_item, parent, false)
                LeftViewHolder(view)
            } else {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.msg_right_item, parent, false)
                RightViewHolder(view)
            }

        override fun getItemCount() = msgList.size

        override fun onBindViewHolder(holder: MsgViewHolder, position: Int) {
            val msg = msgList[position]
            when (holder) {
                is LeftViewHolder -> holder.leftMsg.text = msg.content
                is RightViewHolder -> holder.rightMsg.text = msg.content
            }
        }
    }
}
