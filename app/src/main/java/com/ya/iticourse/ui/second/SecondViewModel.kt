package com.ya.iticourse.ui.second

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ya.iticourse.core.model.Post
import com.ya.iticourse.core.model.response.UserResponse
import com.ya.iticourse.core.repo.SecondRepo
import kotlinx.coroutines.launch
import retrofit2.Response

class SecondViewModel : ViewModel() {
    var secondData : MutableLiveData<Response<ArrayList<Post>>> = MutableLiveData()
    val  repo = SecondRepo()

    fun startSecond(userId:Int){
        viewModelScope.launch {
            secondData.postValue(repo.getPost(userId))
        }
    }
}