package bajp.playground.moviecatalogueapp.remote.network.trending

import bajp.playground.moviecatalogueapp.common.ConstanNameHelper
import bajp.playground.moviecatalogueapp.utils.EspressoIdling
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class TrendingService @Inject constructor(
    private val trendingApi: TrendingApi
) {
    suspend fun fetchApiMovieList(): Flow<Result<List<ResultsMovieResponse>>> {
        return flow{
//            EspressoIdling.increment()
            val request = trendingApi.getTrendingMovieOnThisWeek(
                ConstanNameHelper.API_KEY,
                ConstanNameHelper.LANGUAGE,
                ConstanNameHelper.REGIONS
            )
//            if(!EspressoIdling.getEspressoIdlingResource.isIdleNow){
//                EspressoIdling.decrement()
//            }
            emit(Result.success(request.results))
        }.catch {
//            if(!EspressoIdling.getEspressoIdlingResource.isIdleNow){
//                EspressoIdling.decrement()
//            }
            emit(Result.failure(RuntimeException("Something went wrong")))
        }
    }

    suspend fun fetchApiTvList(): Flow<Result<List<ResultsTvResponse>>> {
        return flow{
//            EspressoIdling.increment()
            val request = trendingApi.getTrendingTvShowsOnThisWeek(
                ConstanNameHelper.API_KEY,
                ConstanNameHelper.LANGUAGE,
                ConstanNameHelper.REGIONS
            )
//            if(!EspressoIdling.getEspressoIdlingResource.isIdleNow){
//                EspressoIdling.decrement()
//            }
            emit(Result.success(request.results))
        }.catch {
//            if(!EspressoIdling.getEspressoIdlingResource.isIdleNow){
//                EspressoIdling.decrement()
//            }
            emit(Result.failure(RuntimeException("Something went wrong")))
        }
    }
}