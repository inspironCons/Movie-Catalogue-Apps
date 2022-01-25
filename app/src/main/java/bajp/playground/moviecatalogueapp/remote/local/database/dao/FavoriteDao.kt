package bajp.playground.moviecatalogueapp.remote.local.database.dao

import androidx.paging.PagingSource
import androidx.room.*
import bajp.playground.moviecatalogueapp.data.DetailMovieEntity

@Dao
interface FavoriteDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    @JvmSuppressWildcards
    suspend fun insert(payload:DetailMovieEntity)

    @Query("select * from favorite_movie where type=:type")
    fun getMovies(type:String):PagingSource<Int,DetailMovieEntity>

    @Query("select count(*) from favorite_movie where id=:id")
    suspend fun countMoviesById(id:Int?):Int

    @Delete
    suspend fun delete(payload:DetailMovieEntity)

    @Query("select * from favorite_movie")
    fun observeAllData():List<DetailMovieEntity>
}