package bajp.playground.moviecatalogueapp

import android.view.View
import android.widget.ProgressBar
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import bajp.playground.moviecatalogueapp.common.ConstanNameHelper
import bajp.playground.moviecatalogueapp.data.TrendingEntity
import bajp.playground.moviecatalogueapp.utils.BaseUiTest
import bajp.playground.moviecatalogueapp.utils.General.toGetYear
import bajp.playground.moviecatalogueapp.utils.GeneralTesting
import com.adevinta.android.barista.assertion.BaristaAssertions.assertAny
import com.adevinta.android.barista.assertion.BaristaListAssertions.assertDisplayedAtPosition
import com.adevinta.android.barista.assertion.BaristaRecyclerViewAssertions.assertRecyclerViewItemCount
import com.adevinta.android.barista.assertion.BaristaVisibilityAssertions.assertDisplayed
import com.adevinta.android.barista.assertion.BaristaVisibilityAssertions.assertNotDisplayed
import com.adevinta.android.barista.interaction.BaristaClickInteractions.clickBack
import com.adevinta.android.barista.interaction.BaristaListInteractions.clickListItem
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class HomeFeatures:BaseUiTest() {

    private val mockDataMovies = TrendingEntity(
        movieId = 634649,
        title = "Spider-Man: No Way Home",
        poster = ConstanNameHelper.BASE_URL_IMAGE+"/1g0dhYtq4irTY1GPXvft6k4YLjm.jpg",
        releaseDate = "2021-12-15",
        voteAverage = (8.4 * 10.0).toInt(),
        originLanguage = "en"
    )

    private val mockDataTvShows = TrendingEntity(
        movieId = 115036,
        title = "The Book of Boba Fett",
        poster = ConstanNameHelper.BASE_URL_IMAGE+"/gNbdjDi1HamTCrfvM9JeA94bNi2.jpg",
        releaseDate = "2021-12-29",
        voteAverage = (8.2 * 10.0).toInt(),
        originLanguage = "en"
    )

    private val testingItemsNum = 0
    private val general = GeneralTesting()

    @Test
    fun showLoaderWhileFetchingTheListMovie() {
        IdlingRegistry.getInstance().unregister(ApplicationModule.idlingResource)
        assertAny<ProgressBar>(withId(R.id.load_content_movies),"Jika gagal coba test pada fungsi showLoaderWhileFetchingTheListMovie"){
            it.visibility == View.VISIBLE
        }
    }

    @Test
    fun showLoaderWhileFetchingTheListTvShows() {
        IdlingRegistry.getInstance().unregister(ApplicationModule.idlingResource)
        onView(withId(R.id.tl_home)).perform(general.selectTabAtPosition(1))
        assertAny<ProgressBar>(withId(R.id.load_content_tv_show),"Jika gagal coba test pada fungsi showLoaderWhileFetchingTheListTvShows"){
            it.visibility == View.VISIBLE
        }
    }

    @Test
    fun hideLoaderWhileFetchingTheMovieListDone() {
        assertNotDisplayed(R.id.load_content_movies)
    }


    @Test
    fun hideLoaderWhileFetchingTheTvShowsListDone() {
        onView(withId(R.id.tl_home)).perform(general.selectTabAtPosition(1))
        assertNotDisplayed(R.id.load_content_tv_show)
    }

    @Test
    fun displayMoviePlaylist(){
        onView(withId(R.id.tl_home)).perform(general.selectTabAtPosition(0))
        assertRecyclerViewItemCount(R.id.rv_movies,20)
        val years = mockDataMovies.releaseDate?.toGetYear()
        assertDisplayedAtPosition(
            R.id.rv_movies,testingItemsNum,
            R.id.movie_title,
            "${mockDataMovies.title} ($years)")

        assertDisplayedAtPosition(R.id.rv_movies,testingItemsNum,R.id.movie_score,"${mockDataMovies.voteAverage}%")
        assertDisplayedAtPosition(R.id.rv_movies,testingItemsNum,R.id.movie_ori_language,mockDataMovies.originLanguage?.uppercase()?:"")

    }

    @Test
    fun displayTvShowsPlaylist(){
        onView(withId(R.id.tl_home)).perform(general.selectTabAtPosition(1))
        assertRecyclerViewItemCount(R.id.rv_tv_show,20)
        val years = mockDataTvShows.releaseDate?.toGetYear()
        assertDisplayedAtPosition(
            R.id.rv_tv_show,
            testingItemsNum,
            R.id.movie_title,
            "${mockDataTvShows.title} ($years)")

        assertDisplayedAtPosition(R.id.rv_tv_show,testingItemsNum,R.id.movie_score,"${mockDataTvShows.voteAverage}%")
        assertDisplayedAtPosition(R.id.rv_tv_show,testingItemsNum,R.id.movie_ori_language,mockDataTvShows.originLanguage?.uppercase()?:"")
    }

    @Test
    fun navigateToDetailMovies(){
        clickListItem(R.id.rv_movies,testingItemsNum)
        assertDisplayed(R.id.detail_activity)
        clickBack()
        onView(withId(R.id.tl_home)).perform(general.selectTabAtPosition(1))
        clickListItem(R.id.rv_tv_show,testingItemsNum)
        assertDisplayed(R.id.detail_activity)
    }
}