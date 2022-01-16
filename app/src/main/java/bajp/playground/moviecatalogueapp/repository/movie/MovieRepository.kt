package bajp.playground.moviecatalogueapp.repository.movie

import bajp.playground.moviecatalogueapp.data.TrendingEntity
import bajp.playground.moviecatalogueapp.remote.network.trending.TrendingMovieMapper
import bajp.playground.moviecatalogueapp.remote.network.trending.TrendingService
import bajp.playground.moviecatalogueapp.remote.network.trending.TrendingTVMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class MovieRepository @Inject constructor(
    private val service: TrendingService,
    private val mapperMovie:TrendingMovieMapper,
    private val mapperTv:TrendingTVMapper,
) {

    suspend fun getMoviesList():Flow<Result<List<TrendingEntity>>> =
        service.fetchApiMovieList().map {
            if(it.isSuccess){
                Result.success(mapperMovie(it.getOrNull()))
            }else{
                Result.failure(it.exceptionOrNull()!!)
            }
        }

    suspend fun getTvList():Flow<Result<List<TrendingEntity>>> =
        service.fetchApiTvList().map {
        if(it.isSuccess){
            Result.success(mapperTv(it.getOrNull()))
        }else{
            Result.failure(it.exceptionOrNull()!!)
        }
    }
}