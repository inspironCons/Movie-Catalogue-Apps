package bajp.playground.moviecatalogueapp.data

data class DetailMovieEntity(
    var movieId:Int? = 0,
    var title:String? = "",
    var tagline:String? = "",
    var poster:String? = "",
    var overview:String? = "",
    var userScore:Int? = 0,
    var releaseDate:String? = "",
    var category:List<GenresEntity>? = arrayListOf(),
    var urlWatch:String? = "",
    var productionCountry:String?="",
    var companies:List<CompaniesEntity>? = arrayListOf()
)