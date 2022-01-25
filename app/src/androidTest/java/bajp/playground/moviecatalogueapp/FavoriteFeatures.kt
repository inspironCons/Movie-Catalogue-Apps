package bajp.playground.moviecatalogueapp

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.matcher.ViewMatchers
import bajp.playground.moviecatalogueapp.utils.BaseUiTest
import bajp.playground.moviecatalogueapp.utils.General
import bajp.playground.moviecatalogueapp.utils.General.toGetYear
import bajp.playground.moviecatalogueapp.utils.GeneralTesting
import com.adevinta.android.barista.assertion.BaristaListAssertions.assertDisplayedAtPosition
import com.adevinta.android.barista.interaction.BaristaClickInteractions.clickOn
import com.adevinta.android.barista.interaction.BaristaListInteractions.clickListItem
import org.junit.Test

class FavoriteFeatures:BaseUiTest() {
    private val mockDataMovies = General.dummyDataMoviesType()
    private val mockTvShows = General.dummyDataTvShowsType()
    private val general = GeneralTesting()

    @Test
    fun displayFavoriteMovies(){
        clickListItem(R.id.rv_movies, 0)
        clickOn(R.id.fab_favorite)
        clickOn(R.id.btn_back)
        clickOn(R.id.btn_favorite)


        onView(ViewMatchers.withId(R.id.tl_favorite)).perform(general.selectTabAtPosition(0))
        val years = mockDataMovies.releaseDate?.toGetYear()
        assertDisplayedAtPosition(
            R.id.rv_movies,
            0,
            R.id.movie_title,
            "${mockDataMovies.title} ($years)"
        )
        assertDisplayedAtPosition(
            R.id.rv_movies,
            0,
            R.id.movie_score,
            "${mockDataMovies.userScore}%"
        )
        assertDisplayedAtPosition(
            R.id.rv_movies,
            0,
            R.id.movie_ori_language,
           "${mockDataMovies.originLanguage?.uppercase()}"
        )

    }

    @Test
    fun displayFavoriteTvShows(){
        onView(ViewMatchers.withId(R.id.tl_home)).perform(general.selectTabAtPosition(1))
        clickListItem(R.id.rv_tv_show, 2)
        clickOn(R.id.fab_favorite)
        clickOn(R.id.btn_back)
        clickOn(R.id.btn_favorite)
        onView(ViewMatchers.withId(R.id.tl_favorite)).perform(general.selectTabAtPosition(1))
        val years = mockTvShows.releaseDate?.toGetYear()
        assertDisplayedAtPosition(
            R.id.rv_tv_show,
            0,
            R.id.movie_title,
            "${mockTvShows.title} ($years)"
        )
        assertDisplayedAtPosition(
            R.id.rv_tv_show,
            0,
            R.id.movie_score,
            "${mockTvShows.userScore}%"
        )
        assertDisplayedAtPosition(
            R.id.rv_tv_show,
            0,
            R.id.movie_ori_language,
            "${mockTvShows.originLanguage?.uppercase()}"
        )

    }
}