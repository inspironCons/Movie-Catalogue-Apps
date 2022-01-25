package bajp.playground.moviecatalogueapp.ui.detail

import androidx.lifecycle.*
import bajp.playground.moviecatalogueapp.common.ConstanNameHelper.MOVIES_TYPE
import bajp.playground.moviecatalogueapp.data.DetailMovieEntity
import bajp.playground.moviecatalogueapp.repository.DetailMovieRepository
import bajp.playground.moviecatalogueapp.repository.FavoriteRepository
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class DetailMovieViewModel(
    private val repository: DetailMovieRepository,
    private val favoriteRepo: FavoriteRepository
):ViewModel() {
    var movies: DetailMovieEntity = DetailMovieEntity()
    var isMovieFavorite = MutableLiveData<Boolean>()

    fun setDetailMovie(data:DetailMovieEntity?,type:String){
       if(data != null){
           movies = data
           movies.type = type
       }
    }
    fun detailMovie(id:Int,type:String) =  liveData {
        if(type == MOVIES_TYPE){
            emitSource(repository.getDetailMovies(id).asLiveData())
        }else{
            emitSource(repository.getDetailTV(id).asLiveData())
        }
    }

    fun checkFavorite() = viewModelScope.launch {
        favoriteRepo.isMoviesInTheFavoriteSegment(movies.movieId).collectLatest {
            isMovieFavorite.postValue(
                if (it.isSuccess) {
                    val state = it.getOrDefault(false)
                    state
                } else {
                    false
                }
            )
        }
    }

    fun getFavorite():LiveData<Boolean> = isMovieFavorite

    fun saveToFavorite() = liveData {
        if(isMovieFavorite.value == false){
            emitSource(favoriteRepo.insertMoviesFavorite(movies).asLiveData())
        }else {
            emitSource(favoriteRepo.deleteMovieFavorite(movies).asLiveData())
        }
    }
}