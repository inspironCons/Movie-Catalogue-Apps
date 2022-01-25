package bajp.playground.moviewcatalogueapp.favorite

import androidx.paging.AsyncPagingDataDiffer
import androidx.paging.PagingSource
import androidx.recyclerview.widget.ListUpdateCallback
import bajp.playground.moviecatalogueapp.common.ConstanNameHelper.MOVIES_TYPE
import bajp.playground.moviecatalogueapp.data.DetailMovieEntity
import bajp.playground.moviecatalogueapp.repository.FavoriteRepository
import bajp.playground.moviecatalogueapp.ui.favorite.FavoriteAdapter
import bajp.playground.moviecatalogueapp.ui.favorite.movies.MoviesFavoriteViewModel
import bajp.playground.moviewcatalogueapp.utils.BaseUnitTest
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

/**
 * <p>
 * ViewModels Movie Favorite dan Tv Favorite menggunakan fungsi yang serupa jadi digabung saja.
 */
@ExperimentalCoroutinesApi
class FavoriteViewModelsShould:BaseUnitTest() {
    private val favoriteRepo: FavoriteRepository = mock()
    private val listMovie = mock<List<DetailMovieEntity>>()
    private val pageSourceMock =  mock<PagingSource<Int,DetailMovieEntity>>()

    val noopListUpdateCallback = object : ListUpdateCallback {
        override fun onInserted(position: Int, count: Int) {}
        override fun onRemoved(position: Int, count: Int) {}
        override fun onMoved(fromPosition: Int, toPosition: Int) {}
        override fun onChanged(position: Int, count: Int, payload: Any?) {}
    }
    private val tesDispatcher = TestCoroutineDispatcher()
    @Before
    fun setup(){
        Dispatchers.setMain(tesDispatcher)
    }

    @After
    fun tearDown(){
        Dispatchers.resetMain()
    }

    private fun viewModelSuccessfulCase():MoviesFavoriteViewModel{
        whenever(favoriteRepo.getFavoriteMovieByType(MOVIES_TYPE)).thenReturn(pageSourceMock)
        return MoviesFavoriteViewModel(favoriteRepo)
    }

    @Test
    fun getListMovie() = runBlockingTest {
        val viewModel = viewModelSuccessfulCase()

        val differ = AsyncPagingDataDiffer(
            diffCallback = FavoriteAdapter.diffCallback,
            mainDispatcher = tesDispatcher,
            workerDispatcher = tesDispatcher,
            updateCallback = noopListUpdateCallback
        )

        val job = launch {
            viewModel.getListMovie.collectLatest {
                differ.submitData(it)
            }
        }

        advanceUntilIdle()
        verify(favoriteRepo, times(1)).getFavoriteMovieByType(MOVIES_TYPE)
        assertEquals(differ.snapshot(),listMovie)
        job.cancel()
    }
}