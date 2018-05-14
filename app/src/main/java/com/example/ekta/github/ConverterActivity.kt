package com.example.ekta.github

import android.app.Activity
import android.os.Bundle
import android.util.Log

/**
 * Created by Grappus on 14/05/18.
 */

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
