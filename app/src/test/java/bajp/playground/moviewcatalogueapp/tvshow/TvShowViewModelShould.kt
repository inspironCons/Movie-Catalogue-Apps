package bajp.playground.moviewcatalogueapp.tvshow

import bajp.playground.moviecatalogueapp.data.TrendingEntity
import bajp.playground.moviecatalogueapp.repository.MovieRepository
import bajp.playground.moviecatalogueapp.ui.home.tvshow.TvShowViewModel
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

@ExperimentalCoroutinesApi
class TvShowViewModelShould: BaseUnitTest() {
    private val movieRepo: MovieRepository = mock()
    private val mockTvShowList = mock<List<TrendingEntity>>()
    private val expectedSuccess = Result.success(mockTvShowList)
    private val expectedEmpty = Result.success(Collections.emptyList<TrendingEntity>())
    private val expectedException = Result.failure<List<TrendingEntity>>(RuntimeException("Something Went Wrong"))


    @Test
    fun showLoaderWhenLoadMovieList() = runBlockingTest{
        val vieModel = moviesSuccessViewModel()
        vieModel.loader.captureValues {
            vieModel.getTvShowList.getValueForTest()
            Assert.assertEquals(true,values[0])
        }
    }

    @Test
    fun hideLoaderWhenLoadMovieListIsDone() = runBlockingTest{
        val vieModel = moviesSuccessViewModel()
        vieModel.loader.captureValues {
            vieModel.getTvShowList.getValueForTest()
            Assert.assertEquals(false,values.last())
        }
    }

    @Test
    fun getTvShowListFromRepositoryThenSuccess() = runBlockingTest{
        val viewModel = moviesSuccessViewModel()
        val data = viewModel.getTvShowList.getValueForTest()
        verify(movieRepo, times(1)).getTvList()
        Assert.assertEquals(expectedSuccess, data)
    }

    @Test
    fun getTvShowListFromRepositoryThenEmpty() = runBlockingTest{
        val viewModel = tvShowEmptyViewModel()
        val data = viewModel.getTvShowList.getValueForTest()
        verify(movieRepo, times(1)).getTvList()
        Assert.assertEquals(expectedEmpty, data)
    }

    @Test
    fun getTvShowListFromRepositoryThenException() = runBlockingTest{
        val viewModel = tvShowFailureViewModel()
        val data = viewModel.getTvShowList.getValueForTest()
        verify(movieRepo, times(1)).getTvList()
        Assert.assertEquals(expectedException, data)
    }

    private fun moviesSuccessViewModel(): TvShowViewModel {
        runBlockingTest {
            whenever(movieRepo.getTvList()).thenReturn(
                flow {
                    emit(expectedSuccess)
                }
            )
        }

        return TvShowViewModel(movieRepo)
    }


    private fun tvShowEmptyViewModel(): TvShowViewModel {
        runBlockingTest {
            whenever(movieRepo.getTvList()).thenReturn(
                flow {
                    emit(expectedEmpty)
                }
            )
        }

        return TvShowViewModel(movieRepo)
    }

    private fun tvShowFailureViewModel(): TvShowViewModel {
        runBlockingTest {
            whenever(movieRepo.getTvList()).thenReturn(
                flow {
                    emit(expectedException)
                }
            )
        }

        return TvShowViewModel(movieRepo)
    }
}