package com.adifkz.utsppb.Mubaligh

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.adifkz.utsppb.R
import kotlinx.android.synthetic.main.activity_mubaligh_detail.*

class MubalighDetail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mubaligh_detail)
        setToolbar()
        setOnLayout()
    }
    fun setOnLayout(){
        val data = intent!!.extras
        nama.text = data!!.getString("nama")
        desc.text = data!!.getString("desc")
        alamat.text = data!!.getString("alamat")
            telepon.text = data!!.getString("telepon")
        image.setImageResource(data!!.getInt("image"))
        spesifikasi.text = data.getString("spesifikasi")
    }
    fun setToolbar() {
        setSupportActionBar(toolbar);
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowTitleEnabled(false)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}
