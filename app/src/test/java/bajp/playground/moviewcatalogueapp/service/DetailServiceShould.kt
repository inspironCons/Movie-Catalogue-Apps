package bajp.playground.moviewcatalogueapp.service

import bajp.playground.moviecatalogueapp.common.ConstanNameHelper
import bajp.playground.moviecatalogueapp.remote.network.detail.DetailMoviesApi
import bajp.playground.moviecatalogueapp.remote.network.detail.DetailMoviesResponse
import bajp.playground.moviecatalogueapp.remote.network.detail.DetailService
import bajp.playground.moviecatalogueapp.remote.network.detail.DetailTvShowsResponse
import bajp.playground.moviewcatalogueapp.utils.BaseUnitTest
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertEquals
import org.junit.Test

@ExperimentalCoroutinesApi
class DetailServiceShould:BaseUnitTest() {
    private val api:DetailMoviesApi = mock()
    private val detailResponseMovieMock = mock<DetailMoviesResponse>()
    private val detailResponseTvMock = mock<DetailTvShowsResponse>()
    private val idMovieTesting = 634649
    private val idTvTesting = 115036

    private suspend fun mockRequestApiGetDetailMovieSuccessfulCase():DetailService{
        whenever(api.getDetailMovie(
            idMovieTesting,
            ConstanNameHelper.API_KEY,
            ConstanNameHelper.LANGUAGE
        )).thenReturn(detailResponseMovieMock)

        return DetailService(api)
    }

    private suspend fun mockRequestApiGetDetailMovieFailureCase():DetailService{
        whenever(api.getDetailMovie(
            idMovieTesting,
            ConstanNameHelper.API_KEY,
            ConstanNameHelper.LANGUAGE
        )).thenThrow(RuntimeException("Something went wrong"))

        return DetailService(api)
    }

    private suspend fun mockRequestApiGetDetailTvSuccessfulCase():DetailService{
        whenever(api.getDetailTv(
            idTvTesting,
            ConstanNameHelper.API_KEY,
            ConstanNameHelper.LANGUAGE
        )).thenReturn(detailResponseTvMock)

        return DetailService(api)
    }

    private suspend fun mockRequestApiGetDetailTvFailureCase():DetailService{
        whenever(api.getDetailTv(
            idTvTesting,
            ConstanNameHelper.API_KEY,
            ConstanNameHelper.LANGUAGE
        )).thenThrow(RuntimeException("Something went wrong"))

        return DetailService(api)
    }

    @Test
    fun getDetailMoviesFromApiService() = runBlockingTest {
        val service = mockRequestApiGetDetailMovieSuccessfulCase()
        val request = service.fetchDetailMovies(idMovieTesting).first()
        verify(api, times(1)).getDetailMovie(
            idMovieTesting,
            ConstanNameHelper.API_KEY,
            ConstanNameHelper.LANGUAGE
        )

        assertEquals(detailResponseMovieMock,request.getOrNull())
    }

    @Test
    fun getDetailMoviesFromApiServiceThenNetworkFails() = runBlockingTest {
        val service = mockRequestApiGetDetailMovieFailureCase()
        val request = service.fetchDetailMovies(idMovieTesting).first()
        verify(api, times(1)).getDetailMovie(
            idMovieTesting,
            ConstanNameHelper.API_KEY,
            ConstanNameHelper.LANGUAGE
        )

        assertEquals("Something went wrong",request.exceptionOrNull()?.message)
    }


    @Test
    fun getDetailTvShowsFromApiService() = runBlockingTest {
        val service = mockRequestApiGetDetailTvSuccessfulCase()
        val request = service.fetchDetailTV(idTvTesting).first()
        verify(api, times(1)).getDetailTv(
            idTvTesting,
            ConstanNameHelper.API_KEY,
            ConstanNameHelper.LANGUAGE
        )

        assertEquals(detailResponseTvMock,request.getOrNull())
    }

    @Test
    fun getDetailTvShowsFromApiServiceThenNetworkFails() = runBlockingTest {
        val service = mockRequestApiGetDetailTvFailureCase()
        val request = service.fetchDetailTV(idTvTesting).first()
        verify(api, times(1)).getDetailTv(
            idTvTesting,
            ConstanNameHelper.API_KEY,
            ConstanNameHelper.LANGUAGE
        )
        assertEquals("Something went wrong",request.exceptionOrNull()?.message)
    }
}