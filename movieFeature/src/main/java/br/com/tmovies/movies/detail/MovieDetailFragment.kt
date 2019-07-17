package br.com.tmovies.movies.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.tmovies.common.extensions.formatStrDate
import br.com.tmovies.common.extensions.loadImageUrl
import br.com.tmovies.movies.R
import br.com.tmovies.movies.adapter.MoviesAdapter
import br.com.tmovies.movies.helper.navigateToDetailFragment
import br.com.tmovies.movies.helper.updateToolbarTitle
import kotlinx.android.synthetic.main.fragment_detail.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MovieDetailFragment: Fragment() {

    companion object {
        const val MOVIE_ID = "MOVIE_ID"
    }

    private val viewModel: MovieDetailViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycle.addObserver(viewModel)
        updateToolbarTitle(R.string.title_movie_feature)
        initLiveData()
    }

    override fun onResume() {
        super.onResume()
        arguments?.getString(MOVIE_ID)?.let { viewModel.getMovie(it) }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return layoutInflater.inflate(R.layout.fragment_detail, container, false)
    }

    private fun initLiveData() {
        viewModel.movieDetailLiveData.observe(this, Observer {
            ivPoster.loadImageUrl(it.getBackDrop())
            tvMovieName.text = it.original_title
            imgLogo.loadImageUrl(it.getPoster())
            tvMovieDescription.text = it.overview
            tvRate.text = it.vote_average.toString()
            tvGenre.text = it.genres[0].name
            tvYear.text = it.release_date.formatStrDate("yyyy-MM-dd", "yyyy")
        })

        viewModel.similarMoviesLiveData.observe(this, Observer {
            rvMoviesList.apply {
                layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
                adapter = MoviesAdapter(true) {
                    navigateToDetailFragment(it.id.toString())
                }.apply {
                    addItems(it.results)
                }
            }
        })
    }
}