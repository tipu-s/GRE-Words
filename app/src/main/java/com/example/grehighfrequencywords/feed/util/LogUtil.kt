package com.example.grehighfrequencywords.feed.util

import android.util.Log

object LogUtil {
    private const val TAG = "GRE"
    private val CUR_LVL =  Level.VERBOSE

    enum class Level {
        VERBOSE,
        DEBUG,
        INFO,
        WARN,
        ERROR
    }

    fun v(msg: String) {
        if (CUR_LVL <= Level.VERBOSE) {
            Log.v(TAG, msg)
        }
    }

    fun d(msg: String) {
        if (CUR_LVL <= Level.DEBUG) {
            Log.d(TAG, msg)
        }
    }

    fun e(msg: String) {
        if (CUR_LVL <= Level.ERROR) {
            Log.e(TAG, msg)
        }
    }

    fun i(msg: String) {
        if (CUR_LVL <= Level.INFO) {
            Log.i(TAG, msg)
        }
    }

    fun w(msg: String) {
        if (CUR_LVL <= Level.WARN) {
            Log.w(TAG, msg)
        }
    }
}