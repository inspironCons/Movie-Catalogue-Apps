package bajp.playground.moviecatalogueapp.ui.movies

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import bajp.playground.moviecatalogueapp.data.MovieEntity
import bajp.playground.moviecatalogueapp.databinding.FragmentMoviesBinding
import bajp.playground.moviecatalogueapp.repository.movie.MovieRepository
import bajp.playground.moviecatalogueapp.ui.detail.DetailMovieActivity
import bajp.playground.moviecatalogueapp.utils.DummyData
import bajp.playground.moviecatalogueapp.utils.General.isShowComponentProgress

class MoviesFragment : Fragment() {

    private var _binding: FragmentMoviesBinding? = null
    private val binding get()=_binding

    private lateinit var viewModel: MoviesViewModel
    private val dummyData = DummyData
    private val moviesRepository = MovieRepository(dummyData)
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
            val factory =MoviesViewModelFactory(moviesRepository)
            viewModel = ViewModelProvider(this,factory)[MoviesViewModel::class.java]
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