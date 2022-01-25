package bajp.playground.moviecatalogueapp

import android.content.Context
import androidx.room.Room
import bajp.playground.moviecatalogueapp.common.ConstanNameHelper
import bajp.playground.moviecatalogueapp.common.ConstanNameHelper.DB_NAME
import bajp.playground.moviecatalogueapp.remote.local.database.MovieDatabase
import bajp.playground.moviecatalogueapp.remote.local.database.dao.FavoriteDao
import bajp.playground.moviecatalogueapp.remote.network.detail.DetailMoviesApi
import bajp.playground.moviecatalogueapp.remote.network.trending.TrendingApi
import com.facebook.flipper.plugins.network.FlipperOkhttpInterceptor
import com.facebook.flipper.plugins.network.NetworkFlipperPlugin
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object ApplicationModule {

    private val networkFlipperPlugin = NetworkFlipperPlugin()

    @Singleton
    @Provides
    fun networkFlipperPlugin():NetworkFlipperPlugin = networkFlipperPlugin

    private val client = OkHttpClient.Builder()
        .addNetworkInterceptor(FlipperOkhttpInterceptor(networkFlipperPlugin))
        .build()

    @Provides
    fun retrofit():Retrofit = Retrofit.Builder()
        .baseUrl(ConstanNameHelper.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    @Provides
    fun movieApi(retrofit: Retrofit):TrendingApi = retrofit.create(TrendingApi::class.java)

    @Provides
    fun detailMoviesApi(retrofit: Retrofit):DetailMoviesApi = retrofit.create(DetailMoviesApi::class.java)

    @Singleton
    @Provides
    fun dbInstance(@ApplicationContext app:Context):MovieDatabase = Room
        .databaseBuilder(app,MovieDatabase::class.java,DB_NAME)
        .build()

    @Provides
    fun favoriteDao(db:MovieDatabase):FavoriteDao = db.favoriteDao()
}