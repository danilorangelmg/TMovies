package br.com.tmovies.repositorie.movie.mapper

import br.com.tmovies.domain.movie.GenreModel
import br.com.tmovies.domain.movie.MovieDetailModel
import br.com.tmovies.domain.movie.MovieModel
import br.com.tmovies.domain.movie.MoviesModel
import br.com.tmovies.networkservice.model.GenreResponse
import br.com.tmovies.networkservice.model.MovieDetailResponse
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

fun MovieDetailResponse.toMovieDetailModel() = MovieDetailModel(
    adult = adult,
    backdrop_path = backdrop_path,
    genres = genres.map { it.toGenreModel() },
    id = id,
    original_title = original_title,
    overview = overview,
    poster_path = poster_path,
    release_date = release_date,
    runtime = runtime,
    vote_average = vote_average
)

fun GenreResponse.toGenreModel() = GenreModel(id = id, name = name)