package com.example.retrofitapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitapp.databinding.AdapterPostBinding
import com.example.retrofitapp.model.CommentResponsesModel

class CommentAdapter(val listComment: ArrayList<CommentResponsesModel>): RecyclerView.Adapter<CommentAdapter.ViewHolder>() {
    class ViewHolder(val binding: AdapterPostBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(commentResponsesModel: CommentResponsesModel) {
            with(binding) {
                val text = "postId: ${commentResponsesModel.postId} \n" +
                        "id: ${commentResponsesModel.id} \n" +
                        "name: ${commentResponsesModel.name} \n" +
                        "email: ${commentResponsesModel.email} \n" +
                        "body: ${commentResponsesModel.body} \n"

                tvTeks.text = text
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(AdapterPostBinding.inflate(LayoutInflater.from(parent.context), null, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listComment[position])
    }

    override fun getItemCount(): Int {
        return listComment.size
    }
}