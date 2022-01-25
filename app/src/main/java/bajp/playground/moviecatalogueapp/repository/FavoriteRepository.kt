package bajp.playground.moviecatalogueapp.repository

import androidx.paging.PagingSource
import bajp.playground.moviecatalogueapp.data.DetailMovieEntity
import bajp.playground.moviecatalogueapp.remote.local.database.dao.FavoriteDao
import bajp.playground.moviecatalogueapp.utils.EspressoIdling
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class FavoriteRepository @Inject constructor(
    private val favoriteDao: FavoriteDao
) {

    fun getFavoriteMovieByType(type:String):PagingSource<Int,DetailMovieEntity> = favoriteDao.getMovies(type)


    fun isMoviesInTheFavoriteSegment(id:Int?):Flow<Result<Boolean>>{
        return flow {
            EspressoIdling.increment()
            val count = favoriteDao.countMoviesById(id) > 0
            if(!EspressoIdling.getEspressoIdlingResource.isIdleNow){
                EspressoIdling.decrement()
            }
            emit(Result.success(count))
        }.catch {
            emit(Result.failure(RuntimeException(it.localizedMessage?:"")))
        }
    }

    suspend fun insertMoviesFavorite(movie:DetailMovieEntity):Flow<Result<String>>{
        return flow {
            EspressoIdling.increment()
            emit(Result.success("Loading..."))
            favoriteDao.insert(movie)
            emit(Result.success("Data Berhasil Ditambahkan"))
            if(!EspressoIdling.getEspressoIdlingResource.isIdleNow){
                EspressoIdling.decrement()
            }
        }.catch {
            if(!EspressoIdling.getEspressoIdlingResource.isIdleNow){
                EspressoIdling.decrement()
            }
            emit(Result.failure(RuntimeException("Gagal ditambah")))

        }
    }

    suspend fun deleteMovieFavorite(movie:DetailMovieEntity):Flow<Result<String>>{
        return flow {
            EspressoIdling.increment()

            emit(Result.success("Loading..."))
            favoriteDao.delete(movie)
            if(!EspressoIdling.getEspressoIdlingResource.isIdleNow){
                EspressoIdling.decrement()
            }
            emit(Result.success("Data Berhasil Dihapus"))
        }.catch {
            if(!EspressoIdling.getEspressoIdlingResource.isIdleNow){
                EspressoIdling.decrement()
            }
            emit(Result.failure(RuntimeException("Gagal DiDihapus")))

        }
    }
}