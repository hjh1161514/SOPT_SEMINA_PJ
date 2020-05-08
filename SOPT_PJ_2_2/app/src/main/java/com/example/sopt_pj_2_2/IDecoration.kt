package com.example.sopt_pj_2_2

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class IDecoration : RecyclerView.ItemDecoration() {
    override fun getItemOffsets( //RecyclerView 안에 있는 아이템에 여백을 설정
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect.set(20,10,20,10)
    }
}