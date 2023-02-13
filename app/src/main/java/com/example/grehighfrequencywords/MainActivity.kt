package com.example.grehighfrequencywords

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.example.grehighfrequencywords.feed.data.NetworkRequest
import com.example.grehighfrequencywords.feed.data.Word
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import okhttp3.*
import java.io.IOException
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    lateinit var networkRequest: NetworkRequest
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.getWordsButton).setOnClickListener {
            networkRequest = NetworkRequest()
            networkRequest.sendRequest()
        }
    }
}