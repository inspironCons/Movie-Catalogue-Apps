package bajp.playground.moviecatalogueapp.repository

import bajp.playground.moviecatalogueapp.data.DetailMovieEntity
import bajp.playground.moviecatalogueapp.remote.network.detail.DetailMoviesMapper
import bajp.playground.moviecatalogueapp.remote.network.detail.DetailService
import bajp.playground.moviecatalogueapp.remote.network.detail.DetailTvMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class DetailMovieRepository @Inject constructor(
    private val service:DetailService,
    private val detailMovieMapper:DetailMoviesMapper,
    private val detailTvMapper:DetailTvMapper
) {

    fun getDetailMovies(id:Int):Flow<Result<DetailMovieEntity>> =
        service.fetchDetailMovies(id).map {
            if(it.isSuccess){
                Result.success(detailMovieMapper(it.getOrNull()))
            }else{
                Result.failure(it.exceptionOrNull()!!)
            }
        }

    suspend fun getDetailTV(id:Int):Flow<Result<DetailMovieEntity>> =
        service.fetchDetailTV(id).map {
            if(it.isSuccess){
                Result.success(detailTvMapper(it.getOrNull()))
            }else{
                Result.failure(it.exceptionOrNull()!!)
            }
        }
}