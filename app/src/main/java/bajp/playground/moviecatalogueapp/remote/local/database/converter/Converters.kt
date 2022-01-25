package bajp.playground.moviecatalogueapp.remote.local.database.converter

import androidx.room.TypeConverter
import bajp.playground.moviecatalogueapp.data.CompaniesEntity
import bajp.playground.moviecatalogueapp.data.GenresEntity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {
    @TypeConverter
    fun listToJsonGenres(list:List<GenresEntity>):String = Gson().toJson(list)

    @TypeConverter
    fun jsonToListGenres(value: String): List<GenresEntity> {
        val listType = object : TypeToken<List<GenresEntity?>?>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun listToJsonCompanies(list:List<CompaniesEntity>):String = Gson().toJson(list)

    @TypeConverter
    fun jsonToListCompanies(value: String): ArrayList<CompaniesEntity> {
        val listType = object : TypeToken<List<CompaniesEntity?>?>() {}.type
        return Gson().fromJson(value, listType)
    }
}