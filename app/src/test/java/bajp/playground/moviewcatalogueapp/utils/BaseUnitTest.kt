package bajp.playground.moviewcatalogueapp.utils

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Rule

open class BaseUnitTest {
    @ExperimentalCoroutinesApi
    @get:Rule
    val coroutineTestRule = MainCoroutineScopeRule()

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()
}