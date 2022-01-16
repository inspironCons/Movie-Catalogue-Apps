package bajp.playground.moviecatalogueapp.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.liveData
import bajp.playground.moviecatalogueapp.common.ConstanNameHelper
import bajp.playground.moviecatalogueapp.repository.movie.DetailMovieRepository

class DetailMovieViewModel(
    private val repository: DetailMovieRepository
):ViewModel() {

    fun detailMovie(id:Int,type:String) =  liveData {
        if(type == ConstanNameHelper.MOVIES_TYPE){
            emitSource(repository.getDetailMovies(id).asLiveData())
        }else{
            emitSource(repository.getDetailTV(id).asLiveData())
        }
    }
}