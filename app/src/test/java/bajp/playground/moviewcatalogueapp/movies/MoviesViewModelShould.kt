package bajp.playground.moviewcatalogueapp.movies

import bajp.playground.moviecatalogueapp.data.MovieEntity
import bajp.playground.moviecatalogueapp.repository.movie.MovieRepository
import bajp.playground.moviecatalogueapp.ui.movies.MoviesViewModel
import bajp.playground.moviewcatalogueapp.utils.BaseUnitTest
import bajp.playground.moviewcatalogueapp.utils.captureValues
import bajp.playground.moviewcatalogueapp.utils.getValueForTest
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertEquals
import org.junit.Test
import java.lang.RuntimeException
import java.util.*

class MoviesViewModelShould: BaseUnitTest() {

    private val movieRepo:MovieRepository = mock()
    private val mockMovieList = mock<List<MovieEntity>>()
    private val expectedSuccess = Result.success(mockMovieList)
    private val expectedEmpty = Result.success(Collections.emptyList<MovieEntity>())
    private val expectedException = Result.failure<List<MovieEntity>>(RuntimeException("Something Went Wrong"))


    @ExperimentalCoroutinesApi
    @Test
    fun getMoviesListFromRepositoryThenSuccess() = runBlockingTest{
        val viewModel = moviesSuccessViewModel()
        val data = viewModel.getMovieList.getValueForTest()
        verify(movieRepo, times(1)).getPlaylist(1)
        assertEquals(expectedSuccess,data)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun getMoviesListFromRepositoryThenEmpty() = runBlockingTest{
        val viewModel = moviesEmptyViewModel()
        val data = viewModel.getMovieList.getValueForTest()
        verify(movieRepo, times(1)).getPlaylist(1)
        assertEquals(expectedEmpty,data)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun getMoviesListFromRepositoryThenException() = runBlockingTest{
        val viewModel = moviesFailureViewModel()
        val data = viewModel.getMovieList.getValueForTest()
        verify(movieRepo, times(1)).getPlaylist(1)
        assertEquals(expectedException,data)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun showLoaderWhenLoadMovieList() = runBlockingTest{
        val vieModel = moviesSuccessViewModel()
        vieModel.loader.captureValues {
            vieModel.getMovieList.getValueForTest()
            assertEquals(true,values[0])
        }
    }

    @ExperimentalCoroutinesApi
    @Test
    fun hideLoaderWhenLoadMovieListIsDone() = runBlockingTest{
        val vieModel = moviesSuccessViewModel()
        vieModel.loader.captureValues {
            vieModel.getMovieList.getValueForTest()
            assertEquals(false,values.last())
        }
    }

    @ExperimentalCoroutinesApi
    private fun moviesSuccessViewModel():MoviesViewModel{
        runBlockingTest {
            whenever(movieRepo.getPlaylist(1)).thenReturn(
                flow {
                    emit(expectedSuccess)
                }
            )
        }

        return MoviesViewModel(movieRepo)
    }


    @ExperimentalCoroutinesApi
    private fun moviesEmptyViewModel():MoviesViewModel{
        runBlockingTest {
            whenever(movieRepo.getPlaylist(1)).thenReturn(
                flow {
                    emit(expectedEmpty)
                }
            )
        }

        return MoviesViewModel(movieRepo)
    }

    @ExperimentalCoroutinesApi
    private fun moviesFailureViewModel():MoviesViewModel{
        runBlockingTest {
            whenever(movieRepo.getPlaylist(1)).thenReturn(
                flow {
                    emit(expectedException)
                }
            )
        }

        return MoviesViewModel(movieRepo)
    }
}