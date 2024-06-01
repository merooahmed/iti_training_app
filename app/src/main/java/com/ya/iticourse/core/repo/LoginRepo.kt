package com.ya.iticourse.core.repo

import com.ya.iticourse.core.data_source.remote.RetrofitClient
import com.ya.iticourse.core.model.body.LoginBodyRequest
import com.ya.iticourse.core.model.response.UserResponse
import retrofit2.Response

class LoginRepo {

        val retrofit = RetrofitClient.getInstance("https://dummyjson.com/")

     suspend fun login(username:String,password:String):Response<UserResponse>{
        return retrofit.login(LoginBodyRequest(username,password))
    }
}