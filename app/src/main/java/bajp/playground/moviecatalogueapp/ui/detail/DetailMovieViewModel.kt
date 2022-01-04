package bajp.playground.moviecatalogueapp.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.liveData
import bajp.playground.moviecatalogueapp.repository.movie.MovieRepository

class DetailMovieViewModel(
    private val repository: MovieRepository
):ViewModel() {
    fun detailMovie(id:String) =  liveData {
        emitSource(repository.getDetailPlaylist(id).asLiveData())
    }
}