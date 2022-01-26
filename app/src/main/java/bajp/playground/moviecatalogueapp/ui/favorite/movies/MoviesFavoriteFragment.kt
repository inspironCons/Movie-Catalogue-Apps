package bajp.playground.moviecatalogueapp.ui.favorite.movies

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import bajp.playground.moviecatalogueapp.common.ConstanNameHelper
import bajp.playground.moviecatalogueapp.data.DetailMovieEntity
import bajp.playground.moviecatalogueapp.databinding.FragmentMoviesBinding
import bajp.playground.moviecatalogueapp.ui.detail.DetailMovieActivity
import bajp.playground.moviecatalogueapp.ui.favorite.FavoriteAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MoviesFavoriteFragment:Fragment() {
    private var _binding: FragmentMoviesBinding? = null
    private val binding get()=_binding
    private val viewModel:MoviesFavoriteViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMoviesBinding.inflate(inflater,container,false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(activity != null){
            getMovieList()
        }
    }

    private fun getMovieList() {
        val adapter = FavoriteAdapter()
        binding?.rvMovies?.layoutManager = LinearLayoutManager(context)
        binding?.rvMovies?.setHasFixedSize(true)
        binding?.rvMovies?.adapter = adapter
        lifecycleScope.launch {
            viewModel.getListMovie.collectLatest { data->
                adapter.submitData(data)
            }
        }

        adapter.setOnClickListener(object : FavoriteAdapter.ItemsCallback{
            override fun onClickItem(movie: DetailMovieEntity?) {
                val mIntent = Intent(context, DetailMovieActivity::class.java)
                mIntent.putExtra(DetailMovieActivity.idMovie,movie?.movieId)
                mIntent.putExtra(DetailMovieActivity.type, ConstanNameHelper.MOVIES_TYPE)
                mIntent.putExtra(DetailMovieActivity.local, true)
                startActivity(mIntent)
            }
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}