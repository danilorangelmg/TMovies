package br.com.tmovies.networkservice.model

data class MovieDetailResponse(
    val adult :Boolean,
    val backdrop_path: String,
    val genres: List<GenreResponse>,
    val id: Int,
    val original_title: String,
    val overview: String,
    val poster_path: String,
    val release_date: String,
    val runtime: Int,
    val vote_average: Double
)

data class GenreResponse(val id: Int, val name: String)