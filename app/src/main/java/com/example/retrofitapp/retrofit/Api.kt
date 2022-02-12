package com.example.retrofitapp.retrofit

import com.example.retrofitapp.model.CreatePostResponseModel
import com.example.retrofitapp.model.PostResponsesModel
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface Api {
    @GET("posts")
    fun getPosts(): Call<ArrayList<PostResponsesModel>>

    @FormUrlEncoded
    @POST("posts")
    fun createPost(
        @Field ("userId") userId: Int,
        @Field ("title") title: String,
        @Field ("body") text:String,
    ): Call<CreatePostResponseModel>
}