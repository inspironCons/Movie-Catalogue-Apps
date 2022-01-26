package bajp.playground.moviewcatalogueapp.detailMovie

import bajp.playground.moviecatalogueapp.common.ConstanNameHelper
import bajp.playground.moviecatalogueapp.data.DetailMovieEntity
import bajp.playground.moviecatalogueapp.repository.DetailMovieRepository
import bajp.playground.moviecatalogueapp.repository.FavoriteRepository
import bajp.playground.moviecatalogueapp.ui.detail.DetailMovieViewModel
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

@ExperimentalCoroutinesApi
class DetailMovieViewModelShould:BaseUnitTest() {
    private val movieRepo: DetailMovieRepository = mock()
    private val favoriteRepo: FavoriteRepository = mock()
    private val mockEntity = mock<DetailMovieEntity>()
    private val entitySuccess = Result.success(mockEntity)
    private val expectedException = Result.failure<DetailMovieEntity>(RuntimeException("Something Went Wrong on detail activity"))

    private val msgLoading = Result.success("loading")
    private val msgInsertSuccess = Result.success("Data Berhasil Ditambahkan")
    private val msgInsertfailed = RuntimeException("Gagal ditambah")

    private val msgDeleteSuccess = Result.success("Data Berhasil Dihapus")
    private val msgDeletefailed = RuntimeException("Gagal DiDihapus")
    private val idMovieTesting = 634649

    @Test
    fun getDetailMovieFromRepositoryThenReturnSuccess() = runBlockingTest {
        val viewModel = detailMoviesSuccessViewModel()
        val detail = viewModel.detailMovie(idMovieTesting,ConstanNameHelper.MOVIES_TYPE,false).getValueForTest()
        verify(movieRepo, times(1)).getDetailMovies(idMovieTesting)
        assertEquals(entitySuccess,detail)
    }

    @Test
    fun getDetailMovieFromRepositoryThenReturnException() = runBlockingTest {
        val viewModel = detailMovieFailureViewModel()
        val detail = viewModel.detailMovie(idMovieTesting,ConstanNameHelper.MOVIES_TYPE,false).getValueForTest()
        verify(movieRepo, times(1)).getDetailMovies(idMovieTesting)
        assertEquals(expectedException,detail)
    }

    @Test
    fun getDetailMovieAfterSetValue() {
        val viewModel = detailMoviesSuccessViewModel()
        viewModel.setDetailMovie(mockEntity,ConstanNameHelper.MOVIES_TYPE)

        assertEquals(mockEntity,viewModel.movies)
    }

    @Test
    fun checkMovieWasInsertOnFavoriteTable() = runBlockingTest{
        whenever(favoriteRepo.isMoviesInTheFavoriteSegment(idMovieTesting)).thenReturn(
            flow {
                emit(Result.success(true))
            }
        )
        val viewModel = detailMoviesSuccessViewModel()
        viewModel.movies.movieId = idMovieTesting
        viewModel.checkFavorite()
        verify(favoriteRepo, times(1)).isMoviesInTheFavoriteSegment(idMovieTesting)
        assertEquals(true,viewModel.getFavorite().getValueForTest())
    }

    @Test
    fun checkMovieWasNotInsertOnFavoriteTable() = runBlockingTest{
        whenever(favoriteRepo.isMoviesInTheFavoriteSegment(idMovieTesting)).thenReturn(
            flow {
                emit(Result.success(false))
            }
        )
        val viewModel = detailMoviesSuccessViewModel()
        viewModel.movies.movieId = idMovieTesting
        viewModel.checkFavorite()
        verify(favoriteRepo, times(1)).isMoviesInTheFavoriteSegment(idMovieTesting)
        assertEquals(false,viewModel.getFavorite().getValueForTest())
    }


    @Test
    fun insertDetailMovieOnTableFavoriteWhenClickFabFavorite() = runBlockingTest {
        whenever(favoriteRepo.insertMoviesFavorite(mockEntity)).thenReturn(
            flow {
                emit(msgLoading)
                emit(msgInsertSuccess)
            }
        )
        val viewModel = detailMoviesSuccessViewModel()
        viewModel.setDetailMovie(mockEntity,ConstanNameHelper.MOVIES_TYPE)
        viewModel.isMovieFavorite.postValue(false)
        viewModel.saveToFavorite().captureValues {
            verify(favoriteRepo, times(1)).insertMoviesFavorite(mockEntity)
            assertEquals(msgLoading,values[0])
            assertEquals(msgInsertSuccess,values[1])

        }
    }

