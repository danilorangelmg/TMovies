package br.com.tmovies.networkservice.movies

import br.com.tmovies.networkservice.config.NetworkException
import br.com.tmovies.networkservice.config.ServiceConfiguration
import br.com.tmovies.networkservice.model.MovieDetailResponse
import br.com.tmovies.networkservice.model.MoviesResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.lang.Exception

class MovieServiceImpl : MovieService {

    private val ERROR_MESSAGE = "Erro ao buscar filmes, Tente novamente em alguns instantes!"

    private val movieApi by lazy {
        ServiceConfiguration().configureApiInterface(MovieApi::class.java)
    }

    @Throws(NetworkException::class)
    override suspend fun getMovies(sort: String, year: String, page: String): MoviesResponse {
         try {
             return withContext(Dispatchers.IO) {
                movieApi.getLastMovies(sort, year, page)
            }
        } catch (e: HttpException) {
            throw NetworkException(ERROR_MESSAGE)
        }
    }

    @Throws(NetworkException::class)
    override suspend fun getMoviesByName(movieName: String): MoviesResponse {
        try {
            return withContext(Dispatchers.IO) {
                movieApi.getMoviesByName(movieName)
            }
        } catch (e: HttpException) {
            throw NetworkException(ERROR_MESSAGE)
        }
    }

    @Throws(NetworkException::class)
    override suspend fun getMoviesDetail(movieId: String): MovieDetailResponse {
        try {
            return withContext(Dispatchers.IO) {
                movieApi.getMoviesDetail(movieId)
            }
        } catch (e: HttpException) {
            throw NetworkException(ERROR_MESSAGE)
        }
    }

    @Throws(NetworkException::class)
    override suspend fun getSimilarMovies(movieId: String): MoviesResponse {
        try {
            return withContext(Dispatchers.IO) {
                movieApi.getSimilarMovies(movieId)
            }
        } catch (e: HttpException) {
            throw NetworkException(ERROR_MESSAGE)
        }
    }
}