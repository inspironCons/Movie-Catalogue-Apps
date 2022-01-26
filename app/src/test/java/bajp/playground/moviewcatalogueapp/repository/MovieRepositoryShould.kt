package bajp.playground.moviewcatalogueapp.repository

import bajp.playground.moviecatalogueapp.data.TrendingEntity
import bajp.playground.moviecatalogueapp.remote.network.trending.*
import bajp.playground.moviecatalogueapp.repository.MovieRepository
import bajp.playground.moviewcatalogueapp.utils.BaseUnitTest
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertEquals
import org.junit.Test

@ExperimentalCoroutinesApi
class MovieRepositoryShould:BaseUnitTest() {

    private val service:TrendingService = mock()
    private val mapperMovie: TrendingMovieMapper = mock()
    private val mapperTv: TrendingTVMapper = mock()
    private val movieList = mock<List<TrendingEntity>>()
    private val movieListFromNetwork = mock<List<ResultsMovieResponse>>()
    private val tvShowsListFromNetwork = mock<List<ResultsTvResponse>>()
    private val exception = RuntimeException("Ops something went wrong")

    private suspend fun mockMovieSuccessCase(): MovieRepository {
        whenever(service.fetchApiMovieList()).thenReturn(
            flow {
                emit(Result.success(movieListFromNetwork))
            }
        )
        whenever(mapperMovie.invoke(movieListFromNetwork)).thenReturn(movieList)
        return MovieRepository(service,mapperMovie,mapperTv)
    }

    private suspend fun mockMovieFailureCase(): MovieRepository {
        whenever(service.fetchApiMovieList()).thenReturn(
            flow {
                emit(Result.failure(exception))
            }
        )
        return MovieRepository(service,mapperMovie,mapperTv)
    }

    private suspend fun mockTvSuccessCase(): MovieRepository {
        whenever(service.fetchApiTvList()).thenReturn(
            flow {
                emit(Result.success(tvShowsListFromNetwork))
            }
        )
        whenever(mapperTv.invoke(tvShowsListFromNetwork)).thenReturn(movieList)
        return MovieRepository(service,mapperMovie,mapperTv)
    }

    private suspend fun mockTvFailureCase(): MovieRepository {
        whenever(service.fetchApiTvList()).thenReturn(
            flow {
                emit(Result.failure(exception))
            }
        )
        return MovieRepository(service,mapperMovie,mapperTv)
    }

    @Test
    fun getMoviesListFromApiService() = runBlockingTest{
        val repo = mockMovieSuccessCase()
        val data = repo.getMoviesList()
        verify(service, times(1)).fetchApiMovieList()
        assertEquals(movieList  ,data.first().getOrNull())
    }

    @Test
    fun getMoviesListFromApiServiceThenFailure() = runBlockingTest{
        val repo = mockMovieFailureCase()
        val data = repo.getMoviesList()
        verify(service, times(1)).fetchApiMovieList()
        assertEquals(exception  ,data.first().exceptionOrNull())
    }

    @Test
    fun checkingRawDataGetMovieListFromApiBeforeToMapperMovie() = runBlockingTest {
        val repo = mockMovieSuccessCase()
        repo.getMoviesList().first()
        verify(mapperMovie, times(1)).invoke(movieListFromNetwork)
    }

    @Test
    fun getTvShowsListFromApiService() = runBlockingTest{
        val repo = mockTvSuccessCase()
        val data = repo.getTvList()
        verify(service, times(1)).fetchApiTvList()
        assertEquals(movieList  ,data.first().getOrNull())
    }

    @Test
    fun getTvShowsListFromApiServiceThenFailure() = runBlockingTest{
        val repo = mockTvFailureCase()
        val data = repo.getTvList()
        verify(service, times(1)).fetchApiTvList()
        assertEquals(exception  ,data.first().exceptionOrNull())
    }

    @Test
    fun checkingRawDataGetTvListFromApiBeforeToMapperMovie() = runBlockingTest {
        val repo = mockTvSuccessCase()
        repo.getTvList().first()
        verify(mapperTv, times(1)).invoke(tvShowsListFromNetwork)
    }


}