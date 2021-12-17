package bajp.playground.moviecatalogueapp.data

data class MovieEntity(
    var movieId:String,
    var title:String,
    var poster:Int,
    var overview:String,
    var director:String,
    var userScore:Int,
    var releaseDate:String,
    var category:String,
    var ratingMovie:String,
    var urlWatch:String,
    var type:Int,
    var cast:List<CastEntity>
)