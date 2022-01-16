package bajp.playground.moviecatalogueapp.remote.network.trending

import bajp.playground.moviecatalogueapp.common.ConstanNameHelper.BASE_URL_IMAGE
import bajp.playground.moviecatalogueapp.data.TrendingEntity
import javax.inject.Inject

class TrendingMovieMapper @Inject constructor():Function1<List<ResultsMovieResponse>?,List<TrendingEntity>> {
    override fun invoke(movieRaw: List<ResultsMovieResponse>?): List<TrendingEntity> {
            return movieRaw?.map { raw ->
                val score = raw.voteAverage?.times(10)
                TrendingEntity(
                    movieId = raw.id,
                    title = raw.title,
                    poster = BASE_URL_IMAGE +raw.posterPath,
                    releaseDate = raw.releaseDate,
                    voteAverage = score?.toInt(),
                    originLanguage = raw.originalLanguage
                )
            } ?: arrayListOf()
    }
}