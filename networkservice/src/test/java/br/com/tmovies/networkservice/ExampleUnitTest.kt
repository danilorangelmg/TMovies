package br.com.tmovies.networkservice

import br.com.tmovies.networkservice.model.MoviesResponse
import br.com.tmovies.networkservice.movies.MovieServiceImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see [Testing documentation](http://d.android.com/tools/testing)
 */
class ExampleUnitTest {

    @Test
    fun createServiceTest() {
        val response = runBlocking {
            teste()
        }

        assert(response != null)
    }

    suspend fun teste(): MoviesResponse {
        return withContext(Dispatchers.IO) {
            MovieServiceImpl().getMovies("popularity", "2018", "1")
        }
    }

}