package com.example.retrofitapp.model

import com.google.gson.annotations.SerializedName

data class PostResponsesModel(
    val userId: Int,
    val id: Int,
    val title: String?,
    @SerializedName("body")
    val text: String?
)
