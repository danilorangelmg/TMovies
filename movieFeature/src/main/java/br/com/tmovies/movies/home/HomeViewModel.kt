package br.com.example.koinsample.ui.home

import androidx.lifecycle.*
import br.com.tmovies.domain.movie.MovieModel
import br.com.tmovies.repositorie.movie.MovieRepository

class HomeViewModel(private val repository: MovieRepository) : ViewModel(), LifecycleObserver {

    val errorLiveData = MutableLiveData<String>()
    val itemsLiveData = MutableLiveData<List<MovieModel>>()
    val itemsFilterLiveData = MutableLiveData<List<MovieModel>>()

    private var currentPage = 0
    private var totalPages = 0

    @Suppress("unused")
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    private fun onResume() {
        loadMovies()
    }

    fun loadMoreItems() {
        loadMovies()
    }

    fun onItemClick(param: String) {
        loadMoviesByName(param)
    }

    private fun loadMoviesByName(name: String) {
        try {
            itemsFilterLiveData.value = repository.getMoviesByName(name).results
        } catch (e: Exception) {
            errorLiveData.value = e.message
        }
    }

    private fun loadMovies() {
        try {
            if (currentPage <= totalPages) {
                currentPage++
                val response = repository.getMovies("popularity", "2019", currentPage.toString())
                totalPages = response.totalPages
                itemsLiveData.value = response.results
            }
        } catch (e: Exception) {
            currentPage--
            errorLiveData.value = e.message
        }
    }
}