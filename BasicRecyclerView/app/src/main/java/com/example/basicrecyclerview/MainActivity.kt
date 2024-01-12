package com.example.basicrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.brandongogetap.stickyheaders.StickyLayoutManager
import com.brandongogetap.stickyheaders.exposed.StickyHeaderHandler
import com.example.basicrecyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val dataList = mutableListOf<LegendItem>(
            LegendItem.MyTitle("어썰트"),
            LegendItem.MyItem(R.drawable.fuse, "퓨즈", "어썰트"),
            LegendItem.MyItem(R.drawable.bangalore, "방갈로르", "어썰트"),
            LegendItem.MyItem(R.drawable.ash, "애쉬", "어썰트"),
            LegendItem.MyTitle("리콘"),
            LegendItem.MyItem(R.drawable.bloodhound, "블러드하운드", "리콘"),
            LegendItem.MyItem(R.drawable.crypto, "크립토", "리콘"),
            LegendItem.MyItem(R.drawable.seer, "시어", "리콘"),
            LegendItem.MyTitle("서포트"),
            LegendItem.MyItem(R.drawable.mirage, "미라지", "서포트"),
            LegendItem.MyItem(R.drawable.conduit, "콘딧", "서포트"),
            LegendItem.MyItem(R.drawable.lifeline, "라이프라인", "서포트"),
            LegendItem.MyItem(R.drawable.gibraltar, "지브롤터", "서포트"),
            LegendItem.MyTitle("스커미셔"),
            LegendItem.MyItem(R.drawable.horizon, "호라이즌", "스커미셔"),
            LegendItem.MyItem(R.drawable.octain, "옥테인", "스커미셔"),
            LegendItem.MyItem(R.drawable.race, "레이스", "스커미셔"),
            LegendItem.MyItem(R.drawable.valkyrie, "발키리", "스커미셔")
        )

        with(binding) {
            rvMain.adapter = LegendAdapter(dataList).apply {
                itemClick = object : LegendAdapter.ItemClick {
                    override fun onClick(view: View, position: Int) {
                        Log.d("Click", "MainActivity : $position")
                        Toast.makeText(this@MainActivity, (dataList[position] as LegendItem.MyItem).name, Toast.LENGTH_SHORT).show()
                    }
                }
                rvMain.layoutManager = LinearLayoutManager(this@MainActivity,LinearLayoutManager.VERTICAL,false)
                rvMain.setHasFixedSize(true)
            }

            rvMain.addItemDecoration( // Sticky Header 구현을 위한
                HeaderItemDecoration(recyclerView = binding.rvMain, isHeader = { position: Int ->
                        dataList[position] is LegendItem.MyTitle
                    }))
        }
    }
}