package bajp.playground.moviecatalogueapp.remote.network.detail

import bajp.playground.moviecatalogueapp.data.GenresEntity
import javax.inject.Inject

class CategoryMappers @Inject constructor():Function1<ArrayList<Genres>?,List<GenresEntity>> {
    override fun invoke(genres: ArrayList<Genres>?): List<GenresEntity> {
        return genres?.map {
            GenresEntity(
                id = it.id,
                name = it.name
            )
        }?: arrayListOf()
    }
}