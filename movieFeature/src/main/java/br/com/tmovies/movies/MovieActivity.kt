package br.com.tmovies.movies

import android.os.Bundle
import android.view.View
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.navigation.Navigation
import br.com.tmovies.movies.di.loadKoinFeatures
import kotlinx.android.synthetic.main.movie_activity.*

class MovieActivity: AppCompatActivity() {

    val searchLiveData = MutableLiveData<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadKoinFeatures()
        setContentView(R.layout.movie_activity)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        setupSearchView()
    }

    private fun setupSearchView() {
        searchView.setOnSearchClickListener {
            tvToolbarTitle.visibility = View.GONE
        }

        searchView.setOnCloseListener(object : SearchView.OnCloseListener,
            androidx.appcompat.widget.SearchView.OnCloseListener {
            override fun onClose(): Boolean {
                tvToolbarTitle.visibility = View.VISIBLE
                return false
            }

        })

        searchView.setOnQueryTextListener(object : androidx.appcompat.widget.SearchView.OnQueryTextListener {

            override fun onQueryTextSubmit(query: String?): Boolean {
                searchLiveData.value = query
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText.isNullOrEmpty()) {
                    searchLiveData.value = newText
                }
                return false
            }

        })
    }

    override fun onSupportNavigateUp(): Boolean {
        return Navigation.findNavController(this, R.id.nav_host).navigateUp()
    }
}