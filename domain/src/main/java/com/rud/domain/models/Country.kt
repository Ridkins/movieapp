package com.rud.domain.models

import com.google.gson.annotations.SerializedName

data class Country(
    @SerializedName("name") var name: String? = null,
    @SerializedName("iso_3166_1") var isoCode: String? = null
)