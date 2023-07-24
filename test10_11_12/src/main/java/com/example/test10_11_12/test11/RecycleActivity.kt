package com.example.test10_11_12.test11

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.test10_11_12.adapter.MyAdapter
import com.example.test10_11_12.databinding.ActivityRecycleBinding

//리사이클러 뷰를 출력 해주는 빈 도화지
class RecycleActivity : AppCompatActivity() {

    lateinit var binding : ActivityRecycleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecycleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //순서 구성요소
        //1) 뷰 홀더 생성 : 어댑터 내부에 정의가 되었음 예) MyViewHolder
        //2) 어댑터 생성 : 기존 샘플
        //3) 설정한 리사이클러 뷰를 메인(RecycleActivity)에 적용한 임시 데이터 ,
        //4) 원래 공공 데이터 등 DB에서 가져온 정보를 사용
        val datas = mutableListOf<String>()
        for(i in 1..9){
            datas.add("Item $i")
        }

        //RecycleActivity 여기 xml에 출력할 리사이클러뷰를 설정

        //만들었던 리사클러 뷰를 현재 액티비티에 적용
        //순서대로 세로방향으로 출력

        //옵션에서 출력의 모양을 정하는 부분
        //보통 리니어 세로, 가로 방향으로 출력하고
        //표 형식이나 지그재그로 표현하는 옵션이 있음
        //구현 옵션만 변경해서 확인

        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL

                //기존코드
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        //변경코드
        binding.recyclerView.layoutManager = layoutManager

        //리사이클러 뷰의 어댑터를 내가 만든 어댑터에 연결
        //뷰와 데이터를 연결 해주는 역할
        binding.recyclerView.adapter = MyAdapter(datas)
        // 목록의 요소를 꾸며주는 역할. ex) 이미지, 구분선을 넣는 등
        // 목록의 요소의 크기 및 배치, 색깔 등을 정할 수 있음
//        binding.recyclerView.addItemDecoration(
//            DividerItemDecoration(this,
//                LinearLayoutManager.VERTICAL)
//        )
    }
}
