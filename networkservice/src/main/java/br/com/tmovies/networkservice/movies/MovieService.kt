package br.com.tmovies.networkservice.movies

import br.com.tmovies.networkservice.model.MoviesResponse
import retrofit2.http.Query

interface MovieService {

    suspend fun getMovies(sort: String, year: String, page: String): MoviesResponse

    suspend fun getMoviesByName(movieName: String): MoviesResponse
}