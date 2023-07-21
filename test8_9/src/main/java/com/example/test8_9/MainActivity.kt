package com.example.test8_9

import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    val TAG : String = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when (event?.action) {
            MotionEvent.ACTION_DOWN -> {
                //로깅 관련된 프로그램 d: debug, e: error
                Log.d(TAG,
                    "Touch down event x: ${event.x}, rawX: ${event.rawX} y: ${event.y}, rawY: ${event.rawY}")
            }
            MotionEvent.ACTION_UP -> {
                Log.d(TAG, "Touch up event")
            }
        }
        return super.onTouchEvent(event)
    }
}