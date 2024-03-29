package br.com.tmovies.networkservice.movies

import br.com.tmovies.networkservice.BuildConfig
import br.com.tmovies.networkservice.model.MovieDetailResponse
import br.com.tmovies.networkservice.model.MovieResponse
import br.com.tmovies.networkservice.model.MoviesResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApi {

    @GET("discover/movie?api_key=" + BuildConfig.API_KEY + "&language=en-Us" +
            "&include_adult=false&vote_count.gte=0")
    suspend fun getLastMovies(@Query("sort") sort: String, @Query("primary_release_year") year: String, @Query("page") page: String): MoviesResponse

    @GET("search/movie?api_key=" + BuildConfig.API_KEY + "&language=en-Us" +
            "&include_adult=false")
    suspend fun getMoviesByName(@Query("query") movieName: String): MoviesResponse

    @GET("movie/{movieId}?api_key=" + BuildConfig.API_KEY + "&language=en-Us")
    suspend fun getMoviesDetail(@Path("movieId") movieId: String): MovieDetailResponse

    @GET("movie/{movieId}/similar?api_key=" + BuildConfig.API_KEY + "&language=en-Us&page=1")
    suspend fun getSimilarMovies(@Path("movieId") movieId: String): MoviesResponse
}