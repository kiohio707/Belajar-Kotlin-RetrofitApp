package com.example.retrofitapp.retrofit

import com.example.retrofitapp.model.CommentResponsesModel
import com.example.retrofitapp.model.CreatePostResponsesModel
import com.example.retrofitapp.model.PostResponsesModel
import retrofit2.Call
import retrofit2.http.*

interface Api {
    @GET("posts")
    fun getPosts(): Call<ArrayList<PostResponsesModel>>

    @FormUrlEncoded
    @POST("posts")
    fun createPost(
        @Field ("userId") userId: Int,
        @Field ("title") title: String,
        @Field ("body") text:String,
    ): Call<CreatePostResponsesModel>

    @GET("posts/1/comments")
    fun getComments(): Call<ArrayList<CommentResponsesModel>>

    @GET("posts/{id}/comments")
    fun getComments(@Path("id") postId: Int): Call<ArrayList<CommentResponsesModel>>

    @GET("posts")
    fun getPosts(@Query("userId")userId: Int): Call<ArrayList<PostResponsesModel>>

    @GET("posts")
    fun getPosts(@Query("userId")userId: Int,
    @Query("id")id: Int
    ): Call<ArrayList<PostResponsesModel>>

    @GET("posts")
    fun getPosts(@QueryMap parameters: HashMap<String, String>): Call<ArrayList<PostResponsesModel>>

    @FormUrlEncoded
    @PUT("posts/{id}")
    fun putPost(
        @Path("id") id: Int,
        @Field ("userId") userId: Int,
        @Field ("id") idField: Int,
        @Field ("title") title: String?,
        @Field ("body") text:String?,
    ): Call<PostResponsesModel>

    @FormUrlEncoded
    @PATCH("posts/{id}")
    fun patchPost(
        @Path("id") id: Int,
        @Field ("userId") userId: Int,
        @Field ("id") idField: Int,
        @Field ("title") title: String?,
        @Field ("body") text:String?,
    ): Call<PostResponsesModel>

    @DELETE("posts/{id}")
    fun deletePost(
        @Path("id") id: Int
    ): Call<Void>
}