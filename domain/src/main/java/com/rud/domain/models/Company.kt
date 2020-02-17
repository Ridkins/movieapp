package com.rud.domain.models

import com.google.gson.annotations.SerializedName

data class Company(
    @SerializedName("id") var id: String? = null,
    @SerializedName("name") var name: String? = null
)