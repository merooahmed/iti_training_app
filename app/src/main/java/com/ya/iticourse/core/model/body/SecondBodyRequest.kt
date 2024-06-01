package com.ya.iticourse.core.model.body

import com.google.gson.annotations.SerializedName

data class SecondBodyRequest(
    @SerializedName("userId")
    val userId:Int

) {
}