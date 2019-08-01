package br.com.tmovies.networkservice.model

import com.google.gson.annotations.SerializedName

data class MovieResponse(

    val id: Int?,

    @SerializedName("vote_count")
    val voteCount: Int?,

    val video: Boolean?,

    @SerializedName("vote_average")
    val voteAverage: Double?,

    val title: String?,

    val popularity: Double?,

    @SerializedName("poster_path")
    val posterPath: String?,

    @SerializedName("original_language")
    val originalLanguage: String?,

    @SerializedName("original_title")
    val originalTitle: String?,

    @SerializedName("genre_ids")
    val genreIds: List<Integer>?,

    @SerializedName("backdrop_path")
    val backdropPath: String?,

    val adult: Boolean?,

    val overview: String?,

    @SerializedName("release_date")
    val releaseDate: String?
)