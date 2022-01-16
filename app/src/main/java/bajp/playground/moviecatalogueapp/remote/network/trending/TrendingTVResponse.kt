package bajp.playground.moviecatalogueapp.remote.network.trending

import com.google.gson.annotations.SerializedName

data class TrendingTvResponse(
    @SerializedName("page"          ) var page         : Int?               = null,
    @SerializedName("results"       ) var results      : ArrayList<ResultsTvResponse> = arrayListOf(),
    @SerializedName("total_pages"   ) var totalPages   : Int?               = null,
    @SerializedName("total_results" ) var totalResults : Int?               = null
)

data class ResultsTvResponse (
    @SerializedName("id"                ) var id               : Int?              = null,
    @SerializedName("backdrop_path"     ) var backdropPath     : String?           = null,
    @SerializedName("name"              ) var name             : String?           = null,
    @SerializedName("genre_ids"         ) var genreIds         : ArrayList<Int>    = arrayListOf(),
    @SerializedName("original_name"     ) var originalName     : String?           = null,
    @SerializedName("origin_country"    ) var originCountry    : ArrayList<String> = arrayListOf(),
    @SerializedName("poster_path"       ) var posterPath       : String?           = null,
    @SerializedName("vote_average"      ) var voteAverage      : Double?           = null,
    @SerializedName("vote_count"        ) var voteCount        : Int?              = null,
    @SerializedName("overview"          ) var overview         : String?           = null,
    @SerializedName("first_air_date"    ) var firstAirDate     : String?           = null,
    @SerializedName("original_language" ) var originalLanguage : String?           = null,
    @SerializedName("popularity"        ) var popularity       : Double?           = null,
    @SerializedName("media_type"        ) var mediaType        : String?           = null
)