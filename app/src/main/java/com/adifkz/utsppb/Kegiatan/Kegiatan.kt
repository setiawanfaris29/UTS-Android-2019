package com.adifkz.utsppb.Kegiatan

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.adifkz.utsppb.R
import kotlinx.android.synthetic.main.activity_kegiatan.*
import kotlinx.android.synthetic.main.activity_kegiatan_list_component.view.*

class Kegiatan : AppCompatActivity() {
    data class Item(val title: String, val date: String, val image: Int, val id: String)

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    var myDataset = ArrayList<Item>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kegiatan)
        setToolbar()
        initialMyDataSet()
        setRecycleLayout()
    }

    fun initialMyDataSet(){
        myDataset.add(
            Item(
                "test1 Tos TOs tis tus tos",
                "2019",
                R.drawable.bt_home_jadwal,
                "1"
            )
        )
        myDataset.add(
            Item(
                "test2 Tos TOs tis tus tos",
                "2018",
                R.drawable.bt_home_jadwal,
                "2"
            )
        )
        myDataset.add(
            Item(
                "test3 Tos TOs tis tus tos",
                "2017",
                R.drawable.bt_home_jadwal,
                "3"
            )
        )
        myDataset.add(
            Item(
                "test4 Tos TOs tis tus tos",
                "2016",
                R.drawable.bt_home_jadwal,
                "4"
            )
        )
        dataLength.text = myDataset.size.toString() + " Kegiatan ditemukan"
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

    fun setToolbar() {
        setSupportActionBar(toolbar);
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    fun setRecycleLayout(){
        viewManager = LinearLayoutManager(this)
        viewAdapter = MyAdapter(this, myDataset)

        recyclerView = findViewById<RecyclerView>(listKegiatan.id).apply {
            setHasFixedSize(true)
            // use a linear layout manager
            layoutManager = viewManager
            // specify an viewAdapter (see also next example)
            adapter = viewAdapter

        }
    }

    class MyAdapter(val context: Context,private val myDataset: ArrayList<Item>) :
        RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
        inner class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
            fun bindData(item: Item) {
                view.image.setImageResource(item.image)
                view.title.text = item.title
                view.date.text = item.date
                view.setOnClickListener {
                    val nextPage = Intent(context, KegiatanDetail::class.java)
                    nextPage.putExtra("id",item.id)
                    nextPage.putExtra("date",item.date)
                    nextPage.putExtra("image",item.image)
                    nextPage.putExtra("title",item.title)
                    context.startActivity(nextPage)
                }
//                view.findViewById<TextView>(R.id.date).text = item.date
            }
        }

        override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
        ): MyViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.activity_kegiatan_list_component, parent, false)
            return MyViewHolder(view)
        }

        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
            holder.bindData(myDataset[position])
        }

        override fun getItemCount() = myDataset.size
    }
}
