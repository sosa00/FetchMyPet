package com.example.labExtra5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SlideshowActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        this.setTitle("SlideShow");
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slideshow)
    }
}