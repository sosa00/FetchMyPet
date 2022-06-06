package com.example.labExtra5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class GalleryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        this.setTitle("Gallery");
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery2)
    }
}