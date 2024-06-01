package com.ya.iticourse.ui

import com.ya.iticourse.core.model.Post

interface MyCustomClickListener {
    fun onItemClick(post: Post, position:Int)
}

