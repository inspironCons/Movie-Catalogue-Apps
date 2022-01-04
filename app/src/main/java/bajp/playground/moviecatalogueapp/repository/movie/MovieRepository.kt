package bajp.playground.moviecatalogueapp.repository.movie

import bajp.playground.moviecatalogueapp.data.MovieEntity
import bajp.playground.moviecatalogueapp.utils.DummyData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MovieRepository(
    private val dummyData:DummyData
) {

    suspend fun getPlaylist(type:Int):Flow<Result<List<MovieEntity>>>{
        return flow {
            emit(Result.success(dummyData.generateMovies(type)))
        }
    }

    suspend fun getDetailPlaylist(id:String):Flow<Result<MovieEntity>>{
        return flow {
            val detail = dummyData.generateMovies()

            for(movie in detail){
                if(movie.movieId == id) emit(Result.success(movie))
            }
        }
    }
}