package br.com.tmovies.splash

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import br.com.tmovies.R
import br.com.tmovies.common.extensions.startFeatureActivity


class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val SPLASH_TIME_OUT: Long = 3000

        Handler().postDelayed({
            // This method will be executed once the timer is over
            // Start your app main activity

//            val i = Intent(Intent.ACTION_VIEW).apply {
//                setClassName("br.com.tmovies", "br.com.tmovies.movies.MovieActivity")
//            }
//            startActivity(i)

            startFeatureActivity("movies.MovieActivity")

            // close this activity
            finish()
        }, SPLASH_TIME_OUT)

    }

}
