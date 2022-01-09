package bajp.playground.moviecatalogueapp.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import bajp.playground.moviecatalogueapp.R
import bajp.playground.moviecatalogueapp.databinding.ActivityHomeBinding
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.elevation = 0f
        initTabsView()
    }

    private fun initTabsView(){
        val adapter = HomePagerAdapter(supportFragmentManager,lifecycle)
        binding.vpHome.adapter = adapter
        TabLayoutMediator(binding.tlHome,binding.vpHome){tabs,position->
            tabs.text = when(position){
                0-> getString(R.string.movie_text)
                1-> getString(R.string.tv_show_text)
                else -> ""
            }
        }.attach()
    }

    override fun onBackPressed() {
        if(binding.tlHome.selectedTabPosition>0){
            binding.tlHome.getTabAt(0)?.select()
        }else{
            super.onBackPressed()
        }
    }
}