package com.example.grehighfrequencywords

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import okhttp3.*

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}