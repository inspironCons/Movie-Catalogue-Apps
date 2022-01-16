package bajp.playground.moviecatalogueapp.remote.network.trending

import bajp.playground.moviecatalogueapp.common.ConstanNameHelper.BASE_URL_IMAGE
import bajp.playground.moviecatalogueapp.data.TrendingEntity
import javax.inject.Inject

class TrendingTVMapper @Inject constructor():Function1<List<ResultsTvResponse>?,List<TrendingEntity>> {
    override fun invoke(movieRaw: List<ResultsTvResponse>?): List<TrendingEntity> {
            return movieRaw?.map { raw->
                val score = raw.voteAverage?.times(10)
                TrendingEntity(
                    movieId = raw.id,
                    title = raw.name,
                    poster = BASE_URL_IMAGE +raw.posterPath,
                    releaseDate = raw.firstAirDate,
                    voteAverage = score?.toInt(),
                    originLanguage = raw.originalLanguage
                )
            } ?: arrayListOf()
    }
}