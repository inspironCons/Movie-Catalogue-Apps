package bajp.playground.moviecatalogueapp.ui.movies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import bajp.playground.moviecatalogueapp.repository.movie.MovieRepository

class MoviesViewModelFactory(
    private val repository: MovieRepository
):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MoviesViewModel(repository) as T
    }
}