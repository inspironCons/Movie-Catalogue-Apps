package bajp.playground.moviecatalogueapp.remote.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import bajp.playground.moviecatalogueapp.common.ConstanNameHelper.DB_VERSION
import bajp.playground.moviecatalogueapp.data.DetailMovieEntity
import bajp.playground.moviecatalogueapp.remote.local.database.converter.Converters
import bajp.playground.moviecatalogueapp.remote.local.database.dao.FavoriteDao

@Database(
    entities = [
        DetailMovieEntity::class
    ]
, version = DB_VERSION)
@TypeConverters(Converters::class)
abstract class MovieDatabase:RoomDatabase() {
    abstract fun favoriteDao():FavoriteDao
}