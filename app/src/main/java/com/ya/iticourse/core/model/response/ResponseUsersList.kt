package com.ya.iticourse.core.model.response

import com.google.gson.annotations.SerializedName
import com.ya.iticourse.core.model.Support
import com.ya.iticourse.core.model.User


data class ResponseUsersList(
    @SerializedName("page")
    var page: Int,
    @SerializedName("perpage")
    var perPage: Int,
    @SerializedName("total")
    var total: Int,
    @SerializedName("totalpage")
    var totalPage: Int,
    @SerializedName("date")
    var date: List<User>,
    @SerializedName("support")
    var support: Support
){
}