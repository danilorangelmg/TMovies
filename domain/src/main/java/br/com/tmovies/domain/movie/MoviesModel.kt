package br.com.tmovies.domain.movie

data class MoviesModel(
    val page: Int,

    val totalPages: Int,

    val results: List<MovieModel>
)