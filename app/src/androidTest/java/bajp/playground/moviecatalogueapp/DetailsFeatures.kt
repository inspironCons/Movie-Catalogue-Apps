package bajp.playground.moviecatalogueapp

import android.app.Instrumentation
import android.content.Intent
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.Intents.intending
import androidx.test.espresso.intent.matcher.IntentMatchers.hasAction
import androidx.test.espresso.intent.matcher.IntentMatchers.hasData
import bajp.playground.moviecatalogueapp.utils.BaseUiTest
import bajp.playground.moviecatalogueapp.utils.DummyData
import bajp.playground.moviecatalogueapp.utils.General.toDateFormatRelease
import com.adevinta.android.barista.assertion.BaristaImageViewAssertions.assertHasDrawable
import com.adevinta.android.barista.assertion.BaristaRecyclerViewAssertions.assertRecyclerViewItemCount
import com.adevinta.android.barista.assertion.BaristaVisibilityAssertions.assertDisplayed
import com.adevinta.android.barista.interaction.BaristaClickInteractions.clickOn
import com.adevinta.android.barista.interaction.BaristaListInteractions.clickListItem
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.junit.Test


class DetailsFeatures:BaseUiTest() {
    private val numTestingPosition = 0
    private val movies = DummyData.generateMovies()

    @Test
    fun loadDetailsMovies(){
        clickListItem(R.id.rv_movies, numTestingPosition)
        assertDisplayed(R.id.detail_activity)
        assertHasDrawable(R.id.movie_poster_detail,movies[numTestingPosition].poster)
        assertDisplayed(R.id.movie_title_detail,movies[numTestingPosition].title)
        assertDisplayed(R.id.movie_director_detail,movies[numTestingPosition].director)
        assertDisplayed(R.id.movie_rating,movies[numTestingPosition].ratingMovie)
        assertDisplayed(R.id.movie_release_date,movies[numTestingPosition].releaseDate.toDateFormatRelease())
        assertDisplayed(R.id.movie_category,movies[numTestingPosition].category)
        assertDisplayed(R.id.movie_user_score,"${movies[numTestingPosition].userScore}%")
        assertDisplayed(R.id.movie_overview,movies[numTestingPosition].overview)
        assertRecyclerViewItemCount(R.id.rv_cast,movies[numTestingPosition].cast.size)
    }

    @Test
    fun navigateToIntentWhileClickButtonWatch(){
        clickListItem(R.id.rv_movies, numTestingPosition)
        try {
            Intents.init()
            val expectedIntent: Matcher<Intent> =allOf(hasAction(Intent.ACTION_VIEW), hasData(movies[numTestingPosition].urlWatch))
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
}