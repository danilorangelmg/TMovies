package br.com.tmovies.domain.movie

data class MovieModel(
    val id: Int?,

    val voteCount: Int?,

    val video: Boolean?,

    val voteAverage: Double?,

    val title: String?,

    val popularity: Double?,

    val posterPath: String?,

    val originalLanguage: String?,

    val originalTitle: String?,

    val genreIds: List<Integer>?,

    val backdropPath: String?,

    val adult: Boolean?,

    val overview: String?,

    val releaseDate: String?
) {
    fun getPoster(): String = "https://image.tmdb.org/t/p/w500$posterPath"
}