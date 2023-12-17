package com.example.aplicativoteste.repository.data

import com.google.gson.annotations.SerializedName

class DataTopicsEntity {
    @SerializedName("data")
    var data: TopicEntity = TopicEntity()
}