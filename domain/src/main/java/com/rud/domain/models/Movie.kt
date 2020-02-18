package com.rud.domain.models

import com.google.gson.annotations.SerializedName

data class Movie(
    @SerializedName("original_language") var originalLanguage: String? = null,
    @SerializedName("imdb_id") var imdbId: String? = null,
    @SerializedName("video") var isVideo: Boolean = false,
    @SerializedName("title") var title: String? = null,
    @SerializedName("backdrop_path") var backdropPath: String? = null,
    @SerializedName("revenue") var revenue: Int = 0,
    @SerializedName("genres") var genres: List<Genre>? = null,
    @SerializedName("popularity") var popularity: Double = 0.0,
    @SerializedName("production_countries") var productionCountries: List<Country>? = null,
    @SerializedName("id") var id: String? = null,
    @SerializedName("vote_count") var voteCount: Int = 0,
    @SerializedName("budget") var budget: Int = 0,
    @SerializedName("overview") var overview: String? = null,
    @SerializedName("original_title") var originalTitle: String? = null,
    @SerializedName("runtime") var runtime: Int = 0,
    @SerializedName("poster_path") var posterPath: String? = null,
    @SerializedName("spoken_languages") var spokenLanguages: List<Language>? = null,
    @SerializedName("production_companies") var productionCompanies: List<Company>? = null,
    @SerializedName("release_date") var releaseDate: String? = null,
    @SerializedName("vote_average") var voteAverage: Double = 0.0,
    @SerializedName("belongs_to_collection") var belongsToCollection: Any? = null,
    @SerializedName("tagline") var tagline: String? = null,
    @SerializedName("adult") var isAdult: Boolean = false,
    @SerializedName("homepage") var homepage: String? = null,
    @SerializedName("status") var status: String? = null
)