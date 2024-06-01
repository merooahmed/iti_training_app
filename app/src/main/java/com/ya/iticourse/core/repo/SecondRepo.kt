package com.ya.iticourse.core.repo

import com.ya.iticourse.core.data_source.remote.RetrofitClient
import com.ya.iticourse.core.model.Post
import com.ya.iticourse.core.model.body.SecondBodyRequest
import com.ya.iticourse.core.model.response.UserResponse
import retrofit2.Response

class SecondRepo {
    val retrofit = RetrofitClient.getInstance("https://jsonplaceholder.typicode.com")

    suspend fun getPost(userId:Int):Response<ArrayList<Post> >{
        return retrofit.getPostsByUser(userId)

    }



}