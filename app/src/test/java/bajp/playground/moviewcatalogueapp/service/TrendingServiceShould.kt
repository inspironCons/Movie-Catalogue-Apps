package bajp.playground.moviewcatalogueapp.service

import bajp.playground.moviecatalogueapp.common.ConstanNameHelper
import bajp.playground.moviecatalogueapp.remote.network.trending.*
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
import java.lang.RuntimeException
@ExperimentalCoroutinesApi
class TrendingServiceShould:BaseUnitTest() {

    private val api:TrendingApi = mock()
    private val movieFromNetworkResult = mock<TrendingMovieResponse>()
    private val tvShowsFromNetworkResult = mock<TrendingTvResponse>()


    private suspend fun mockMovieSuccessCase():TrendingService{
        whenever(api.getTrendingMovieOnThisWeek(
            ConstanNameHelper.API_KEY,
            ConstanNameHelper.LANGUAGE,
            ConstanNameHelper.REGIONS
        )).thenReturn(movieFromNetworkResult)

        return TrendingService(api)
    }

    private suspend fun mockMovieFailureCase():TrendingService{
        whenever(api.getTrendingMovieOnThisWeek(
            ConstanNameHelper.API_KEY,
            ConstanNameHelper.LANGUAGE,
            ConstanNameHelper.REGIONS
        )).thenThrow(RuntimeException("Something went wrong"))

        return TrendingService(api)
    }

    private suspend fun mockTvShowsSuccessCase():TrendingService{
        whenever(api.getTrendingTvShowsOnThisWeek(
            ConstanNameHelper.API_KEY,
            ConstanNameHelper.LANGUAGE,
            ConstanNameHelper.REGIONS
        )).thenReturn(tvShowsFromNetworkResult)

        return TrendingService(api)
    }

    private suspend fun mockTvShowsFailureCase():TrendingService{
        whenever(api.getTrendingTvShowsOnThisWeek(
            ConstanNameHelper.API_KEY,
            ConstanNameHelper.LANGUAGE,
            ConstanNameHelper.REGIONS
        )).thenThrow(RuntimeException("Something went wrong"))

        return TrendingService(api)
    }

    @Test
    fun getMovieFromApiThenSuccess() = runBlockingTest {
        val service = mockMovieSuccessCase()
        val data = service.fetchApiMovieList().first()
        verify(api, times(1)).getTrendingMovieOnThisWeek(
            ConstanNameHelper.API_KEY,
            ConstanNameHelper.LANGUAGE,
            ConstanNameHelper.REGIONS)

        assertEquals(movieFromNetworkResult.results,data.getOrNull())
    }

    @Test
    fun getMovieFromApiThenNetworkFail() = runBlockingTest {
        val service = mockMovieFailureCase()
        val data = service.fetchApiMovieList().first()
        verify(api, times(1)).getTrendingMovieOnThisWeek(
            ConstanNameHelper.API_KEY,
            ConstanNameHelper.LANGUAGE,
            ConstanNameHelper.REGIONS)

        assertEquals("Something went wrong",data.exceptionOrNull()?.message)
    }

    @Test
    fun getTvShowsFromApiThenSuccess() = runBlockingTest {
        val service = mockTvShowsSuccessCase()
        val data = service.fetchApiTvList().first()
        verify(api, times(1)).getTrendingTvShowsOnThisWeek(
            ConstanNameHelper.API_KEY,
            ConstanNameHelper.LANGUAGE,
            ConstanNameHelper.REGIONS)

        assertEquals(movieFromNetworkResult.results,data.getOrNull())
    }

    @Test
    fun getTvShowsFromApiThenNetworkFail() = runBlockingTest {
        val service = mockTvShowsFailureCase()
        val data = service.fetchApiTvList().first()
        verify(api, times(1)).getTrendingTvShowsOnThisWeek(
            ConstanNameHelper.API_KEY,
            ConstanNameHelper.LANGUAGE,
            ConstanNameHelper.REGIONS)

        assertEquals("Something went wrong",data.exceptionOrNull()?.message)
    }
}