package bajp.playground.moviecatalogueapp.ui.movies

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.liveData
import bajp.playground.moviecatalogueapp.repository.movie.MovieRepository
import kotlinx.coroutines.flow.onEach

class MoviesViewModel(
    private val repository: MovieRepository
) :ViewModel() {
    val loader =MutableLiveData<Boolean>()

    var getMovieList = liveData {
        loader.postValue(true)
        emitSource(
            repository.getMoviesList()
                .onEach {
                    loader.postValue(false)
                }
                .asLiveData()
        )
    }

}