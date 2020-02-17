package com.rud.domain.models

import com.google.gson.annotations.SerializedName

data class Language(
    @SerializedName("name") var name: String? = null,
    @SerializedName("iso_639_1") var isoCode: String? = null
)