package br.com.tmovies.movies.detail

import androidx.lifecycle.*
import br.com.tmovies.domain.movie.MovieDetailModel
import br.com.tmovies.domain.movie.MoviesModel
import br.com.tmovies.repositorie.movie.MovieRepository

class MovieDetailViewModel(private val repository: MovieRepository): ViewModel(), LifecycleObserver {

    val movieDetailLiveData = MutableLiveData<MovieDetailModel>()
    val similarMoviesLiveData = MutableLiveData<MoviesModel>()

    fun getMovie(movieId: String) {
        movieDetailLiveData.value = repository.getMovieDetail(movieId)
        similarMoviesLiveData.value = repository.getSimilarMovies(movieId)
    }

}