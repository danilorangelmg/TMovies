package br.com.tmovies.repositorie.movie.mapper

import br.com.tmovies.domain.movie.MovieModel
import br.com.tmovies.domain.movie.MoviesModel
import br.com.tmovies.networkservice.model.MovieResponse
import br.com.tmovies.networkservice.model.MoviesResponse

fun MoviesResponse.toMoviesModel() = MoviesModel(
    page = page,
    totalPages = totalPages,
    results = results.map { it.toMovieModel() }
)

fun MovieResponse.toMovieModel() = MovieModel(
    id = id,
    voteCount = voteCount,
    video = video,
    voteAverage = voteAverage,
    title = title,
    popularity = popularity,
    posterPath = posterPath,
    originalLanguage = originalLanguage,
    originalTitle = originalTitle,
    genreIds = genreIds,
    backdropPath = backdropPath,
    adult = adult,
    overview = overview,
    releaseDate = releaseDate
)