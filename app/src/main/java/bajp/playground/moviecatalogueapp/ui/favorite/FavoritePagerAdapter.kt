package bajp.playground.moviecatalogueapp.ui.favorite

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import bajp.playground.moviecatalogueapp.ui.favorite.movies.MoviesFavoriteFragment
import bajp.playground.moviecatalogueapp.ui.favorite.tvshows.TvShowsFavoriteFragment

class FavoritePagerAdapter(
    fm:FragmentManager,
    lifecycle: Lifecycle
):FragmentStateAdapter(fm,lifecycle) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0-> MoviesFavoriteFragment()
            1-> TvShowsFavoriteFragment()
            else->Fragment()
        }
    }


}