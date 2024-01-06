package com.example.todorecycleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todorecycleview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        val todos = listOf(
            Todo("비디오 1개 만들기", false),
            Todo("오디오 1개 만들기", false),
            Todo("라면 1개 만들기", false),
            Todo("유튜브 1개 만들기", false),
            Todo("치지직 1개 만들기", false),
            Todo("게임 1개 만들기", false),
            Todo("계란 1개 만들기", false),
            Todo("바다물고기 1개 만들기", false),
            Todo("블루투스 1개 만들기", false),
            Todo("문상5천원 1개 만들기", false),
            Todo("문상5천원 1개 만들기", false),
            Todo("문상5천원 1개 만들기", false),
            Todo("문상5천원 1개 만들기", false),
            Todo("문상5천원 1개 만들기", false),
            Todo("문상5천원 1개 만들기", false)
        )

        with(binding) {
            rvList.layoutManager =
                LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
            rvList.adapter = TodoAdapter(todos)

        }
    }
}