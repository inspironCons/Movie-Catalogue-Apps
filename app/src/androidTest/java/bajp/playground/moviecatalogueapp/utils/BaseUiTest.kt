package bajp.playground.moviecatalogueapp.utils

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.IdlingRegistry
import bajp.playground.moviecatalogueapp.remote.local.database.MovieDatabase
import bajp.playground.moviecatalogueapp.remote.local.database.dao.FavoriteDao
import bajp.playground.moviecatalogueapp.ui.home.HomeActivity
import com.adevinta.android.barista.rule.BaristaRule
import org.junit.After
import org.junit.Before
import org.junit.Rule

open class BaseUiTest {

    @get:Rule
    var mActivityRule = BaristaRule.create(HomeActivity::class.java)
    lateinit var db: RoomDatabase
    lateinit var favoriteDao: FavoriteDao

    fun createDbFavorite(){
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(
            context, MovieDatabase::class.java
        ).build()
        favoriteDao = (db as MovieDatabase).favoriteDao()
    }


    @Before
    fun setUpActivity(){
        mActivityRule.launchActivity()
        IdlingRegistry.getInstance().register(EspressoIdling.getEspressoIdlingResource)
    }

    @After
    fun tearDown(){
        IdlingRegistry.getInstance().unregister(EspressoIdling.getEspressoIdlingResource)
    }

//
}