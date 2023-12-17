package com.example.aplicativoteste.repository.data

import com.google.gson.annotations.SerializedName

class DataRetornoAPIEntity {
    @SerializedName("children")
    var children: List<DataTopicsEntity> = listOf()
}
