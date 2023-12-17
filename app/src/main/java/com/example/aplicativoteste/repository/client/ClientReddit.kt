package com.example.aplicativoteste.repository.client

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ClientReddit private constructor() {
    companion object {
        private lateinit var INSTANCE: Retrofit
        private const val BASE_URL = "https://www.reddit.com/"

        private fun getClientInstance(): Retrofit {
            val http = OkHttpClient.Builder()
            if (!Companion::INSTANCE.isInitialized) {
                INSTANCE = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(http.build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return INSTANCE
        }

        fun <S> createService(className: Class<S>): S {
            return getClientInstance().create(className)
        }
    }
}