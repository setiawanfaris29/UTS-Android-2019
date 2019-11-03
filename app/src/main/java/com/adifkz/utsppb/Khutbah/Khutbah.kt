package com.adifkz.utsppb.Khutbah

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.adifkz.utsppb.R
import kotlinx.android.synthetic.main.activity_khutbah.*
import kotlinx.android.synthetic.main.activity_khutbah_list_component.view.*

class Khutbah : AppCompatActivity() {
    data class Item(val title: String, val subTitle: String, val url: String)

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager


    var myDataset = ArrayList<Item>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_khutbah)
        setToolbar()
        initialMyDataSet()
        setRecycleLayout()
    }
    fun setToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

    fun initialMyDataSet(){
        myDataset.add(
            Item(
                "test1 Tos TOs tis tus tos",
                "2019",
                "http"
            )
        )
        myDataset.add(
            Item(
                "test2 Tos TOs tis tus tos",
                "2018",
                "http"
            )
        )
        myDataset.add(
            Item(
                "test3 Tos TOs tis tus tos",
                "2017",
                "http"
            )
        )
        dataLength.text = myDataset.size.toString() + " Materi Khutbah ditemukan"
    }

    fun setRecycleLayout(){
        viewManager = LinearLayoutManager(this)
        viewAdapter = MyAdapter(this, myDataset)

        recyclerView = findViewById<RecyclerView>(listKhutbah.id).apply {
            setHasFixedSize(true)
            // use a linear layout manager
            layoutManager = viewManager
            // specify an viewAdapter (see also next example)
            adapter = viewAdapter

        }
    }

    class MyAdapter(val context: Context, private val myDataset: ArrayList<Item>) :
        RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
        class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
            fun bindData(item: Item) {
                view.title.text = item.title
                view.subTitle.text = item.subTitle
//                view.findViewById<TextView>(R.id.date).text = item.date
            }
        }

        override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
        ): MyViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.activity_khutbah_list_component, parent, false)
            return MyViewHolder(view)
        }

        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
            holder.bindData(myDataset[position])
        }

        override fun getItemCount() = myDataset.size
    }
}
