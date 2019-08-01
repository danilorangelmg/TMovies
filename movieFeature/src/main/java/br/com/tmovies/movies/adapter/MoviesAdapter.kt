package br.com.tmovies.movies.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.tmovies.common.extensions.formatStrDate
import br.com.tmovies.common.extensions.loadImageUrl
import br.com.tmovies.domain.movie.MovieModel
import br.com.tmovies.movies.R
import kotlinx.android.synthetic.main.item_movie_list.view.*
import java.util.*

class MoviesAdapter(private val similarMovie: Boolean = false, val callback: (MovieModel) -> Unit): RecyclerView.Adapter<MoviesAdapter.ItemViewHolder>() {

    private val items = LinkedList<MovieModel>()
    private val allItems = LinkedList<MovieModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val layoutId = when(viewType) {
            ViewType.MOVIE.type -> R.layout.item_movie_list
            ViewType.SIMILAR.type -> R.layout.item_similar_movie_list
            else -> 0
        }
        val view = LayoutInflater.from(parent.context).inflate(layoutId, parent, false)
        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun getItemViewType(position: Int): Int {
        return if (similarMovie) ViewType.SIMILAR.type else ViewType.MOVIE.type
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        var item = items[position]
        with(holder.itemView) {
            ivPoster.loadImageUrl(item.getPoster())
            tvMovieName.text = item.originalTitle
            tvMovieYear.text = item.releaseDate?.formatStrDate("yyyy-MM-dd", "yyyy")
        }
        holder.itemView.setOnClickListener {
            callback(item)
        }
    }

    fun addItems(newItems: List<MovieModel>) {
        items.addAll(newItems)
        notifyDataSetChanged()
    }

    fun addFilterItens(newItems: List<MovieModel>) {
        allItems.addAll(items)
        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    }

    fun clearFilter() {
        items.clear()
        items.addAll(allItems)
        notifyDataSetChanged()
    }

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view)
    enum class ViewType(val type: Int) {
        MOVIE(1),
        SIMILAR(2)
    }
}