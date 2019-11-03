package com.adifkz.utsppb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import technolifestyle.com.imageslider.FlipperView
import android.widget.ImageView.ScaleType
import technolifestyle.com.imageslider.FlipperLayout
import android.view.View
import android.widget.ImageView
import androidx.core.content.ContextCompat
import com.adifkz.utsppb.Cari.Cari
import com.adifkz.utsppb.Kegiatan.Kegiatan
import com.adifkz.utsppb.Khutbah.Khutbah
import com.adifkz.utsppb.Mubaligh.Mubaligh
import com.adifkz.utsppb.Profile.Profile
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    data class HomeImageSlider(val desc: String, val image: Int)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        onLoad()

    }
    fun onClickOpen(it:View){
        val Button = it as ImageView
        when(Button.id){
            profile.id->startActivity(Intent(this, Profile::class.java))
            kegiatan.id->startActivity(Intent(this, Kegiatan::class.java))
            cari.id->startActivity(Intent(this, Cari::class.java))
            khutbah.id->startActivity(Intent(this, Khutbah::class.java))
            mubaligh.id->startActivity(Intent(this, Mubaligh::class.java))
        }
    }

    fun onLoad(){
       imageSlider()
    }
    fun imageSlider(){
        val flipperLayout = findViewById(R.id.flipper_layout) as FlipperLayout
        val x = ArrayList<HomeImageSlider>()
        x.add(HomeImageSlider("test 2", R.drawable.bt_home_cari))
        x.add(HomeImageSlider("test 1", R.drawable.bt_home_jadwal))
        x.add(HomeImageSlider("test 4", R.drawable.bt_home_khutbah))

        for (i in 0 until x.size) {
            val view = FlipperView(baseContext)
            view.setImageScaleType(ScaleType.FIT_XY) // You can use any ScaleType
                .setDescription(x[i].desc) // Add custom description for your image in the flipper view
                .setImageDrawable(ContextCompat.getDrawable(this, x[i].image)) { imageView, image ->
                    imageView.setImageDrawable(image)
                }
                .setDescriptionBackgroundColor(0)
//                .setOnFlipperClickListener(object : FlipperView.OnFlipperClickListener {
//                    override fun onFlipperClick(flipperView: FlipperView) {
//                        // Handle View Click here
//                    }
//                })
            flipperLayout.scrollTimeInSec = 5 //setting up scroll time, by default it's 3 seconds
            flipperLayout.scrollTimeInSec //returns the scroll time in sec
            flipperLayout.setIndicatorBackground(null)
            flipperLayout.showInnerPagerIndicator()
            flipperLayout.addFlipperView(view)
        }
    }
}
