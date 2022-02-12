package com.example.retrofitapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitapp.databinding.AdapterPostBinding
import com.example.retrofitapp.model.PostResponsesModel

class PostAdapter(private val list: ArrayList<PostResponsesModel>):RecyclerView.Adapter<PostAdapter.ViewHolder>() {
    class ViewHolder(private val binding: AdapterPostBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(postResponsesModel: PostResponsesModel) {
            with(binding) {
                val text = "id: ${postResponsesModel.id}\n" +
                        "title: ${postResponsesModel.title}\n" +
                        "text: ${postResponsesModel.text}"

                binding.tvTeks.text = text
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(AdapterPostBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}