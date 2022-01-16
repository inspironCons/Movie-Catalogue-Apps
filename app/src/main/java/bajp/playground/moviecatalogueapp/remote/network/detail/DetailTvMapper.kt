package bajp.playground.moviecatalogueapp.remote.network.detail

import bajp.playground.moviecatalogueapp.common.ConstanNameHelper.BASE_URL_IMAGE
import bajp.playground.moviecatalogueapp.data.DetailMovieEntity
import javax.inject.Inject

class DetailTvMapper @Inject constructor(
    private val categoryMapper:CategoryMappers,
    private val companiesMapper:CompaniesMapper
):Function1<DetailTvShowsResponse?,DetailMovieEntity> {
    override fun invoke(details: DetailTvShowsResponse?): DetailMovieEntity {
        val score = details?.voteAverage?.times(10)
        return DetailMovieEntity(
            movieId = details?.id,
            title = details?.name,
            tagline = details?.tagline,
            poster = BASE_URL_IMAGE+details?.posterPath,
            overview = details?.overview,
            userScore = score?.toInt(),
            releaseDate=details?.firstAirDate,
            category = categoryMapper(details?.genres),
            urlWatch = details?.homepage,
            productionCountry = details?.productionCountries?.get(0)?.iso31661,
            companies = companiesMapper(details?.productionCompanies)
        )
    }
}