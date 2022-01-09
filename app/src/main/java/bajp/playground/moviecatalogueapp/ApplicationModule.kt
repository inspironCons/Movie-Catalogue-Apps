package bajp.playground.moviecatalogueapp

import bajp.playground.moviecatalogueapp.common.ConstanNameHelper
import bajp.playground.moviecatalogueapp.remote.network.movie.MovieApi
import bajp.playground.moviecatalogueapp.utils.DummyData
import com.facebook.flipper.plugins.network.FlipperOkhttpInterceptor
import com.facebook.flipper.plugins.network.NetworkFlipperPlugin
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
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
    fun dummyData():DummyData = DummyData

    @Singleton
    @Provides
    fun networkFlipperPlugin():NetworkFlipperPlugin = networkFlipperPlugin

    private val client = OkHttpClient.Builder()
        .addNetworkInterceptor(FlipperOkhttpInterceptor(networkFlipperPlugin))
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(ConstanNameHelper.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    @Singleton
    @Provides
    fun movieApi(): MovieApi = retrofit.create(MovieApi::class.java)
}