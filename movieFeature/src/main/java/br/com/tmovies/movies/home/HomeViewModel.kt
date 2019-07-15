package br.com.example.koinsample.ui.home

import androidx.lifecycle.*
import br.com.tmovies.domain.movie.MovieModel
import br.com.tmovies.repositorie.movie.MovieRepository

class HomeViewModel(private val repository: MovieRepository): ViewModel(), LifecycleObserver {

    val moviesLiveData = MutableLiveData<List<MovieModel>>()
    val moviesByNameLiveData = MutableLiveData<List<MovieModel>>()
    private var currentPage = 0
    private var totalPages = 0

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    private fun onResume() {
        getMovies()
    }

    fun loadMoreItems() {
        getMovies()
    }

    fun loadMoviesByName(name: String) {
        moviesByNameLiveData.value = repository.getMoviesByName(name).results
    }

    private fun getMovies() {
        if (currentPage <= totalPages) {
            currentPage++
            val response = repository.getMovies("popularity", "2019", currentPage.toString())
            totalPages = response.totalPages
            moviesLiveData.value = response.results
        }
    }

}