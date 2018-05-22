package com.example.ekta.github

import android.app.Activity
import android.os.Bundle
import android.util.Log



class ConverterActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    companion object {

        internal var sum = 0
        fun myMethod() {
            Log.i("TAG", "hello")
        }
    }
}
