package bajp.playground.moviecatalogueapp.utils

import android.annotation.SuppressLint
import android.view.View
import android.widget.ProgressBar
import bajp.playground.moviecatalogueapp.common.ConstanNameHelper
import bajp.playground.moviecatalogueapp.data.CompaniesEntity
import bajp.playground.moviecatalogueapp.data.DetailMovieEntity
import bajp.playground.moviecatalogueapp.data.GenresEntity
import java.text.SimpleDateFormat
import java.util.*

object General {
    @SuppressLint("SimpleDateFormat")
    fun String.toGetYear():String{
        val date = SimpleDateFormat("yyyy-MM-dd", Locale("IND","ID")).parse(this)
        return SimpleDateFormat("yyyy").format(date as Date)
    }

    @SuppressLint("SimpleDateFormat")
    fun String.toDateFormatRelease():String{
        val date = SimpleDateFormat("yyyy-MM-dd", Locale("IND","ID")).parse(this)
        return SimpleDateFormat("dd MMM  yyyy").format(date as Date)
    }

    fun isShowComponentProgress(view:ProgressBar?,show:Boolean){
        if(show){
            view?.visibility = View.VISIBLE
        }else{
            view?.visibility = View.GONE
        }
    }

    fun dummyDataMoviesType():DetailMovieEntity{
        return DetailMovieEntity(
            movieId = 634649,
            title = "Spider-Man: No Way Home",
            tagline = "The Multiverse unleashed.",
            poster = ConstanNameHelper.BASE_URL_IMAGE +"/1g0dhYtq4irTY1GPXvft6k4YLjm.jpg",
            overview = "Peter Parker is unmasked and no longer able to separate his normal life from the high-stakes of being a super-hero. When he asks for help from Doctor Strange the stakes become even more dangerous, forcing him to discover what it truly means to be Spider-Man.",
            userScore = 85,
            releaseDate="2021-12-15",
            category = listOf(
                GenresEntity(28,"Action"),
                GenresEntity(12,"Adventure"),
                GenresEntity(878,"Science Fiction")
            ),
            urlWatch = "https://www.spidermannowayhome.movie",
            productionCountry = "US",
            companies = listOf(
                CompaniesEntity(ConstanNameHelper.BASE_URL_IMAGE+"/hUzeosd33nzE5MCNsZxCGEKTXaQ.png", "Marvel Studios"),
                CompaniesEntity(ConstanNameHelper.BASE_URL_IMAGE+"/nw4kyc29QRpNtFbdsBHkRSFavvt.png", "Pascal Pictures"),
                CompaniesEntity(ConstanNameHelper.BASE_URL_IMAGE+"/71BqEFAF4V3qjjMPCpLuyJFB9A.png", "Columbia Pictures"),
            ),
            type = ConstanNameHelper.MOVIES_TYPE,
            originLanguage = "EN"
        )
    }

    fun dummyDataTvShowsType():DetailMovieEntity{
        return DetailMovieEntity(
            movieId = 115036,
            title = "The Book of Boba Fett",
            tagline = "Every galaxy has an underworld.",
            poster = ConstanNameHelper.BASE_URL_IMAGE +"/gNbdjDi1HamTCrfvM9JeA94bNi2.jpg",
            overview = "Legendary bounty hunter Boba Fett and mercenary Fennec Shand must navigate the galaxy’s underworld when they return to the sands of Tatooine to stake their claim on the territory once ruled by Jabba the Hutt and his crime syndicate.",
            userScore = 81,
            releaseDate="2021-12-29",
            category = listOf(
                GenresEntity(10759,"Action & Adventure"),
                GenresEntity(10765,"Sci-Fi & Fantasy")
            ),
            urlWatch = "https://www.disneyplus.com/series/the-book-of-boba-fett/57TL7zLNu2wf",
            productionCountry = "US",
            companies = listOf(
                CompaniesEntity(ConstanNameHelper.BASE_URL_IMAGE+"/o86DbpburjxrqAzEDhXZcyE8pDb.png", "Lucasfilm"),
                CompaniesEntity(ConstanNameHelper.BASE_URL_IMAGE+"/cfyTfcjSd9njenirn3d07xqwrZQ.png", "Golem Creations"),
                CompaniesEntity(ConstanNameHelper.BASE_URL_IMAGE+"/rRGi5UkwvdOPSfr5Xf42RZUsYgd.png", "Walt Disney Television"),
            ),
            type = ConstanNameHelper.TV_TYPE,
            originLanguage = "EN"
        )
    }
}