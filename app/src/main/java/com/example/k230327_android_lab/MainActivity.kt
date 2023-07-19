package com.example.k230327_android_lab



import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun hofFun(arg: (Int) -> Boolean): () -> String {
        val result = if(arg(10)) {
            "valid"
        } else {
            "invalid"
        }
        return {"hofFun result : $result"}
    }
    fun main() {
        val result = hofFun({no -> no > 0})
        println(result())
    }
}