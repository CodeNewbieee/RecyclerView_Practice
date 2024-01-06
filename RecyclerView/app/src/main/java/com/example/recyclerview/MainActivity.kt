package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val profileList = arrayListOf(
            Profiles(R.drawable.man,"콩진호",25,"의사"),
            Profiles(R.drawable.woman,"문수경", 30, "기타리스트"),
            Profiles(R.drawable.woman,"신예지", 28, "싱어"),
            Profiles(R.drawable.man,"임요환",25,"프로그래머"),
            Profiles(R.drawable.man,"김진수",17,"학생"),
            Profiles(R.drawable.woman,"문복희", 38, "유튜버"),
            Profiles(R.drawable.man,"손흥민",29,"축구선수"),
            Profiles(R.drawable.woman,"박수유", 42, "주부"),
            Profiles(R.drawable.man,"서장훈",34,"농구선수"),
            Profiles(R.drawable.woman,"김예쓸", 38, "앱개발자"),
            Profiles(R.drawable.woman,"최수정", 38, "프론트엔드개발자")
        )

        with(binding) {
            rvProfile.layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
            rvProfile.setHasFixedSize(true) // 리사이클러 뷰의 크기가 변할일이 없음을 알려줌 , 아이템 뷰가 재활용 되어 배치될때마다 전체레이아웃 크기를 다시 잴 필요가 없다(고비용 작업 줄이기)
            rvProfile.adapter=ProfileAdapter(profileList)

        }

    }
}