package bajp.playground.moviewcatalogueapp.detailMovie

import bajp.playground.moviecatalogueapp.data.MovieEntity
import bajp.playground.moviecatalogueapp.repository.movie.MovieRepository
import bajp.playground.moviecatalogueapp.ui.detail.DetailMovieViewModel
import bajp.playground.moviewcatalogueapp.utils.BaseUnitTest
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

class DetailMovieViewModelShould:BaseUnitTest() {
    private val movieRepo: MovieRepository = mock()
    private val mockEntity = mock<MovieEntity>()
    private val entitySuccess = Result.success(mockEntity)
    private val expectedException = Result.failure<MovieEntity>(RuntimeException("Something Went Wrong on detail activity"))

    private val idMovieTesting = "m1"

    @ExperimentalCoroutinesApi
    @Test
    fun getDetailMovieFromRepositoryThenReturnSuccess() = runBlockingTest {
        val viewModel = detailMoviesSuccessViewModel()
        val detail = viewModel.detailMovie(idMovieTesting).getValueForTest()
        verify(movieRepo, times(1)).getDetailPlaylist(idMovieTesting)
        assertEquals(entitySuccess,detail)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun getDetailMovieFromRepositoryThenReturnException() = runBlockingTest {
        val viewModel = detailMovieFailureViewModel()
        val detail = viewModel.detailMovie(idMovieTesting).getValueForTest()
        verify(movieRepo, times(1)).getDetailPlaylist(idMovieTesting)
        assertEquals(expectedException,detail)
    }

    @ExperimentalCoroutinesApi
    private fun detailMoviesSuccessViewModel(): DetailMovieViewModel {
        runBlockingTest {
            whenever(movieRepo.getDetailPlaylist(idMovieTesting)).thenReturn(
                flow {
                    emit(entitySuccess)
                }
            )
        }

        return DetailMovieViewModel(movieRepo)
    }

    @ExperimentalCoroutinesApi
    private fun detailMovieFailureViewModel(): DetailMovieViewModel {
        runBlockingTest {
            whenever(movieRepo.getDetailPlaylist(idMovieTesting)).thenReturn(
                flow {
                    emit(expectedException)
                }
            )
        }

        return DetailMovieViewModel(movieRepo)
    }
}