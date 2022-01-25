package bajp.playground.moviecatalogueapp.ui.home.tvshow

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.liveData
import bajp.playground.moviecatalogueapp.repository.MovieRepository
import kotlinx.coroutines.flow.onEach

class TvShowViewModel(
    private val repository: MovieRepository
):ViewModel() {
    val loader = MutableLiveData<Boolean>()

    var getTvShowList = liveData {
        loader.postValue(true)
        emitSource(
            repository.getTvList()
                .onEach {
                    loader.postValue(false)
                }
                .asLiveData()
        )

    }
}