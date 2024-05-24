package com.ammartech.submissionaplikasiandroidpemula

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DetailActivity : AppCompatActivity() {

    companion object{
        const val key_martial = "key_martial"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val tvDetailName = findViewById<TextView>(R.id.tv_detail_name)
        val tvDetailDescription = findViewById<TextView>(R.id.tv_detail_description)
        val ivDetailPhoto = findViewById<ImageView>(R.id.iv_detail_photo)

        val dataMartial = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Martial>(key_martial, Martial::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Martial>(key_martial)
        }

        if (dataMartial != null) {
            tvDetailName.text = dataMartial.name
            tvDetailDescription.text = dataMartial.description
            ivDetailPhoto.setImageResource(dataMartial.photo)
        }
    }

}