package bajp.playground.moviecatalogueapp.remote.network.detail

import bajp.playground.moviecatalogueapp.common.ConstanNameHelper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class DetailService @Inject constructor(
    private val detailMoviesApi: DetailMoviesApi
) {
    suspend fun fetchDetailMovies(id:Int): Flow<Result<DetailMoviesResponse>> {
        return flow {
            val request = detailMoviesApi.getDetailMovie(
                id,
                ConstanNameHelper.API_KEY,
                ConstanNameHelper.LANGUAGE
            )
            emit(Result.success(request))
        }.catch {
            emit(Result.failure(RuntimeException("Something went wrong")))
        }
    }

    suspend fun fetchDetailTV(id:Int): Flow<Result<DetailTvShowsResponse>> {
        return flow {
            val request = detailMoviesApi.getDetailTv(
                id,
                ConstanNameHelper.API_KEY,
                ConstanNameHelper.LANGUAGE
            )
            emit(Result.success(request))
        }.catch {
            emit(Result.failure(RuntimeException("Something went wrong")))
        }
    }
}