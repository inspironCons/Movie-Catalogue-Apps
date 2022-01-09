package bajp.playground.moviecatalogueapp.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import bajp.playground.moviecatalogueapp.repository.movie.MovieRepository
import bajp.playground.moviecatalogueapp.ui.detail.DetailMovieViewModel
import bajp.playground.moviecatalogueapp.ui.movies.MoviesViewModel
import bajp.playground.moviecatalogueapp.ui.tvshow.TvShowViewModel
import javax.inject.Inject

class ViewModelFactory @Inject constructor(
    private val repository: MovieRepository
):ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when{
            modelClass.isAssignableFrom(MoviesViewModel::class.java)->{
                MoviesViewModel(repository) as T
            }
            modelClass.isAssignableFrom(TvShowViewModel::class.java)->{
                TvShowViewModel(repository) as T
            }
            modelClass.isAssignableFrom(DetailMovieViewModel::class.java)->{
                DetailMovieViewModel(repository) as T
            }
            else->throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
    }
}