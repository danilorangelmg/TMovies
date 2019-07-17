package br.com.tmovies.movies.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.example.koinsample.ui.home.HomeViewModel
import br.com.tmovies.common.extensions.showErrorDialogTryAgain
import br.com.tmovies.movies.MovieActivity
import br.com.tmovies.movies.R
import br.com.tmovies.movies.helper.navigateToDetailFragment
import br.com.tmovies.movies.helper.updateToolbarTitle
import br.com.tmovies.movies.adapter.MoviesAdapter
import br.com.tmovies.movies.helper.showBackButtonTootal
import kotlinx.android.synthetic.main.fragment_home.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class HomeFragment : Fragment() {

    val viewModel: HomeViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycle.addObserver(viewModel)
        updateToolbarTitle(R.string.title_movie_feature)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        initializeLiveData()
        return layoutInflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initializeViews()
    }

    override fun onResume() {
        super.onResume()
        showBackButtonTootal(false)
    }

    private fun initializeLiveData() {
        viewModel.moviesLiveData.observe(this, Observer {
            (rvMoviesList.adapter as MoviesAdapter).addItems(it)
        })

        (activity as MovieActivity).searchLiveData.observe(this, Observer {
            if (it.isNullOrEmpty()) {
                (rvMoviesList.adapter as MoviesAdapter).clearFilter()
            } else {
                viewModel.loadMoviesByName(it)
            }

        })

        viewModel.moviesByNameLiveData.observe(this, Observer {
            (rvMoviesList.adapter as MoviesAdapter).addFilterItens(it)
        })

        viewModel.errorLiveData.observe(this, Observer {
            showErrorDialogTryAgain(it) {
                viewModel.loadMoreItems()
            }
        })
    }

    private fun initializeViews() {
        rvMoviesList.apply {
            layoutManager = GridLayoutManager(activity, 2)
            adapter = MoviesAdapter {
                navigateToDetailFragment(it.id.toString())
            }
            addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)
                    with(recyclerView) {
                        val manager = layoutManager as GridLayoutManager
                        val visibleItemCount = manager?.childCount
                        val totalItemCount = manager?.itemCount
                        val firstVisibleItemPosition = manager.findFirstVisibleItemPosition()
                        if (visibleItemCount + firstVisibleItemPosition >= totalItemCount && firstVisibleItemPosition >= 0) {
                            viewModel.loadMoreItems()
                        }
                    }
                }
            })
        }
    }
}