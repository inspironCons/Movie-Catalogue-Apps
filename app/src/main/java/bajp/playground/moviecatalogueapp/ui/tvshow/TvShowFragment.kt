package bajp.playground.moviecatalogueapp.ui.tvshow

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import bajp.playground.moviecatalogueapp.data.MovieEntity
import bajp.playground.moviecatalogueapp.databinding.FragmentTvShowBinding
import bajp.playground.moviecatalogueapp.ui.detail.DetailMovieActivity
import bajp.playground.moviecatalogueapp.utils.General.isShowComponentProgress
import bajp.playground.moviecatalogueapp.viewModel.ViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class TvShowFragment : Fragment() {

    private var _binding: FragmentTvShowBinding? = null
    private val binding get() = _binding

    @Inject lateinit var factory:ViewModelFactory
    private lateinit var viewModel:TvShowViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTvShowBinding.inflate(inflater,container,false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(activity != null){
            viewModel = ViewModelProvider(this,factory)[TvShowViewModel::class.java]
            showHideLoader()
            generateTvShows()
        }
    }

    private fun showHideLoader(){
        viewModel.loader.observe(viewLifecycleOwner){ show->
            isShowComponentProgress(binding?.loadContentTvShow,show)
        }
    }

    private fun generateTvShows() {
        with(binding){
            val adapter = TvShowsAdapter()

            this?.rvTvShow?.layoutManager = LinearLayoutManager(context)
            this?.rvTvShow?.setHasFixedSize(true)

            viewModel.getTvShowList.observe(viewLifecycleOwner){ tvShows->
                adapter.setMovies(tvShows.getOrNull())
                this?.rvTvShow?.adapter = adapter
            }

            adapter.setOnClickListener(object :TvShowsAdapter.ItemsCallback{
                override fun onClickItem(movie: MovieEntity) {
                    val mIntent = Intent(context, DetailMovieActivity::class.java)
                    mIntent.putExtra(DetailMovieActivity.idMovie,movie.movieId)
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