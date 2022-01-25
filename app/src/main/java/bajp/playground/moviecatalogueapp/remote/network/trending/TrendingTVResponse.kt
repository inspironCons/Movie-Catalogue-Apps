package bajp.playground.moviecatalogueapp.remote.network.trending

import com.google.gson.annotations.SerializedName

data class TrendingTvResponse(
    @SerializedName("results"       ) var results      : ArrayList<ResultsTvResponse> = arrayListOf(),
)

data class ResultsTvResponse (
    @SerializedName("id"                ) var id               : Int?              = null,
    @SerializedName("name"              ) var name             : String?           = null,
    @SerializedName("original_name"     ) var originalName     : String?           = null,
    @SerializedName("poster_path"       ) var posterPath       : String?           = null,
    @SerializedName("vote_average"      ) var voteAverage      : Double?           = null,
    @SerializedName("overview"          ) var overview         : String?           = null,
    @SerializedName("first_air_date"    ) var firstAirDate     : String?           = null,
    @SerializedName("original_language" ) var originalLanguage : String?           = null,
)