package com.example.aplicativoteste.repository.service

import com.example.aplicativoteste.repository.data.RetornoAPIEntity
import retrofit2.Call
import retrofit2.http.GET

interface TopicsRedditService {
    @GET("r/androiddev.json?raw_json=1")
    fun getTopics(): Call<RetornoAPIEntity>
}