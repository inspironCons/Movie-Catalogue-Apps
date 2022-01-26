package bajp.playground.moviewcatalogueapp.repository

import bajp.playground.moviecatalogueapp.data.DetailMovieEntity
import bajp.playground.moviecatalogueapp.remote.local.database.dao.FavoriteDao
import bajp.playground.moviecatalogueapp.remote.network.detail.*
import bajp.playground.moviecatalogueapp.repository.DetailMovieRepository
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
class DetailMovieRepositoryShould:BaseUnitTest() {
    private val idMovieTesting = 634649
    private val idTvTesting = 115036

    private val detailService:DetailService = mock()
    private val detailMoviesMapper:DetailMoviesMapper = mock()
    private val detailTvMapper:DetailTvMapper = mock()
    private val favoriteDao:FavoriteDao = mock()

    private val detailMock = mock<DetailMovieEntity>()
    private val detailResponseMovieMock = mock<DetailMoviesResponse>()
    private val detailResponseTvMock = mock<DetailTvShowsResponse>()

    private val resultFailure = RuntimeException("Something Wrong")

    private suspend fun repoMoviesSuccessfulCase(): DetailMovieRepository {
        whenever(detailService.fetchDetailMovies(idMovieTesting)).thenReturn(
            flow {
                emit(Result.success(detailResponseMovieMock))
            }
        )
        whenever(detailMoviesMapper.invoke(detailResponseMovieMock)).thenReturn(detailMock)
        return DetailMovieRepository(detailService,detailMoviesMapper,detailTvMapper,favoriteDao)
    }

    private suspend fun repoMoviesFailureCase(): DetailMovieRepository {
        whenever(detailService.fetchDetailMovies(idMovieTesting)).thenReturn(
            flow {
                emit(Result.failure(resultFailure))
            }
        )
        return DetailMovieRepository(detailService,detailMoviesMapper,detailTvMapper,favoriteDao)
    }

    private suspend fun repoTvShowSuccessfulCase(): DetailMovieRepository {
        whenever(detailService.fetchDetailTV(idTvTesting)).thenReturn(
            flow {
                emit(Result.success(detailResponseTvMock))
            }
        )
        whenever(detailTvMapper.invoke(detailResponseTvMock)).thenReturn(detailMock)
        return DetailMovieRepository(detailService,detailMoviesMapper,detailTvMapper,favoriteDao)
    }

    private suspend fun repoTvFailureCase(): DetailMovieRepository {
        whenever(detailService.fetchDetailTV(idTvTesting)).thenReturn(
            flow {
                emit(Result.failure(resultFailure))
            }
        )
        return DetailMovieRepository(detailService,detailMoviesMapper,detailTvMapper,favoriteDao)
    }

    private suspend fun daoSuccessfulCase():DetailMovieRepository{
       whenever(favoriteDao.getDetailById(idMovieTesting)).thenReturn(detailMock)
        return DetailMovieRepository(detailService,detailMoviesMapper,detailTvMapper,favoriteDao)
    }

    private suspend fun daoFailureCase():DetailMovieRepository{
        whenever(favoriteDao.getDetailById(idMovieTesting)).thenThrow(resultFailure)
        return DetailMovieRepository(detailService,detailMoviesMapper,detailTvMapper,favoriteDao)
    }

    @Test
    fun getDetailMovieSuccessfulCase()= runBlockingTest{
        val repo = repoMoviesSuccessfulCase()

        val movies = repo.getDetailMovies(idMovieTesting).first()
        verify(detailService, times(1)).fetchDetailMovies(idMovieTesting)
        assertEquals(detailMock,movies.getOrNull())
    }

    @Test
    fun getDetailMovieFailure()= runBlockingTest{
        val repo = repoMoviesFailureCase()
        val movies = repo.getDetailMovies(idMovieTesting).first()
        verify(detailService, times(1)).fetchDetailMovies(idMovieTesting)
        assertEquals(resultFailure,movies.exceptionOrNull())
    }

    @Test
    fun checkingRawDataGetMovieBeforeToMappers()= runBlockingTest{
        val repo = repoMoviesSuccessfulCase()
        repo.getDetailMovies(idMovieTesting).first()
        verify(detailMoviesMapper, times(1)).invoke(detailResponseMovieMock)
    }

    @Test
    fun getDetailTvSuccessfulCase()= runBlockingTest{
        val repo = repoTvShowSuccessfulCase()

        val tv = repo.getDetailTV(idTvTesting).first()
        verify(detailService, times(1)).fetchDetailTV(idTvTesting)
        assertEquals(detailMock,tv.getOrNull())
    }

    @Test
    fun checkingRawDataGetTvBeforeToMappers()= runBlockingTest{
        val repo = repoTvShowSuccessfulCase()
        repo.getDetailTV(idTvTesting).first()
        verify(detailTvMapper, times(1)).invoke(detailResponseTvMock)
    }

    @Test
    fun getDetailTvFailure()= runBlockingTest{
        val repo = repoTvFailureCase()
        val tv = repo.getDetailTV(idTvTesting).first()
        verify(detailService, times(1)).fetchDetailTV(idTvTesting)
        assertEquals(resultFailure,tv.exceptionOrNull())
    }

    @Test
    fun getDetailFromLocalReturnSuccess() = runBlockingTest {
        val repo = daoSuccessfulCase()
        val detail = repo.getDetailFromLocal(idMovieTesting).first()
        verify(favoriteDao, times(1)).getDetailById(idMovieTesting)
        assertEquals(detailMock,detail.getOrNull())
    }

    @Test
    fun getDetailFromLocalReturnFailure() = runBlockingTest {
        val repo = daoFailureCase()
        val detail = repo.getDetailFromLocal(idMovieTesting).first()
        verify(favoriteDao, times(1)).getDetailById(idMovieTesting)
        assertEquals(resultFailure.message,detail.exceptionOrNull()?.message)
    }
}