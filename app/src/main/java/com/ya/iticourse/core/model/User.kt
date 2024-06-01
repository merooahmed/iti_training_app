package com.ya.iticourse.core.model

import com.google.gson.annotations.SerializedName

class User(
    @SerializedName("id")
    var id: Int,
    @SerializedName("firstName")
    var firstName: String,
    @SerializedName("lastName")
    var lastName: String,
    @SerializedName("email")
    var email: String,
    @SerializedName("avatar")
    var avatar: String) {
}