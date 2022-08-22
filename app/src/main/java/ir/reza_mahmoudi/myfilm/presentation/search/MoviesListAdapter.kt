package ir.reza_mahmoudi.myfilm.presentation.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import ir.reza_mahmoudi.myfilm.databinding.ItemMovieBinding
import ir.reza_mahmoudi.myfilm.domain.search.entity.MovieItem
import ir.reza_mahmoudi.myfilm.util.ListDiffUtil

class MoviesListAdapter : RecyclerView.Adapter<MoviesListAdapter.ViewHolder>(){

    private var movies = emptyList<MovieItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(movies[position])
    }

    override fun getItemCount(): Int =movies.size

    fun setData(newMoviesList: List<MovieItem>){
        val moviesDiffUtil =
            ListDiffUtil(movies, newMoviesList)
        val diffUtilResult = DiffUtil.calculateDiff(moviesDiffUtil)
        movies = newMoviesList
        diffUtilResult.dispatchUpdatesTo(this)
    }

    class ViewHolder(private val binding: ItemMovieBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(movie: MovieItem){
            binding.movie=movie
        }
    }
}