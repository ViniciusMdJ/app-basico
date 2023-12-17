package com.example.aplicativoteste.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.aplicativoteste.repository.client.ClientReddit
import com.example.aplicativoteste.repository.data.DataTopicsEntity
import com.example.aplicativoteste.repository.data.RetornoAPIEntity
import com.example.aplicativoteste.repository.service.TopicsRedditService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListViewModel: ViewModel() {
    private var topicList = MutableLiveData<List<DataTopicsEntity>>()

    init {
        requestTopicListFromAPI()
    }

    fun getTopicList(): LiveData<List<DataTopicsEntity>> {
        return topicList
    }

    fun requestTopicListFromAPI() {
        val apiBlogService = ClientReddit.createService(TopicsRedditService::class.java)
        val blogPost: Call<RetornoAPIEntity> = apiBlogService.getTopics()
        blogPost.enqueue(object : Callback<RetornoAPIEntity> {
            override fun onResponse(
                call: Call<RetornoAPIEntity>,
                response: Response<RetornoAPIEntity>
            ) {
                response.body()?.let {
                    topicList.value = it.data.children
                }
            }

            override fun onFailure(call: Call<RetornoAPIEntity>, t: Throwable) {
                topicList.value = listOf()
            }
        })
    }
}