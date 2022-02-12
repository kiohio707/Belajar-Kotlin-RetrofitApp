package com.example.retrofitapp.model

import com.google.gson.annotations.SerializedName

data class CreatePostResponseModel(
    val userId: String?,
    val id: Int,
    val title: String?,
    @SerializedName("body")
    val text: String?
)