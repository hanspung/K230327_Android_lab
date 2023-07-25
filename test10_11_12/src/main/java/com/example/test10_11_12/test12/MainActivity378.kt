package com.example.test10_11_12.test12

import android.content.Context
import android.graphics.Color
import android.graphics.Rect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.test10_11_12.R
import com.example.test10_11_12.adapter.MyAdapter
import com.example.test10_11_12.databinding.ActivityMain378Binding
import com.example.test10_11_12.test11.Recycle2Activity



//복붙 후 컴파일러 에러 부분
//리사이클러뷰에서 아이템 구성요소
//메뉴 아이템 뷰 부분이 없어서 1차 문법 체크가 남
class MainActivity378 : AppCompatActivity() {
    lateinit var binding: ActivityMain378Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain378Binding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val datas = mutableListOf<String>()
        for (i in 1..20) {
            datas.add("Item $i")
        }

        val layoutManager = LinearLayoutManager(this)
        binding.recyclerview.layoutManager = layoutManager
        val adapter = MyAdapter(datas)
        binding.recyclerview.adapter = adapter
        binding.recyclerview.addItemDecoration(Recycle2Activity.MyDecoration(this))
    }
}