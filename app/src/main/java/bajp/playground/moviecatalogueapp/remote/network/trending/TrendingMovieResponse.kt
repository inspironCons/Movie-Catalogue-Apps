package bajp.playground.moviecatalogueapp.remote.network.trending

import com.google.gson.annotations.SerializedName

data class TrendingMovieResponse(
    @SerializedName("results"       ) var results      : List<ResultsMovieResponse>,
)

data class ResultsMovieResponse (

    @SerializedName("id"                ) var id               : Int?           = null,
    @SerializedName("original_language" ) var originalLanguage : String?        = null,
    @SerializedName("overview"          ) var overview         : String?        = null,
    @SerializedName("poster_path"       ) var posterPath       : String?        = null,
    @SerializedName("release_date"      ) var releaseDate      : String?        = null,
    @SerializedName("title"             ) var title            : String?        = null,
    @SerializedName("vote_average"      ) var voteAverage      : Double?        = null,

)