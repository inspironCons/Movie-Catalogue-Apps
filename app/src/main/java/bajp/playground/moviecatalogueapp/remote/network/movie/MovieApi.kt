package bajp.playground.moviecatalogueapp.remote.network.movie

import retrofit2.http.GET

interface MovieApi {
    @GET("trending/movie/week")
    suspend fun getTrendingMovieOnThisWeek(

    ):TrendingMovieResponse
}