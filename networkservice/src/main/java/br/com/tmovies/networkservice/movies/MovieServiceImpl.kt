package br.com.tmovies.networkservice.movies

import br.com.tmovies.networkservice.config.ServiceConfiguration
import br.com.tmovies.networkservice.model.MoviesResponse

class MovieServiceImpl : MovieService {

    private val movieApi by lazy {
        ServiceConfiguration().configureApiInterface(MovieApi::class.java)
    }

    override suspend fun getMovies(sort: String, year: String, page: String): MoviesResponse {
        return movieApi.getLastMovies(sort, year, page)
    }

    override suspend fun getMoviesByName(movieName: String): MoviesResponse {
        return movieApi.getMoviesByName(movieName)
    }

}