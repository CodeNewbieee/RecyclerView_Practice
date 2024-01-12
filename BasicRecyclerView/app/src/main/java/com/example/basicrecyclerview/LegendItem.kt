package com.example.basicrecyclerview

sealed class LegendItem {
    data class MyItem(val photo : Int, val name : String, val type: String) : LegendItem()
    data class MyTitle(val type : String) : LegendItem()
}