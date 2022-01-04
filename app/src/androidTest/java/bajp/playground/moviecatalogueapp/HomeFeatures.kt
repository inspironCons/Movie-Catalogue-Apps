package bajp.playground.moviecatalogueapp

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import bajp.playground.moviecatalogueapp.utils.BaseUiTest
import bajp.playground.moviecatalogueapp.utils.DummyData
import bajp.playground.moviecatalogueapp.utils.General.toGetYear
import bajp.playground.moviecatalogueapp.utils.GeneralTesting
import com.adevinta.android.barista.assertion.BaristaListAssertions.assertDisplayedAtPosition
import com.adevinta.android.barista.assertion.BaristaRecyclerViewAssertions.assertRecyclerViewItemCount
import com.adevinta.android.barista.assertion.BaristaVisibilityAssertions.assertDisplayed
import com.adevinta.android.barista.interaction.BaristaClickInteractions.clickBack
import com.adevinta.android.barista.interaction.BaristaListInteractions.clickListItem
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class HomeFeatures:BaseUiTest() {

    private val mockDataMovies = DummyData.generateMovies(1)
    private val mockDataTvShows = DummyData.generateMovies(2)

    private val testingItemsNum = 0
    private val general = GeneralTesting()

    @Test
    fun displayMoviePlaylist(){
        onView(withId(R.id.tl_home)).perform(general.selectTabAtPosition(0))
        assertRecyclerViewItemCount(R.id.rv_movies,10)
        val years = mockDataMovies[testingItemsNum].releaseDate.toGetYear()
        assertDisplayedAtPosition(
            R.id.rv_movies,testingItemsNum,
            R.id.movie_title,
            "${mockDataMovies[testingItemsNum].title} ($years)")

        assertDisplayedAtPosition(R.id.rv_movies,testingItemsNum,R.id.movie_score,"${mockDataMovies[testingItemsNum].userScore}%")
        assertDisplayedAtPosition(R.id.rv_movies,testingItemsNum,R.id.movie_rating, mockDataMovies[testingItemsNum].ratingMovie)
        assertDisplayedAtPosition(R.id.rv_movies,testingItemsNum,R.id.movie_category, mockDataMovies[testingItemsNum].category)


    }

    @Test
    fun displayTvShowsPlaylist(){
        onView(withId(R.id.tl_home)).perform(general.selectTabAtPosition(1))
        assertRecyclerViewItemCount(R.id.rv_tv_show,10)
        val years = mockDataTvShows[testingItemsNum].releaseDate.toGetYear()
        assertDisplayedAtPosition(
            R.id.rv_tv_show,
            testingItemsNum,
            R.id.movie_title,
            "${mockDataTvShows[testingItemsNum].title} ($years)")

        assertDisplayedAtPosition(R.id.rv_tv_show,testingItemsNum,R.id.movie_score,"${mockDataTvShows[testingItemsNum].userScore}%")
        assertDisplayedAtPosition(R.id.rv_tv_show,testingItemsNum,R.id.movie_rating, mockDataTvShows[testingItemsNum].ratingMovie)
        assertDisplayedAtPosition(R.id.rv_tv_show,testingItemsNum,R.id.movie_category, mockDataTvShows[testingItemsNum].category)
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