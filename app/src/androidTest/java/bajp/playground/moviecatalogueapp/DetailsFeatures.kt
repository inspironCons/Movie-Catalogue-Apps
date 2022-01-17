package bajp.playground.moviecatalogueapp

import android.app.Instrumentation
import android.content.Intent
import androidx.test.espresso.Espresso
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.Intents.intending
import androidx.test.espresso.intent.matcher.IntentMatchers.hasAction
import androidx.test.espresso.intent.matcher.IntentMatchers.hasData
import androidx.test.espresso.matcher.ViewMatchers
import bajp.playground.moviecatalogueapp.common.ConstanNameHelper
import bajp.playground.moviecatalogueapp.data.CompaniesEntity
import bajp.playground.moviecatalogueapp.data.DetailMovieEntity
import bajp.playground.moviecatalogueapp.data.GenresEntity
import bajp.playground.moviecatalogueapp.utils.BaseUiTest
import bajp.playground.moviecatalogueapp.utils.General.toDateFormatRelease
import bajp.playground.moviecatalogueapp.utils.GeneralTesting
import com.adevinta.android.barista.assertion.BaristaImageViewAssertions.assertHasAnyDrawable
import com.adevinta.android.barista.assertion.BaristaRecyclerViewAssertions.assertRecyclerViewItemCount
import com.adevinta.android.barista.assertion.BaristaVisibilityAssertions.assertDisplayed
import com.adevinta.android.barista.interaction.BaristaClickInteractions.clickOn
import com.adevinta.android.barista.interaction.BaristaListInteractions.clickListItem
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.junit.Test


class DetailsFeatures:BaseUiTest() {
    private val numTestingPosition = 0
    private val mockDataMovies = DetailMovieEntity(
        movieId = 634649,
        title = "Spider-Man: No Way Home",
        tagline = "The Multiverse unleashed.",
        poster = ConstanNameHelper.BASE_URL_IMAGE +"/1g0dhYtq4irTY1GPXvft6k4YLjm.jpg",
        overview = "Peter Parker is unmasked and no longer able to separate his normal life from the high-stakes of being a super-hero. When he asks for help from Doctor Strange the stakes become even more dangerous, forcing him to discover what it truly means to be Spider-Man.",
        userScore = 84,
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
        )
    )

    private val general = GeneralTesting()


    @Test
    fun loadDetailsMovies(){
        clickListItem(R.id.rv_movies, numTestingPosition)
        assertDisplayed(R.id.detail_activity)
        //display  poster
        assertHasAnyDrawable(R.id.movie_poster_detail)
        // display title
        assertDisplayed(R.id.movie_title_detail,mockDataMovies.title?:"")
        // display tagline
        assertDisplayed(R.id.movie_tagline,"\" ${mockDataMovies.tagline} \"")
        // display release date
        assertDisplayed(R.id.movie_release_date,mockDataMovies.releaseDate?.toDateFormatRelease()?:"")
        // display user score
        assertDisplayed(R.id.movie_user_score,"${mockDataMovies.userScore}%")
        // display production country
        assertDisplayed(R.id.movie_production_country,mockDataMovies.productionCountry?:"")
        // display category/ Genres
        assertDisplayed(R.id.movie_category,mockDataMovies.category?.joinToString(",")?:"")
        // display overview
        assertDisplayed(R.id.movie_overview,mockDataMovies.overview?:"")
        // display size rv companies
        assertRecyclerViewItemCount(R.id.rv_companies,mockDataMovies.companies?.size?:0)
    }

    @Test
    fun navigateToIntentWhileClickButtonWatch(){
        clickListItem(R.id.rv_movies, numTestingPosition)
        try {
            Intents.init()
            val expectedIntent: Matcher<Intent> =allOf(hasAction(Intent.ACTION_VIEW), hasData(mockDataMovies.urlWatch))
            intending(expectedIntent).respondWith(Instrumentation.ActivityResult(0, null))
            clickOn(R.id.btn_watch)
            intended(expectedIntent)
        }finally {
            Intents.release()
        }
    }

    @Test
    fun navigateBackButton(){
        clickListItem(R.id.rv_movies, numTestingPosition)
        clickOn(R.id.btn_menus)
        assertDisplayed(R.id.home_page_layout)
    }

    @Test
    fun checkLabelProductionOrNetwork(){
        clickListItem(R.id.rv_movies, numTestingPosition)
        assertDisplayed(R.id.tv_lable_companies,R.string.companies)
        clickOn(R.id.btn_menus)
        Espresso.onView(ViewMatchers.withId(R.id.tl_home)).perform(general.selectTabAtPosition(1))
        clickListItem(R.id.rv_tv_show, numTestingPosition)
        assertDisplayed(R.id.tv_lable_companies,R.string.network)

    }
}