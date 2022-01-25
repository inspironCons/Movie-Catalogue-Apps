package bajp.playground.moviecatalogueapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorite_movie")
data class DetailMovieEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    var movieId:Int? = 0,
    @ColumnInfo(name = "title")
    var title:String? = "",
    @ColumnInfo(name = "tagline")
    var tagline:String? = "",
    @ColumnInfo(name = "poster")
    var poster:String? = "",
    @ColumnInfo(name = "overview")
    var overview:String? = "",
    @ColumnInfo(name = "user_score")
    var userScore:Int? = 0,
    @ColumnInfo(name = "release_date")
    var releaseDate:String? = "",
    @ColumnInfo(name = "category")
    var category:List<GenresEntity>? = arrayListOf(),
    @ColumnInfo(name = "url_watch")
    var urlWatch:String? = "",
    @ColumnInfo(name = "production_country")
    var productionCountry:String?="",
    @ColumnInfo(name = "origin_language")
    var originLanguage:String? = "",
    @ColumnInfo(name = "companies")
    var companies:List<CompaniesEntity>? = arrayListOf(),
    @ColumnInfo(name = "type")
    var type:String? = ""

)

