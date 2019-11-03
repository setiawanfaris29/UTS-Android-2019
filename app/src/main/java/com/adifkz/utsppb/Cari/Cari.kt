package com.adifkz.utsppb.Cari

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
import kotlinx.android.synthetic.main.activity_cari.*
import kotlinx.android.synthetic.main.activity_cari_list_component.view.*

class Cari : AppCompatActivity() {
    data class Item(val alamat: String, val nama: String, val image: Int, val id: String)

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    var myDataset = ArrayList<Item>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cari)
        setToolbar()
        initialMyDataSet()
        setRecycleLayout()
    }

    fun setToolbar() {
        setSupportActionBar(toolbar);
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
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
        dataLength.text = myDataset.size.toString() + " Masjid Terdekat < 2KM"
    }

    fun setRecycleLayout(){
        viewManager = LinearLayoutManager(this)
        viewAdapter = MyAdapter(this, myDataset)

        recyclerView = findViewById<RecyclerView>(listMasjid.id).apply {
            setHasFixedSize(true)
            // use a linear layout manager
            layoutManager = viewManager
            // specify an viewAdapter (see also next example)
            adapter = viewAdapter

        }
    }

    class MyAdapter(val context: Context, private val myDataset: ArrayList<Item>) :
        RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
        inner class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
            fun bindData(item: Item) {
                view.image.setImageResource(item.image)
                view.nama.text = item.nama
                view.alamat.text = item.alamat
                view.setOnClickListener {
                    val nextPage = Intent(context, CariDetail::class.java)
                    nextPage.putExtra("id",item.id)
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
                .inflate(R.layout.activity_cari_list_component, parent, false)
            return MyViewHolder(view)
        }

        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
            holder.bindData(myDataset[position])
        }

        override fun getItemCount() = myDataset.size
    }
}
