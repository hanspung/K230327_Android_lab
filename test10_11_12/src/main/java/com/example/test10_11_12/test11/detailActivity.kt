package com.example.test10_11_12.test11

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.test10_11_12.R
import com.example.test10_11_12.databinding.ActivityDetailBinding

class detailActivity : AppCompatActivity() {
    lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_detail)
    }
}