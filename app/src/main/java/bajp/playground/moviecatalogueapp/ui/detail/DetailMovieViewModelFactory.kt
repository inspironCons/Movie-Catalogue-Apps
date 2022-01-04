package bajp.playground.moviecatalogueapp.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import bajp.playground.moviecatalogueapp.repository.movie.MovieRepository

class DetailMovieViewModelFactory(
    private val repository: MovieRepository
):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return DetailMovieViewModel(repository) as T
    }
}