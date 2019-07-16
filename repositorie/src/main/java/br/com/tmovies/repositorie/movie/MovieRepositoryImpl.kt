package br.com.tmovies.repositorie.movie

import br.com.tmovies.domain.movie.MoviesModel
import br.com.tmovies.networkservice.movies.MovieServiceImpl
import br.com.tmovies.repositorie.helper.exception.BusinessException
import br.com.tmovies.repositorie.movie.mapper.toMoviesModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

class MovieRepositoryImpl : MovieRepository {

    @Throws(Exception::class)
    override fun getMovies(sort: String, year: String, page: String): MoviesModel {
        try {
            return runBlocking {
                MovieServiceImpl().getMovies(sort, year, page).toMoviesModel()
            }
        } catch (e: Exception) {
            throw BusinessException(e.message)
        }
    }

    @Throws(BusinessException::class)
    override fun getMoviesByName(movieName: String): MoviesModel {
        try {
            return runBlocking {
                MovieServiceImpl().getMoviesByName(movieName).toMoviesModel()
            }
        } catch (e: Exception) {
            throw BusinessException(e.message)
        }
    }

}