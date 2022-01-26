package bajp.playground.moviecatalogueapp.ui.home.movies

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import bajp.playground.moviecatalogueapp.common.ConstanNameHelper
import bajp.playground.moviecatalogueapp.data.TrendingEntity
import bajp.playground.moviecatalogueapp.databinding.FragmentMoviesBinding
import bajp.playground.moviecatalogueapp.ui.detail.DetailMovieActivity
import bajp.playground.moviecatalogueapp.utils.General.isShowComponentProgress
import bajp.playground.moviecatalogueapp.viewModel.ViewModelMovieRepoFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MoviesFragment : Fragment() {

    private var _binding: FragmentMoviesBinding? = null
    private val binding get()=_binding

    @Inject lateinit var movieRepoFactory:ViewModelMovieRepoFactory
    private lateinit var viewModel: MoviesViewModel
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
            viewModel = ViewModelProvider(this,movieRepoFactory)[MoviesViewModel::class.java]
            loaderShowAndHide()
            generateRvMovies()
        }
    }

    private fun loaderShowAndHide(){
        viewModel.loader.observe(viewLifecycleOwner){ show->
            isShowComponentProgress(binding?.loadContentMovies,show)
        }
    }

    private fun generateRvMovies() {
        with(binding){
            val adapter = MoviesAdapter()
            this?.rvMovies?.layoutManager = LinearLayoutManager(context)
            this?.rvMovies?.setHasFixedSize(true)

            viewModel.getMovieList.observe(viewLifecycleOwner){ movies->
                adapter.setMovies(movies.getOrNull())
                this?.rvMovies?.adapter = adapter
            }

            adapter.setOnClickListener(object :MoviesAdapter.ItemsCallback{
                override fun onClickItem(movie: TrendingEntity) {
                    val mIntent = Intent(context, DetailMovieActivity::class.java)
                    mIntent.putExtra(DetailMovieActivity.idMovie,movie.movieId)
                    mIntent.putExtra(DetailMovieActivity.type,ConstanNameHelper.MOVIES_TYPE)
                    mIntent.putExtra(DetailMovieActivity.local, false)
                    startActivity(mIntent)
                }
            })
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}