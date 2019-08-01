package br.com.tmovies.domain.movie

data class MovieDetailModel (
    val adult :Boolean,
    val backdrop_path: String,
    val genres: List<GenreModel>,
    val id: Int,
    val original_title: String,
    val overview: String,
    val poster_path: String,
    val release_date: String,
    val runtime: Int,
    val vote_average: Double
)  {
    fun getPoster(): String = getImageUrl(poster_path)
    fun getBackDrop(): String = getImageUrl(backdrop_path)

    private fun getImageUrl(url: String) = "https://image.tmdb.org/t/p/w500$url"
}

data class GenreModel(val id: Int, val name: String)