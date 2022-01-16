package bajp.playground.moviecatalogueapp.ui.detail

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
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
import bajp.playground.moviecatalogueapp.common.ConstanNameHelper
import bajp.playground.moviecatalogueapp.data.CompaniesEntity
import bajp.playground.moviecatalogueapp.databinding.ActivityDetailMovieBinding
import bajp.playground.moviecatalogueapp.utils.General.toDateFormatRelease
import bajp.playground.moviecatalogueapp.viewModel.ViewModelDetailMovieRepoFactory
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class DetailMovieActivity:AppCompatActivity() {

    private lateinit var binding: ActivityDetailMovieBinding
    @Inject
    lateinit var movieRepoFactory: ViewModelDetailMovieRepoFactory

    private lateinit var viewModel: DetailMovieViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this,movieRepoFactory)[DetailMovieViewModel::class.java]
        getDetail()
        onBackNav()
    }

    private fun onBackNav() {
        binding.btnMenu.setOnClickListener {
            onBackPressed()
        }
    }

    @SuppressLint("StringFormatInvalid")
    private fun getDetail() {
        val extra = intent.extras
        if(extra != null){
            val id = extra.getInt(idMovie)
            val type = extra.getString(type) as String
            if(type == ConstanNameHelper.TV_TYPE){
                binding.tvLableCompanies.text = getString(R.string.network)
            }else{
                binding.tvLableCompanies.text = getString(R.string.companies)
            }
            viewModel.detailMovie(id,type).observe(this){ result->
                val movie = result.getOrNull()

                with(binding){

                    Glide.with(this@DetailMovieActivity)
                        .asBitmap()
                        .load(movie?.poster)
                        .apply(RequestOptions().error(R.drawable.movie_poster_default))
                        .into(object : CustomTarget<Bitmap>(1280, 720){
                            override fun onResourceReady(
                                resource: Bitmap,
                                transition: Transition<in Bitmap>?
                            ) {
                                moviePosterDetail.setImageBitmap(resource)

                                Palette.Builder(resource).generate { palette->
                                    val dominantColor = palette?.getDominantColor(ContextCompat.getColor(this@DetailMovieActivity,R.color.primary_color))
                                    val window = window
                                    window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
                                    if(dominantColor != null) window.statusBarColor = dominantColor
                                }
                            }

                            override fun onLoadCleared(placeholder: Drawable?) {
                            }
                        })

                    movieTitleDetail.text = movie?.title
                    movieTagline.text = getString(R.string.tagline,movie?.tagline)
                    movieUserScore.text = getString(R.string.movie_score,movie?.userScore)
                    movieReleaseDate.text = movie?.releaseDate?.toDateFormatRelease()
                    movieProductionCountry.text = movie?.productionCountry
                    movieCategory.text = movie?.category?.joinToString(",")

                    movieOverview.text = movie?.overview
                    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q){
                        movieOverview.justificationMode = LineBreaker.JUSTIFICATION_MODE_INTER_WORD
                    }

                    navigateToWatch(movie?.urlWatch)
                    generateCast(movie?.companies)
                }
            }
        }

    }

    private fun generateCast(companies: List<CompaniesEntity>?) {
        val adapter = CompaniesAdapter()
        adapter.setCompanies(companies)
        with(binding){
            rvCompanies.layoutManager = LinearLayoutManager(this@DetailMovieActivity,LinearLayoutManager.HORIZONTAL,false)
            rvCompanies.adapter = adapter
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
        const val type = "TYPE"

    }
}