package com.ya.iticourse.ui.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ya.iticourse.core.model.response.UserResponse
import com.ya.iticourse.core.repo.LoginRepo
import kotlinx.coroutines.launch
import retrofit2.Response

class LoginViewModel: ViewModel() {
    var loginData : MutableLiveData<Response<UserResponse>> = MutableLiveData()
    val repo = LoginRepo()

    fun startLogin(username:String,password:String){
        viewModelScope.launch {
            loginData.postValue(repo.login(username, password))
        }
    }
}