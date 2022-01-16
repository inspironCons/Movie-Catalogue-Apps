package bajp.playground.moviecatalogueapp

import bajp.playground.moviecatalogueapp.common.ConstanNameHelper
import bajp.playground.moviecatalogueapp.remote.network.detail.DetailMoviesApi
import bajp.playground.moviecatalogueapp.remote.network.trending.TrendingApi
import com.facebook.flipper.plugins.network.FlipperOkhttpInterceptor
import com.facebook.flipper.plugins.network.NetworkFlipperPlugin
import com.jakewharton.espresso.OkHttp3IdlingResource
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
    fun networkFlipperPlugin():NetworkFlipperPlugin = networkFlipperPlugin

    private val client = OkHttpClient.Builder()
        .addNetworkInterceptor(FlipperOkhttpInterceptor(networkFlipperPlugin))
        .build()

    val idlingResource = OkHttp3IdlingResource.create("Global", client)
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
}