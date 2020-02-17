package com.rud.data.responses

import com.google.gson.annotations.SerializedName

class MovieListResponse<T> {
    @SerializedName("results")
    var results: List<T>? = null
    @SerializedName("page")
    var page = 0
    @SerializedName("total_pages")
    var totalPages = 0
    @SerializedName("total_results")
    var totalResults = 0

}