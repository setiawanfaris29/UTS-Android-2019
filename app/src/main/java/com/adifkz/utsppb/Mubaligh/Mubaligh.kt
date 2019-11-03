package com.adifkz.utsppb.Mubaligh

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.adifkz.utsppb.R
import kotlinx.android.synthetic.main.activity_mubaligh.*
import kotlinx.android.synthetic.main.activity_mubaligh_list_component.view.*

class Mubaligh : AppCompatActivity() {
    data class Item(val nama: String, val contact: String, val image: Int, val id: String)

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    var myDataset = ArrayList<Item>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mubaligh)
        initialMyDataSet()
        setToolbar()
        setRecycleLayout()
    }
    fun setToolbar() {
        setSupportActionBar(toolbar);
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

    fun initialMyDataSet() {
        myDataset.add(
            Item(
                "Adi Fatkhurozi",
                "2019",
                R.drawable.bt_home_jadwal,
                "1"
            )
        )
        myDataset.add(
            Item(
                "Adi 2",
                "2018",
                R.drawable.bt_home_jadwal,
                "2"
            )
        )
        myDataset.add(
            Item(
                "Adi 4",
                "2017",
                R.drawable.bt_home_jadwal,
                "3"
            )
        )
        dataLength.text = myDataset.size.toString() + " Masjid Terdekat < 2KM"
    }

    fun setRecycleLayout() {
        viewManager = GridLayoutManager(this, 2)
        viewAdapter = MyAdapter(this, myDataset)
        recyclerView = findViewById<RecyclerView>(listMubaligh.id).apply {
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
                view.name.setImageResource(item.image)
                view.nama.text = item.nama
                view.contact.text = item.contact
                view.setOnClickListener {
                        val nextPage = Intent(context,MubalighDetail::class.java)
                        nextPage.putExtra("id",item.id)
                    nextPage.putExtra("id",item.id)
                    nextPage.putExtra("nama",item.nama)
                    nextPage.putExtra("desc","Descripsi")
                    nextPage.putExtra("telepon",item.contact)
                    nextPage.putExtra("alamat","jalan" )
                    nextPage.putExtra("image",item.image)
                        context.startActivity(nextPage)
                }
            }
        }

        override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
        ): MyViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.activity_mubaligh_list_component, parent, false)
            return MyViewHolder(view)
        }

        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
            holder.bindData(myDataset[position])
        }

        override fun getItemCount() = myDataset.size
    }
}
