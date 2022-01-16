package bajp.playground.moviecatalogueapp.remote.network.detail

import bajp.playground.moviecatalogueapp.common.ConstanNameHelper
import bajp.playground.moviecatalogueapp.data.CompaniesEntity
import javax.inject.Inject

class CompaniesMapper @Inject constructor():Function1<ArrayList<ProductionCompanies>?,List<CompaniesEntity>> {
    override fun invoke(companies: ArrayList<ProductionCompanies>?): List<CompaniesEntity> {
        return companies?.map {
            CompaniesEntity(
                logos = ConstanNameHelper.BASE_URL_IMAGE+it.logoPath,
                name = it.name
            )
        }?: arrayListOf()
    }
}