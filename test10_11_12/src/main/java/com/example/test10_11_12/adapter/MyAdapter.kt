package com.example.test10_11_12.adapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.test10_11_12.R
import com.example.test10_11_12.databinding.Item342Binding

// 뷰 홀더 매개변수 : 목록의 구성요소(아이템),
class MyViewHolder(val binding: Item342Binding): RecyclerView.ViewHolder(binding.root)
//어댑터 매개변수 : 현재 임시 데이터(액티비티에 현재 있고), 원래는 네트워크 라이브러리 사용해서 데이터 가져 올 예정
class MyAdapter(val datas: MutableList<String>): RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    override fun getItemCount(): Int{
        Log.d("kkang", "init datas size: ${datas.size}")
        return datas.size
    }

    //목록의 요소를 자동으로 갯수를 파악해서 출력 해주는 역할
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder
            = MyViewHolder(Item342Binding.inflate(LayoutInflater.from(parent.context), parent, false))

    //데이터와 뷰를 연결하는 역할
    //데이터가 변경이 될때마다, 여기 함수가 자동으로 호출
    //받아온 데이터를 해당 뷰에 연결해서 보여주는 역할
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        Log.d("kkang","onBindViewHolder : $position")
        val binding=(holder as MyViewHolder).binding
        //뷰에 데이터 출력
        binding.itemData.text= datas[position]

        //뷰에 이벤트 추가
        binding.itemRoot.setOnClickListener{
            //보통 상세페이지 연결을 많이 함
            Log.d("kkang", "item root click : $position")
        }
        //목록에 데이터를 임의로 받아오는 부분이 아니라, 기존 데이터에 추가, 수정을 할때
        //반영이 안되는 경우가 있음. 그럴 때 사용하는 함수.
//        notifyDataSetChanged()
    }
}