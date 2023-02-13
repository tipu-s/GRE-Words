package com.example.grehighfrequencywords.feed.data

import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import okhttp3.*
import java.io.IOException
import kotlin.concurrent.thread

class NetworkRequest {
    private val TAG = "NetworkRequest Update"
    private val baseUrl = "http://10.0.2.2/GreWord.json"
    private var responseData = ArrayList<Word>()

    fun sendRequest() {
        thread {
            try {
                val client = OkHttpClient()
                val request = Request.Builder()
                    .url(baseUrl)
                    .build()
                client.newCall(request).enqueue(object : Callback{
                    override fun onFailure(call: Call, e: IOException) {
                        Log.d(TAG, "response fail $e")
                    }

                    override fun onResponse(call: Call, response: Response) {
                        val responseData = response.body?.string()
                        if (responseData != null) {
                            parseData(responseData)
                        }
                    }
                })
            } catch (e : Exception) {
                e.printStackTrace()
            }
        }
    }

    fun parseData(jasonData: String) {
        val gson = Gson()
        val wordList = gson.fromJson(jasonData, GreWords::class.java).greWords
        for (word in wordList) {
            Log.d(TAG, "word: ${word.word}")
            Log.d(TAG, "meaning: ${word.meaning}")
            Log.d(TAG, "examples")
            word.examples.forEach{
                Log.d(TAG, "$it")
            }
            //Log.d(TAG, "example: ${word.example[0]} \n ${word.example[1]}")
        }
    }

    fun getResponse(): ArrayList<Word> {
        return responseData
    }
}