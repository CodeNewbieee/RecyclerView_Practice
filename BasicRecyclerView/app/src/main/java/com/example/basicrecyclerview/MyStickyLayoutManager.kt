package com.example.basicrecyclerview

import android.content.Context
import com.brandongogetap.stickyheaders.StickyLayoutManager
import com.brandongogetap.stickyheaders.exposed.StickyHeaderHandler

class MyStickyLayoutManager constructor(context: Context, headerHandler: StickyHeaderHandler)
    : StickyLayoutManager(context, headerHandler) {

    override fun scrollToPosition(position: Int) {
        super.scrollToPositionWithOffset(position, 0)
    }
}