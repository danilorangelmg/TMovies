package br.com.tmovies

import android.app.Application
import br.com.tmovies.repositorie.movie.ServiceModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class TMovieApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        ServiceModules.start()
        startKoin {
            androidContext(this@TMovieApplication)
            modules(listOf(appModule))
        }
    }
}