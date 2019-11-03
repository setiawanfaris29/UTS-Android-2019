package com.adifkz.utsppb.Kegiatan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.adifkz.utsppb.R
import com.google.android.material.appbar.AppBarLayout
import kotlinx.android.synthetic.main.activity_kegiatan_detail.*

class KegiatanDetail : AppCompatActivity() {
    data class DetailKegiatan(val id:String,val desc:String)
    var titleToolbar :String?=null
    val dataGlobal = ArrayList<DetailKegiatan>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kegiatan_detail)
        init()
        setToolbar()
        setToLayout()
    }
    fun init(){
        dataGlobal.add(DetailKegiatan("1","Ini Adalah data yang ada 1"))
        dataGlobal.add(DetailKegiatan("2","Ini Adalah data yang ada 2"))
        dataGlobal.add(DetailKegiatan("3","Ini Adalah data yang ada 2"))
    }

    fun setToolbar() {
        setSupportActionBar(toolbar);
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowTitleEnabled(false)
        appbar_component.addOnOffsetChangedListener(object : AppBarLayout.OnOffsetChangedListener {
            var titleIsShowing = false
            override fun onOffsetChanged(appBarLayout: AppBarLayout, verticalOffset: Int) {
                if (appBarLayout.totalScrollRange + verticalOffset == 0) {
                    collapsToolbar.title = titleToolbar
                    titleIsShowing = true
                } else if (titleIsShowing) {
                    collapsToolbar.title = " "
                    titleIsShowing = false
                }
            }
        })
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

    fun setToLayout(){
        val intent = intent?.extras
        desc.text = dataGlobal.find{T:DetailKegiatan->
            T.id == intent!!.getString("id")
        }!!.desc
        titleToolbar = intent?.getString("title")
        intent!!.getInt("image")!!.let { image.setImageResource(it) }
        date.text = intent!!.getString("date")
        judul.text = titleToolbar
    }
}
