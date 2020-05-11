package com.tzt.studykt.four

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.get
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.tzt.studykt.R
import kotlinx.android.synthetic.main.activity_staggered_grid.*
import java.lang.StringBuilder
import java.util.ArrayList

class StaggeredGridActivity : AppCompatActivity() {
    private val fruitList = ArrayList<Fruit>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_staggered_grid)

        initList()
        val manager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)
        recyclerStag.layoutManager = manager
        val adapter = FruitAdapter(fruitList)
        recyclerStag.adapter = adapter
    }

    private fun initList() {
        repeat(3){
            fruitList.add(Fruit(getRandomLengthName("apple"), R.mipmap.apple_pic))
            fruitList.add(Fruit(getRandomLengthName("banana"), R.mipmap.banana_pic))
            fruitList.add(Fruit(getRandomLengthName("orange"), R.mipmap.orange_pic))
            fruitList.add(Fruit(getRandomLengthName("watermelon"), R.mipmap.watermelon_pic))
            fruitList.add(Fruit(getRandomLengthName("pear"), R.mipmap.pear_pic))
            fruitList.add(Fruit(getRandomLengthName("grape"), R.mipmap.grape_pic))
            fruitList.add(Fruit(getRandomLengthName("pineapple"), R.mipmap.pineapple_pic))
            fruitList.add(Fruit(getRandomLengthName("strawberry"), R.mipmap.strawberry_pic))
            fruitList.add(Fruit(getRandomLengthName("cherry"), R.mipmap.cherry_pic))
            fruitList.add(Fruit(getRandomLengthName("mango"), R.mipmap.mango_pic))
        }
    }

    private fun getRandomLengthName(str: String): String {
        val n = (1..20).random()
        val builder = StringBuilder()
        repeat(n) {
            builder.append(str)
        }
        return builder.toString()
    }

    class FruitAdapter(val fruitList: List<Fruit>) : RecyclerView.Adapter<FruitAdapter.FruitViewHolder>() {
        inner class FruitViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val fruitName: TextView = view.findViewById(R.id.tvFruitName)
            val fruitImage: ImageView = view.findViewById(R.id.ivFruit)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FruitViewHolder {
            return FruitViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.fruit_item, parent, false))
        }

        override fun getItemCount(): Int {
            return fruitList.size
        }

        override fun onBindViewHolder(holder: FruitViewHolder, position: Int) {
            val fruit = fruitList[position]
            holder.fruitImage.setImageResource(fruit.imgId)
            holder.fruitName.text = fruit.name
        }
    }
}
