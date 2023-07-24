package com.example.test10_11_12.test11

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.test10_11_12.databinding.ActivityJetBinding

class JetActivity : AppCompatActivity() {
    lateinit var binding: ActivityJetBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJetBinding.inflate(layoutInflater)
        setContentView(binding.root)



        //툴바를 직접 만들어 붙이는 작업
        //뷰와 뒷단 코드 가져오기
        setSupportActionBar(binding.toolbar)



    }
    //메뉴, 액션바 기초

//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        //화면 출력하기 위한 객체 생성(인스턴스화)
//        val inflater = menuInflater
//        inflater.inflate(R.menu.menu, menu)
//
//        return true
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId) {
//        R.id.menu1 -> {
//            Log.d("kkang", "menu1 click")
//            Toast.makeText(this@JetActivity, "menu1 클릭됨", Toast.LENGTH_SHORT).show()
//            true
//        }
//
//        R.id.menu2 -> {
//            Log.d("kkang", "menu2 click")
//            Toast.makeText(this@JetActivity, "menu2 클릭됨", Toast.LENGTH_SHORT).show()
//            true
//        }
//        R.id.menu3 -> {
//            Log.d("kkang", "menu3 click")
//            Toast.makeText(this@JetActivity, "menu3 클릭됨", Toast.LENGTH_SHORT).show()
//            true
//        }
//        R.id.menu4 -> {
//            Log.d("kkang", "menu4 click")
//            Toast.makeText(this@JetActivity, "menu4 클릭됨", Toast.LENGTH_SHORT).show()
//            true
//        }
//        R.id.menu5 -> {
//            Log.d("kkang", "menu5 click")
//            Toast.makeText(this@JetActivity, "menu5 클릭됨", Toast.LENGTH_SHORT).show()
//            true
//        }
//        else -> super.onOptionsItemSelected(item)
//    }
}