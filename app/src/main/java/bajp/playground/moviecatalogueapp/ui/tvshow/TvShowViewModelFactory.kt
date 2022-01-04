package bajp.playground.moviecatalogueapp.ui.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import bajp.playground.moviecatalogueapp.repository.movie.MovieRepository

class TvShowViewModelFactory(
    private val repository: MovieRepository
):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TvShowViewModel(repository) as T
    }
}