package bajp.playground.moviecatalogueapp.ui.favorite.tvshows

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import bajp.playground.moviecatalogueapp.common.ConstanNameHelper.TV_TYPE
import bajp.playground.moviecatalogueapp.data.DetailMovieEntity
import bajp.playground.moviecatalogueapp.repository.FavoriteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class TvShowsFavoriteViewModel @Inject constructor(
    private val favoriteRepository: FavoriteRepository
) :ViewModel() {
    val getListMovie: Flow<PagingData<DetailMovieEntity>> = Pager(
        config = PagingConfig(pageSize = 10, prefetchDistance = 1, maxSize = 100)
    ){
        favoriteRepository.getFavoriteMovieByType(TV_TYPE)
    }.flow
        .cachedIn(viewModelScope)

}