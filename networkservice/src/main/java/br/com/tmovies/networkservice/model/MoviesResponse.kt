package br.com.tmovies.networkservice.model

import com.google.gson.annotations.SerializedName

data class MoviesResponse(
    val page: Int,

    @SerializedName("total_pages")
    val totalPages: Int,

    @SerializedName("total_results")
    val totalResults: Int,

    val results: List<MovieResponse>
)