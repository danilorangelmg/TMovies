package br.com.tmovies.repositorie.movie

import br.com.tmovies.domain.movie.MoviesModel

interface MovieRepository {

    fun getMovies(sort: String, year: String, page: String): MoviesModel

    fun getMoviesByName(movieName: String): MoviesModel
}