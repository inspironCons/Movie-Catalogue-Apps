package bajp.playground.moviecatalogueapp.remote.network.detail

import bajp.playground.moviecatalogueapp.common.ConstanNameHelper
import bajp.playground.moviecatalogueapp.utils.EspressoIdling
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class DetailService @Inject constructor(
    private val detailMoviesApi: DetailMoviesApi
) {
    fun fetchDetailMovies(id:Int): Flow<Result<DetailMoviesResponse>> {
        return flow {
            EspressoIdling.increment()
            val request = detailMoviesApi.getDetailMovie(
                id,
                ConstanNameHelper.API_KEY,
                ConstanNameHelper.LANGUAGE
            )
            if(!EspressoIdling.getEspressoIdlingResource.isIdleNow){
                EspressoIdling.decrement()
            }
            emit(Result.success(request))
        }.catch {
            if(!EspressoIdling.getEspressoIdlingResource.isIdleNow){
                EspressoIdling.decrement()
            }
            emit(Result.failure(RuntimeException("Something went wrong")))
        }
    }

    suspend fun fetchDetailTV(id:Int): Flow<Result<DetailTvShowsResponse>> {
        return flow {
            EspressoIdling.increment()
            val request = detailMoviesApi.getDetailTv(
                id,
                ConstanNameHelper.API_KEY,
                ConstanNameHelper.LANGUAGE
            )
            if(!EspressoIdling.getEspressoIdlingResource.isIdleNow){
                EspressoIdling.decrement()
            }
            emit(Result.success(request))
        }.catch {
            if(!EspressoIdling.getEspressoIdlingResource.isIdleNow){
                EspressoIdling.decrement()
            }
            emit(Result.failure(RuntimeException("Something went wrong")))
        }
    }
}