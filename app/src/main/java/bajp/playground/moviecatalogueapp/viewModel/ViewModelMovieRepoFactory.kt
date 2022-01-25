package bajp.playground.moviecatalogueapp.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import bajp.playground.moviecatalogueapp.repository.MovieRepository
import bajp.playground.moviecatalogueapp.ui.home.movies.MoviesViewModel
import bajp.playground.moviecatalogueapp.ui.home.tvshow.TvShowViewModel
import javax.inject.Inject

class ViewModelMovieRepoFactory @Inject constructor(
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
            else->throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
    }
}