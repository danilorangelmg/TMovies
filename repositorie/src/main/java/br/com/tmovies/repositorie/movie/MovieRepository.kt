package br.com.tmovies.repositorie.movie

import br.com.tmovies.domain.movie.MoviesModel
import br.com.tmovies.repositorie.helper.exception.BusinessException

interface MovieRepository {

    @Throws(BusinessException::class)
    fun getMovies(sort: String, year: String, page: String): MoviesModel

    @Throws(BusinessException::class)
    fun getMoviesByName(movieName: String): MoviesModel
}