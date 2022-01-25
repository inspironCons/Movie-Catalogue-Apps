package bajp.playground.moviecatalogueapp.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import bajp.playground.moviecatalogueapp.repository.DetailMovieRepository
import bajp.playground.moviecatalogueapp.repository.FavoriteRepository
import bajp.playground.moviecatalogueapp.ui.detail.DetailMovieViewModel
import javax.inject.Inject

class ViewModelDetailMovieRepoFactory @Inject constructor(
    private val repository: DetailMovieRepository,
    private val favoriteRepository: FavoriteRepository
):ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when{
            modelClass.isAssignableFrom(DetailMovieViewModel::class.java)->{
                DetailMovieViewModel(repository,favoriteRepository) as T
            }
            else->throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
    }
}