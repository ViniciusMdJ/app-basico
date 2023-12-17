package com.example.aplicativoteste.UI.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.aplicativoteste.UI.viewHolder.ListRedditViewHolder
import com.example.aplicativoteste.databinding.TopicsLineBinding
import com.example.aplicativoteste.repository.data.DataTopicsEntity

class ListRedditAdapter: RecyclerView.Adapter<ListRedditViewHolder>() {
    private var redditTopicList: List<DataTopicsEntity> = listOf()
    private lateinit var binding: TopicsLineBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListRedditViewHolder {
        binding = TopicsLineBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return ListRedditViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return redditTopicList.count()
    }

    override fun onBindViewHolder(holder: ListRedditViewHolder, position: Int) {
        holder.bindVH(redditTopicList[position])
    }

    fun updateDietList(list: List<DataTopicsEntity>) {
        redditTopicList = list
        notifyDataSetChanged()
    }
}