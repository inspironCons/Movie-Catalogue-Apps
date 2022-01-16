package bajp.playground.moviecatalogueapp.remote.network.trending

import retrofit2.http.GET
import retrofit2.http.Query

interface TrendingApi {
    @GET("trending/movie/week")
    suspend fun getTrendingMovieOnThisWeek(
        @Query("api_key") apiKey:String,
        @Query("language")language:String,
        @Query("region")region:String
    ):TrendingMovieResponse

    @GET("trending/tv/week")
    suspend fun getTrendingTvShowsOnThisWeek(
        @Query("api_key") apiKey:String,
        @Query("language")language:String,
        @Query("region")region:String
    ):TrendingTvResponse
}