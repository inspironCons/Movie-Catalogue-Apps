package bajp.playground.moviecatalogueapp.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import bajp.playground.moviecatalogueapp.databinding.ActivitySplashScreenBinding
import bajp.playground.moviecatalogueapp.ui.home.HomeActivity

@SuppressLint("CustomSplashScreen")
class SplashScreenActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Looper.myLooper()?.let {
            Handler(it).postDelayed({
                startActivity(Intent(this, HomeActivity::class.java))
                finish()
            }, 3000)
        }

    }
}