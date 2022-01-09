package bajp.playground.moviecatalogueapp.ui.detail

import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.text.LineBreaker
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import androidx.palette.graphics.Palette
import androidx.recyclerview.widget.LinearLayoutManager
import bajp.playground.moviecatalogueapp.R
import bajp.playground.moviecatalogueapp.data.CastEntity
import bajp.playground.moviecatalogueapp.databinding.ActivityDetailMovieBinding
import bajp.playground.moviecatalogueapp.utils.General.toDateFormatRelease
import bajp.playground.moviecatalogueapp.viewModel.ViewModelFactory
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class DetailMovieActivity:AppCompatActivity() {

    private lateinit var binding: ActivityDetailMovieBinding
    @Inject
    lateinit var factory: ViewModelFactory

    private lateinit var viewModel: DetailMovieViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this,factory)[DetailMovieViewModel::class.java]
        getDetail()
        onBackNav()
    }

    private fun onBackNav() {
        binding.btnMenu.setOnClickListener {
            onBackPressed()
        }
    }

    private fun getDetail() {
        val extra = intent.extras
        if(extra != null){
            val id = extra.getString(idMovie) as String
            viewModel.detailMovie(id).observe(this){ result->
                val movie = result.getOrNull()

                with(binding){


                    val bitmap = movie?.poster?.let { BitmapFactory.decodeResource(resources, it) }

                    Glide.with(this@DetailMovieActivity)
                        .load(bitmap)
                        .apply(RequestOptions().error(R.drawable.movie_poster_default))
                        .into(moviePosterDetail)

                    if (bitmap != null) {
                        Palette.Builder(bitmap).generate { palette->
                            val dominantColor = palette?.getDominantColor(ContextCompat.getColor(this@DetailMovieActivity,R.color.primary_color))
                            val window = window
                            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
                            if(dominantColor != null) window.statusBarColor = dominantColor
                        }
                    }

                    movieTitleDetail.text = movie?.title
                    movieDirectorDetail.text = movie?.director
                    movieUserScore.text = getString(R.string.movie_score,movie?.userScore)
                    movieReleaseDate.text = movie?.releaseDate?.toDateFormatRelease()
                    movieRating.text = movie?.ratingMovie
                    movieCategory.text = movie?.category

                    movieOverview.text = movie?.overview
                    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q){
                        movieOverview.justificationMode = LineBreaker.JUSTIFICATION_MODE_INTER_WORD
                    }

                    navigateToWatch(movie?.urlWatch)
                    generateCast(movie?.cast)
                }
            }
        }

    }

    private fun generateCast(cast: List<CastEntity>?) {
        val adapter = CastAdapter()
        adapter.setCast(cast)
        with(binding){
            rvCast.layoutManager = LinearLayoutManager(this@DetailMovieActivity,LinearLayoutManager.HORIZONTAL,false)
            rvCast.adapter = adapter
        }
    }

    private fun navigateToWatch(urlWatch: String?) {
        binding.btnWatch.setOnClickListener {
            if(urlWatch != null){
                val mIntent = Intent(Intent.ACTION_VIEW)
                mIntent.data = Uri.parse(urlWatch)
                startActivity(mIntent)
            }
        }
    }

    companion object{
        const val idMovie = "idMovie"
    }
}