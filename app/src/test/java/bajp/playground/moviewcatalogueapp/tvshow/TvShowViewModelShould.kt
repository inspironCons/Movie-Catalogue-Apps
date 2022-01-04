package bajp.playground.moviewcatalogueapp.tvshow

import bajp.playground.moviecatalogueapp.data.MovieEntity
import bajp.playground.moviecatalogueapp.repository.movie.MovieRepository
import bajp.playground.moviecatalogueapp.ui.tvshow.TvShowViewModel
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
import org.junit.Assert
import org.junit.Test
import java.util.*

class TvShowViewModelShould: BaseUnitTest() {
    private val movieRepo: MovieRepository = mock()
    private val mockTvShowList = mock<List<MovieEntity>>()
    private val expectedSuccess = Result.success(mockTvShowList)
    private val expectedEmpty = Result.success(Collections.emptyList<MovieEntity>())
    private val expectedException = Result.failure<List<MovieEntity>>(RuntimeException("Something Went Wrong"))


    @ExperimentalCoroutinesApi
    @Test
    fun showLoaderWhenLoadMovieList() = runBlockingTest{
        val vieModel = moviesSuccessViewModel()
        vieModel.loader.captureValues {
            vieModel.getTvShowList.getValueForTest()
            Assert.assertEquals(true,values[0])
        }
    }

    @ExperimentalCoroutinesApi
    @Test
    fun hideLoaderWhenLoadMovieListIsDone() = runBlockingTest{
        val vieModel = moviesSuccessViewModel()
        vieModel.loader.captureValues {
            vieModel.getTvShowList.getValueForTest()
            Assert.assertEquals(false,values.last())
        }
    }

    @ExperimentalCoroutinesApi
    @Test
    fun getTvShowListFromRepositoryThenSuccess() = runBlockingTest{
        val viewModel = moviesSuccessViewModel()
        val data = viewModel.getTvShowList.getValueForTest()
        verify(movieRepo, times(1)).getPlaylist(2)
        Assert.assertEquals(expectedSuccess, data)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun getTvShowListFromRepositoryThenEmpty() = runBlockingTest{
        val viewModel = tvShowEmptyViewModel()
        val data = viewModel.getTvShowList.getValueForTest()
        verify(movieRepo, times(1)).getPlaylist(2)
        Assert.assertEquals(expectedEmpty, data)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun getTvShowListFromRepositoryThenException() = runBlockingTest{
        val viewModel = tvShowFailureViewModel()
        val data = viewModel.getTvShowList.getValueForTest()
        verify(movieRepo, times(1)).getPlaylist(2)
        Assert.assertEquals(expectedException, data)
    }

    @ExperimentalCoroutinesApi
    private fun moviesSuccessViewModel(): TvShowViewModel {
        runBlockingTest {
            whenever(movieRepo.getPlaylist(2)).thenReturn(
                flow {
                    emit(expectedSuccess)
                }
            )
        }

        return TvShowViewModel(movieRepo)
    }


    @ExperimentalCoroutinesApi
    private fun tvShowEmptyViewModel(): TvShowViewModel {
        runBlockingTest {
            whenever(movieRepo.getPlaylist(2)).thenReturn(
                flow {
                    emit(expectedEmpty)
                }
            )
        }

        return TvShowViewModel(movieRepo)
    }

    @ExperimentalCoroutinesApi
    private fun tvShowFailureViewModel(): TvShowViewModel {
        runBlockingTest {
            whenever(movieRepo.getPlaylist(2)).thenReturn(
                flow {
                    emit(expectedException)
                }
            )
        }

        return TvShowViewModel(movieRepo)
    }
}