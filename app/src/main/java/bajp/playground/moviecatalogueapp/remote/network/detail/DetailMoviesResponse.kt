package bajp.playground.moviecatalogueapp.remote.network.detail

import com.google.gson.annotations.SerializedName

data class DetailMoviesResponse(
    @SerializedName("genres"                ) var genres              : ArrayList<Genres>              = arrayListOf(),
    @SerializedName("homepage"              ) var homepage            : String?                        = null,
    @SerializedName("id"                    ) var id                  : Int?                           = null,
    @SerializedName("original_language"     ) var originalLanguage    : String?                        = null,
    @SerializedName("overview"              ) var overview            : String?                        = null,
    @SerializedName("poster_path"           ) var posterPath          : String?                        = null,
    @SerializedName("production_companies"  ) var productionCompanies : ArrayList<ProductionCompanies> = arrayListOf(),
    @SerializedName("production_countries"  ) var productionCountries : ArrayList<ProductionCountries> = arrayListOf(),
    @SerializedName("release_date"          ) var releaseDate         : String?                        = null,
    @SerializedName("tagline"               ) var tagline             : String?                        = null,
    @SerializedName("title"                 ) var title               : String?                        = null,
    @SerializedName("vote_average"          ) var voteAverage         : Double?                        = null,
)

data class Genres (

    @SerializedName("id"   ) var id   : Int?    = null,
    @SerializedName("name" ) var name : String? = null

)

data class ProductionCompanies (

    @SerializedName("id"             ) var id            : Int?    = null,
    @SerializedName("logo_path"      ) var logoPath      : String? = null,
    @SerializedName("name"           ) var name          : String? = null,
    @SerializedName("origin_country" ) var originCountry : String? = null

)

data class ProductionCountries (

    @SerializedName("iso_3166_1" ) var iso31661 : String? = null,
    @SerializedName("name"       ) var name     : String? = null

)


data class DetailTvShowsResponse(
    @SerializedName("first_air_date"       ) var firstAirDate        : String?                        = null,
    @SerializedName("genres"               ) var genres              : ArrayList<Genres>              = arrayListOf(),
    @SerializedName("homepage"             ) var homepage            : String?                        = null,
    @SerializedName("id"                   ) var id                  : Int?                           = null,
    @SerializedName("name"                 ) var name                : String?                        = null,
    @SerializedName("networks"             ) var networks            : ArrayList<Networks>            = arrayListOf(),
    @SerializedName("number_of_seasons"    ) var numberOfSeasons     : Int?                           = null,
    @SerializedName("original_language"    ) var originalLanguage    : String?                        = null,
    @SerializedName("original_name"        ) var originalName        : String?                        = null,
    @SerializedName("overview"             ) var overview            : String?                        = null,
    @SerializedName("poster_path"          ) var posterPath          : String?                        = null,
    @SerializedName("production_companies" ) var productionCompanies : ArrayList<ProductionCompanies> = arrayListOf(),
    @SerializedName("production_countries" ) var productionCountries : ArrayList<ProductionCountries> = arrayListOf(),
    @SerializedName("tagline"              ) var tagline             : String?                        = null,
    @SerializedName("vote_average"         ) var voteAverage         : Double?                        = null,
)


data class Networks (

    @SerializedName("name"           ) var name          : String? = null,
    @SerializedName("id"             ) var id            : Int?    = null,
    @SerializedName("logo_path"      ) var logoPath      : String? = null,
    @SerializedName("origin_country" ) var originCountry : String? = null

)


