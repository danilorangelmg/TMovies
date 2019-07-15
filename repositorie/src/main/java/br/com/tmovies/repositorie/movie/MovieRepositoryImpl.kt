package br.com.tmovies.repositorie.movie

import br.com.tmovies.domain.movie.MoviesModel
import br.com.tmovies.networkservice.movies.MovieServiceImpl
import br.com.tmovies.repositorie.movie.mapper.toMoviesModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

class MovieRepositoryImpl : MovieRepository {

    override fun getMovies(sort: String, year: String, page: String): MoviesModel {
        return runBlocking {
            withContext(Dispatchers.IO) {
                MovieServiceImpl().getMovies(sort, year, page).toMoviesModel()
            }
        }
    }

    override fun getMoviesByName(movieName: String): MoviesModel {
        return runBlocking {
            withContext(Dispatchers.IO) {
                MovieServiceImpl().getMoviesByName(movieName).toMoviesModel()
            }
        }
    }

}