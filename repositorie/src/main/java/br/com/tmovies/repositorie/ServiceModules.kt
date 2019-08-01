package br.com.tmovies.repositorie.movie

//foi preciso pois o koin não está conseguindo localizar o koinModule de um modulo externo
object ServiceModules {

    private lateinit var movieRepository: MovieRepository
    private var started = false

    fun start() {
        if (!started) {
            movieRepository = MovieRepositoryImpl()
        }
    }

    fun getMovieRepository(): MovieRepository = movieRepository

}