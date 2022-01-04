package bajp.playground.moviecatalogueapp.utils

import bajp.playground.moviecatalogueapp.ui.home.HomeActivity
import com.adevinta.android.barista.rule.BaristaRule
import org.junit.Before
import org.junit.Rule

open class BaseUiTest {
    @get:Rule
    var mActivityRule = BaristaRule.create(HomeActivity::class.java)

    @Before
    fun setUpActivity(){
        mActivityRule.launchActivity()
    }
}