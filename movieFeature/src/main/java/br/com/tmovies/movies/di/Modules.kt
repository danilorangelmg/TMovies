package br.com.tmovies.movies.di

import br.com.example.koinsample.ui.home.HomeViewModel
import br.com.tmovies.movies.detail.MovieDetailViewModel
import br.com.tmovies.repositorie.movie.ServiceModules
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

fun loadKoinFeatures() = loadFeatures

private val loadFeatures by lazy {
    loadKoinModules(
        listOf(movieModule, repositorieModule)
    )
}

val movieModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { MovieDetailViewModel(get()) }
}

val repositorieModule = module {
    factory { ServiceModules.getMovieRepository() }
}