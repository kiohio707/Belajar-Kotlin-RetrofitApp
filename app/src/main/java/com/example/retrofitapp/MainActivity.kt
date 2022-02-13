package com.example.retrofitapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofitapp.adapter.CommentAdapter
import com.example.retrofitapp.adapter.PostAdapter
import com.example.retrofitapp.databinding.ActivityMainBinding
import com.example.retrofitapp.model.CommentResponsesModel
import com.example.retrofitapp.model.CreatePostResponsesModel
import com.example.retrofitapp.model.PostResponsesModel
import com.example.retrofitapp.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    val listPost = ArrayList<PostResponsesModel>()
    val listComment = ArrayList<CommentResponsesModel>()
    val parameters = HashMap<String, String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        /*showPost()*/

        /*createPost()*/

        /*showComment()*/

        /*putUpdatePost()*/

        patchUpdatePost()
    }

    private fun showPost() {
        binding.recViewPost.setHasFixedSize(true)
        binding.recViewPost.layoutManager = LinearLayoutManager(this)

        parameters["userId"] = "3"
        parameters["id"] = "25"

        RetrofitClient.instance.getPosts(parameters).enqueue(object: Callback<ArrayList<PostResponsesModel>>{
            override fun onResponse(
                call: Call<ArrayList<PostResponsesModel>>,
                response: Response<ArrayList<PostResponsesModel>>
            ) {
                val responsesCode = response.code().toString()
                binding.tvResponseCode.text = responsesCode

                response.body()?.let {
                    listPost.addAll(it)
                }

                val adapter = PostAdapter(listPost)
                binding.recViewPost.adapter = adapter
            }

            override fun onFailure(call: Call<ArrayList<PostResponsesModel>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }

    private fun createPost() {
        RetrofitClient.instance.createPost(
            77,
            "Coba",
            "Coba - coba"
        ).enqueue(object : Callback<CreatePostResponsesModel> {
            override fun onResponse(
                call: Call<CreatePostResponsesModel>,
                response: Response<CreatePostResponsesModel>
            ) {
                val responseText = "Response code: ${response.code()}\n" +
                        "Title: ${response.body()?.title}\n" +
                        "Body: ${response.body()?.text}\n" +
                        "UserId: ${response.body()?.userId}\n" +
                        "Id: ${response.body()?.id}\n"

                binding.tvResponseCode.text = responseText
            }

            override fun onFailure(call: Call<CreatePostResponsesModel>, t: Throwable) {
                binding.tvResponseCode.text = t.message
            }

        })
    }

    private fun showComment() {
        binding.recViewPost.layoutManager = LinearLayoutManager(this)

        RetrofitClient.instance.getComments(3).enqueue(object : Callback<ArrayList<CommentResponsesModel>> {
            override fun onResponse(
                call: Call<ArrayList<CommentResponsesModel>>,
                response: Response<ArrayList<CommentResponsesModel>>
            ) {
                binding.tvResponseCode.text = response.code().toString()

                response.body()?.let { listComment.addAll(it) }

                val adapter = CommentAdapter(listComment)

                binding.recViewPost.adapter = adapter
            }

            override fun onFailure(call: Call<ArrayList<CommentResponsesModel>>, t: Throwable) {
                binding.tvResponseCode.text = t.message
            }

        })
    }

    private fun putUpdatePost() {
        RetrofitClient.instance.putPost(
            1,
            1,
            1,
            null,
            "Coba Update"
        ).enqueue(object : Callback<PostResponsesModel> {
            override fun onResponse(
                call: Call<PostResponsesModel>,
                response: Response<PostResponsesModel>
            ) {
                val responseText = "Response code: ${response.code()}\n" +
                        "Title: ${response.body()?.title}\n" +
                        "Body: ${response.body()?.text}\n" +
                        "UserId: ${response.body()?.userId}\n" +
                        "Id: ${response.body()?.id}\n"

                binding.tvResponseCode.text = responseText
            }

            override fun onFailure(call: Call<PostResponsesModel>, t: Throwable) {
                binding.tvResponseCode.text = t.message
            }

        })
    }

    private fun patchUpdatePost() {
        RetrofitClient.instance.patchPost(
            1,
            1,
            1,
            null,
            "Coba Update"
        ).enqueue(object : Callback<PostResponsesModel> {
            override fun onResponse(
                call: Call<PostResponsesModel>,
                response: Response<PostResponsesModel>
            ) {
                val responseText = "Response code: ${response.code()}\n" +
                        "Title: ${response.body()?.title}\n" +
                        "Body: ${response.body()?.text}\n" +
                        "UserId: ${response.body()?.userId}\n" +
                        "Id: ${response.body()?.id}\n"

                binding.tvResponseCode.text = responseText
            }

            override fun onFailure(call: Call<PostResponsesModel>, t: Throwable) {
                binding.tvResponseCode.text = t.message
            }

        })
    }
}