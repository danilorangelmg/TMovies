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
            startFeatureActivity("movies.MovieActivity")
            finish()
        }, SPLASH_TIME_OUT)

    }

}
