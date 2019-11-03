package com.adifkz.utsppb.Cari

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.adifkz.utsppb.R
import kotlinx.android.synthetic.main.activity_cari_detail.*

class CariDetail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cari_detail)

        val data:Cari.Item = intent.getSerializableExtra("data") as Cari.Item
        alamat.text = data.alamat
        image.setImageResource(data.image)
        name.text = data.nama

    }
}
