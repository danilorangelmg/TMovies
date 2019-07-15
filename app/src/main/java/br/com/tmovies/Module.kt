package br.com.tmovies

import br.com.tmovies.repositorie.movie.ServiceModules
//import br.com.tmovies.splash.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

//    viewModel { MainViewModel(get()) }
}

val repositorieModule = module {
    factory { ServiceModules.getMovieRepository() }
}