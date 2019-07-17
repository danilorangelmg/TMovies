package br.com.tmovies.movies.helper

import android.os.Bundle
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import br.com.tmovies.movies.MovieActivity
import br.com.tmovies.movies.R
import br.com.tmovies.movies.detail.MovieDetailFragment.Companion.MOVIE_ID

fun Fragment.updateToolbarTitle(@StringRes title: Int) {
    (activity as MovieActivity).toolbarTitleLiveData.value = getString(title)
}

fun Fragment.showBackButtonTootal(showBackButtonToolbar: Boolean) {
    (activity as MovieActivity).showBackButtonToolbarLiveData.value = showBackButtonToolbar
}

fun Fragment.navigateToDetailFragment(movieId: String) {
    (activity as MovieActivity).getNavController().navigate(R.id.fragmentDetail, Bundle().apply {
        putString(MOVIE_ID, movieId)
    })
}