package bajp.playground.moviewcatalogueapp.repository

import androidx.paging.PagingSource
import bajp.playground.moviecatalogueapp.common.ConstanNameHelper.MOVIES_TYPE
import bajp.playground.moviecatalogueapp.data.DetailMovieEntity
import bajp.playground.moviecatalogueapp.remote.local.database.dao.FavoriteDao
import bajp.playground.moviecatalogueapp.repository.FavoriteRepository
import bajp.playground.moviewcatalogueapp.utils.BaseUnitTest
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertEquals
import org.junit.Test

@ExperimentalCoroutinesApi
class FavoriteMovieRepositoryShould:BaseUnitTest() {

    private val favoriteDao:FavoriteDao = mock()
    private val listFavorite = mock<PagingSource<Int,DetailMovieEntity>>()
    private val payload = mock<DetailMovieEntity>()
    private val idMovieTesting = 634649
    private val movieAlreadyExist = 1
    private val movieNotAvailable = 0
    private val runtimeMsg = "Something Wrong"


    private fun successfulCaseMovieDao(): FavoriteRepository {
        runBlockingTest {
            whenever(favoriteDao.getMovies(MOVIES_TYPE)).thenReturn(
                listFavorite
            )

        }
        return FavoriteRepository(favoriteDao)
    }

    @Test
    fun getFavoriteMovieByType() = runBlockingTest {
        val repo = successfulCaseMovieDao()
        val data = repo.getFavoriteMovieByType(MOVIES_TYPE)
        verify(favoriteDao, times(1)).getMovies(MOVIES_TYPE)
        assertEquals(listFavorite,data)
    }

    @Test
    fun checkingMoviesNotAvailableInLocal() = runBlockingTest {
        whenever(favoriteDao.countMoviesById(idMovieTesting)).thenReturn(movieNotAvailable)

        val repo = FavoriteRepository(favoriteDao)
        val count = repo.isMoviesInTheFavoriteSegment(idMovieTesting).first()
        verify(favoriteDao, times(1)).countMoviesById(idMovieTesting)
        assertEquals(false,count.getOrNull())
    }

    @Test
    fun checkingMoviesAvailableInLocal() = runBlockingTest {
        whenever(favoriteDao.countMoviesById(idMovieTesting)).thenReturn(movieAlreadyExist)
        val repo = FavoriteRepository(favoriteDao)
        val count = repo.isMoviesInTheFavoriteSegment(idMovieTesting).first()
        verify(favoriteDao, times(1)).countMoviesById(idMovieTesting)
        assertEquals(true,count.getOrNull())
    }

    @Test
    fun checkingMoviesAreAvailableInLocalButErrorRuntime() = runBlockingTest {
        whenever(favoriteDao.countMoviesById(idMovieTesting)).thenThrow(
            RuntimeException("Something Wrong")
        )
        val repo = FavoriteRepository(favoriteDao)
        val count = repo.isMoviesInTheFavoriteSegment(idMovieTesting).first()
        verify(favoriteDao, times(1)).countMoviesById(idMovieTesting)
        assertEquals(runtimeMsg,count.exceptionOrNull()?.message)
    }

    @Test
    fun checkingInsertMovie() = runBlockingTest {
        val repo = FavoriteRepository(favoriteDao)
        repo.insertMoviesFavorite(payload).collect()
        verify(favoriteDao, times(1)).insert(payload)
    }

}