package bajp.playground.moviewcatalogueapp.movies

import bajp.playground.moviecatalogueapp.data.TrendingEntity
import bajp.playground.moviecatalogueapp.repository.MovieRepository
import bajp.playground.moviecatalogueapp.ui.home.movies.MoviesViewModel
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
import java.util.*


@ExperimentalCoroutinesApi
class MoviesViewModelShould: BaseUnitTest() {

    private val movieRepo: MovieRepository = mock()
    private val mockMovieList = mock<List<TrendingEntity>>()
    private val expectedSuccess = Result.success(mockMovieList)
    private val expectedEmpty = Result.success(Collections.emptyList<TrendingEntity>())
    private val expectedException = Result.failure<List<TrendingEntity>>(RuntimeException("Something Went Wrong"))


    @Test
    fun getMoviesListFromRepositoryThenSuccess() = runBlockingTest{
        val viewModel = moviesSuccessViewModel()
        val data = viewModel.getMovieList.getValueForTest()
        verify(movieRepo, times(1)).getMoviesList()
        assertEquals(expectedSuccess,data)
    }

    @Test
    fun getMoviesListFromRepositoryThenEmpty() = runBlockingTest{
        val viewModel = moviesEmptyViewModel()
        val data = viewModel.getMovieList.getValueForTest()
        verify(movieRepo, times(1)).getMoviesList()
        assertEquals(expectedEmpty,data)
    }

    @Test
    fun getMoviesListFromRepositoryThenException() = runBlockingTest{
        val viewModel = moviesFailureViewModel()
        val data = viewModel.getMovieList.getValueForTest()
        verify(movieRepo, times(1)).getMoviesList()
        assertEquals(expectedException,data)
    }

    @Test
    fun showLoaderWhenLoadMovieList() = runBlockingTest{
        val vieModel = moviesSuccessViewModel()
        vieModel.loader.captureValues {
            vieModel.getMovieList.getValueForTest()
            assertEquals(true,values[0])
        }
    }

    @Test
    fun hideLoaderWhenLoadMovieListIsDone() = runBlockingTest{
        val vieModel = moviesSuccessViewModel()
        vieModel.loader.captureValues {
            vieModel.getMovieList.getValueForTest()
            assertEquals(false,values.last())
        }
    }

    private fun moviesSuccessViewModel():MoviesViewModel{
        runBlockingTest {
            whenever(movieRepo.getMoviesList()).thenReturn(
                flow {
                    emit(expectedSuccess)
                }
            )
        }

        return MoviesViewModel(movieRepo)
    }


    private fun moviesEmptyViewModel():MoviesViewModel{
        runBlockingTest {
            whenever(movieRepo.getMoviesList()).thenReturn(
                flow {
                    emit(expectedEmpty)
                }
            )
        }

        return MoviesViewModel(movieRepo)
    }

    private fun moviesFailureViewModel():MoviesViewModel{
        runBlockingTest {
            whenever(movieRepo.getMoviesList()).thenReturn(
                flow {
                    emit(expectedException)
                }
            )
        }

        return MoviesViewModel(movieRepo)
    }
}