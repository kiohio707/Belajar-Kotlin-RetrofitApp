package com.example.retrofitapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofitapp.adapter.PostAdapter
import com.example.retrofitapp.databinding.ActivityMainBinding
import com.example.retrofitapp.model.CreatePostResponseModel
import com.example.retrofitapp.model.PostResponsesModel
import com.example.retrofitapp.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    val list = ArrayList<PostResponsesModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        /*showPost()*/

        createPost()
    }

    private fun createPost() {
        RetrofitClient.instance.createPost(
            77,
            "Coba",
            "Coba - coba"
        ).enqueue(object : Callback<CreatePostResponseModel> {
            override fun onResponse(
                call: Call<CreatePostResponseModel>,
                response: Response<CreatePostResponseModel>
            ) {
                val responseText = "Response code: ${response.code()}\n" +
                        "Title: ${response.body()?.title}\n" +
                        "Body: ${response.body()?.text}\n" +
                        "UserId: ${response.body()?.userId}\n" +
                        "Id: ${response.body()?.id}\n"

                binding.tvResponseCode.text = responseText
            }

            override fun onFailure(call: Call<CreatePostResponseModel>, t: Throwable) {
                binding.tvResponseCode.text = t.message
            }

        })
    }

    private fun showPost() {
        binding.recViewPost.setHasFixedSize(true)
        binding.recViewPost.layoutManager = LinearLayoutManager(this)

        RetrofitClient.instance.getPosts().enqueue(object: Callback<ArrayList<PostResponsesModel>>{
            override fun onResponse(
                call: Call<ArrayList<PostResponsesModel>>,
                response: Response<ArrayList<PostResponsesModel>>
            ) {
                val responsesCode = response.code().toString()
                binding.tvResponseCode.text = responsesCode

                response.body()?.let {
                    list.addAll(it)
                }

                val adapter = PostAdapter(list)
                binding.recViewPost.adapter = adapter
            }

            override fun onFailure(call: Call<ArrayList<PostResponsesModel>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }
}