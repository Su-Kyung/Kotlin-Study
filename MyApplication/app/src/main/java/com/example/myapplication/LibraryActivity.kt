package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_library.*

class LibraryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_library)

        Glide.with(this@LibraryActivity)
            .load("https://c2.staticflickr.com/9/8874/27787597153_a6db36a2d9_b.jpg")
            .centerCrop()
            .into(glide)

        Glide.with(this@LibraryActivity)
            .load("https://c2.staticflickr.com/9/8874/27787597153_a6db36a2d9_b.jpg")
            .into(glide2)
    }
}