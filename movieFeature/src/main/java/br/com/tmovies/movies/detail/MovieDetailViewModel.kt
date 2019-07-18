package br.com.tmovies.movies.detail

import androidx.lifecycle.*
import br.com.tmovies.domain.movie.MovieDetailModel
import br.com.tmovies.domain.movie.MoviesModel
import br.com.tmovies.repositorie.helper.exception.BusinessException
import br.com.tmovies.repositorie.movie.MovieRepository

class MovieDetailViewModel(private val repository: MovieRepository) : ViewModel(), LifecycleObserver {

    val loadItemLiveData = MutableLiveData<MovieDetailModel>()
    val similarItemsLiveData = MutableLiveData<MoviesModel>()
    val errorLiveData = MutableLiveData<String>()

    fun getMovie(movieId: String) {
        try {
            loadItemLiveData.value = repository.getMovieDetail(movieId)
            similarItemsLiveData.value = repository.getSimilarMovies(movieId)
        } catch (e: BusinessException) {
            errorLiveData.value = e.message
        }
    }
}