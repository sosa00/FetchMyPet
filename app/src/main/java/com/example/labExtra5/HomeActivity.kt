package com.example.labExtra5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        this.setTitle("Home");
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
    }
}