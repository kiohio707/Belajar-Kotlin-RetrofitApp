package com.example.retrofitapp.model

data class CommentResponsesModel(
    val postId: Int,
    val id: Int,
    val name: String,
    val email: String,
    val body: String
)
