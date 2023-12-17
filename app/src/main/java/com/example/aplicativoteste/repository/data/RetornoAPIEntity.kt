package com.example.aplicativoteste.repository.data

import com.google.gson.annotations.SerializedName

class RetornoAPIEntity {
    @SerializedName("kind")
    var kind: String = ""

    @SerializedName("data")
    var data: DataRetornoAPIEntity = DataRetornoAPIEntity()
}