    @Test
    fun removeDetailMovieOnTableFavoriteWhenClickFabFavorite() = runBlockingTest {
        whenever(favoriteRepo.deleteMovieFavorite(mockEntity)).thenReturn(
            flow {
                emit(msgLoading)
                emit(msgDeleteSuccess)
            }
        )
        val viewModel = detailMoviesSuccessViewModel()
        viewModel.setDetailMovie(mockEntity,ConstanNameHelper.MOVIES_TYPE)
        viewModel.isMovieFavorite.postValue(true)
        viewModel.saveToFavorite().captureValues {
            verify(favoriteRepo, times(1)).deleteMovieFavorite(mockEntity)
            assertEquals(msgLoading,values[0])
            assertEquals(msgDeleteSuccess,values[1])
        }
    }

    @Test
    fun insertDetailMovieOnTableFavoriteWhenClickFabFavoriteThenReturnFailure() = runBlockingTest {
        whenever(favoriteRepo.insertMoviesFavorite(mockEntity)).thenReturn(
            flow {
                emit(Result.failure(msgInsertfailed))
            }
        )
        val viewModel = detailMoviesSuccessViewModel()
        viewModel.setDetailMovie(mockEntity,ConstanNameHelper.MOVIES_TYPE)
        viewModel.isMovieFavorite.postValue(false)
        viewModel.saveToFavorite().captureValues {
            verify(favoriteRepo, times(1)).insertMoviesFavorite(mockEntity)
            assertEquals(msgInsertfailed,values.first()?.exceptionOrNull())
        }
    }

    @Test
    fun removeDetailMovieOnTableFavoriteWhenClickFabFavoriteThenReturnFailure() = runBlockingTest {
        whenever(favoriteRepo.deleteMovieFavorite(mockEntity)).thenReturn(
            flow {
                emit(Result.failure(msgDeletefailed))
            }
        )
        val viewModel = detailMoviesSuccessViewModel()
        viewModel.setDetailMovie(mockEntity,ConstanNameHelper.MOVIES_TYPE)
        viewModel.isMovieFavorite.postValue(true)
        val delete = viewModel.saveToFavorite().getValueForTest()
        verify(favoriteRepo, times(1)).deleteMovieFavorite(mockEntity)
        assertEquals(msgDeletefailed,delete?.exceptionOrNull())

    }

    @Test
    fun getDetailMovieFromLocalSuccess() = runBlockingTest {
        val viewModel = detailMoviesSuccessViewModel()
        val data = viewModel.detailMovie(idMovieTesting,ConstanNameHelper.MOVIES_TYPE,true).getValueForTest()
        verify(movieRepo, times(1)).getDetailFromLocal(idMovieTesting)
        assertEquals(mockEntity,data?.getOrNull())
    }

    @Test
    fun getDetailMovieFromLocalThenFailure() = runBlockingTest {
        val viewModel = detailMovieFailureViewModel()
        val data = viewModel.detailMovie(idMovieTesting,ConstanNameHelper.MOVIES_TYPE,true).getValueForTest()
        verify(movieRepo, times(1)).getDetailFromLocal(idMovieTesting)
        assertEquals(expectedException.exceptionOrNull(),data?.exceptionOrNull())
    }

    private fun detailMoviesSuccessViewModel(): DetailMovieViewModel {
        runBlockingTest {
            whenever(movieRepo.getDetailMovies(idMovieTesting)).thenReturn(
                flow {
                    emit(entitySuccess)
                }
            )

            whenever(movieRepo.getDetailFromLocal(idMovieTesting)).thenReturn(
                flow {
                    emit(entitySuccess)
                }
            )
        }

        return DetailMovieViewModel(movieRepo,favoriteRepo)
    }

    private fun detailMovieFailureViewModel(): DetailMovieViewModel {
        runBlockingTest {
            whenever(movieRepo.getDetailMovies(idMovieTesting)).thenReturn(
                flow {
                    emit(expectedException)
                }
            )
            whenever(movieRepo.getDetailFromLocal(idMovieTesting)).thenReturn(
                flow {
                    emit(expectedException)
                }
            )
        }
        return DetailMovieViewModel(movieRepo,favoriteRepo)
    }

}