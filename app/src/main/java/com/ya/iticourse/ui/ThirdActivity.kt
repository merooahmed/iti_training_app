package com.ya.iticourse.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.ya.iticourse.R

import com.ya.iticourse.ui.CommentAdapter
import com.ya.iticourse.ui.MyCustomClickListener
import com.ya.iticourse.databinding.ActivityThirdBinding
import com.ya.iticourse.core.model.Post
import com.ya.iticourse.core.data_source.remote.ApiInterface
import com.ya.iticourse.core.data_source.remote.RetrofitClient
import kotlinx.coroutines.launch

class ThirdActivity:AppCompatActivity(), MyCustomClickListener {
    lateinit var binding: ActivityThirdBinding
    lateinit var reycleview: RecyclerView
    lateinit var retrofit: ApiInterface
    lateinit var commentAdapter: CommentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val Id = intent.extras?.getInt("postId", 1)
        retrofit = RetrofitClient.getInstance("https://jsonplaceholder.typicode.com/")

        reycleview = findViewById(R.id.recyclerView)
        reycleview.setHasFixedSize(true)
        reycleview.layoutManager = LinearLayoutManager(this@ThirdActivity)

        lifecycleScope.launch{
            val response = retrofit.getComments(Id?:0)
            if (response.isSuccessful) {
                commentAdapter = CommentAdapter(response.body() ?: listOf(), this@ThirdActivity)
                reycleview.layoutManager = LinearLayoutManager(this@ThirdActivity)
                binding.recyclerView.adapter = commentAdapter

            }


        }

    }
    override fun onItemClick(post: Post, position: Int) {
        intent.putExtra("postId", post.id)
    }
}