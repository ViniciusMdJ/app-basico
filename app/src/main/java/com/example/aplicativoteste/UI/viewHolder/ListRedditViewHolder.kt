package com.example.aplicativoteste.UI.viewHolder

import androidx.recyclerview.widget.RecyclerView
import com.example.aplicativoteste.databinding.TopicsLineBinding
import com.example.aplicativoteste.repository.data.DataTopicsEntity
class ListRedditViewHolder(private val binding: TopicsLineBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bindVH(t: DataTopicsEntity) {
        binding.titleTopic.text = t.data.title
    }
}