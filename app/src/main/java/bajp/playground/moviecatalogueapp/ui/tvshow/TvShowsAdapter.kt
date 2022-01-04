package bajp.playground.moviecatalogueapp.ui.tvshow

import android.graphics.BitmapFactory
import android.graphics.Typeface
import android.os.Build
import android.text.Spannable
import android.text.SpannableString
import android.text.style.AbsoluteSizeSpan
import android.text.style.TypefaceSpan
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import bajp.playground.moviecatalogueapp.R
import bajp.playground.moviecatalogueapp.data.MovieEntity
import bajp.playground.moviecatalogueapp.databinding.ItemsMoviesBinding
import bajp.playground.moviecatalogueapp.utils.General.toGetYear
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class TvShowsAdapter:RecyclerView.Adapter<TvShowsAdapter.ViewHolder>() {
    private var listTvShow = ArrayList<MovieEntity>()
    private lateinit var itemCallback: ItemsCallback

    inner class ViewHolder(private val binding: ItemsMoviesBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(movie:MovieEntity){
            with(binding){
                val bitmap = BitmapFactory.decodeResource(itemView.resources, movie.poster)
                Glide.with(itemView.context)
                    .load(bitmap)
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_image_loader).error(R.drawable.ic_empty_poster))
                    .into(moviePoster)

                val title = itemView.context.getString(R.string.movie_title_and_years,movie.title,"(${movie.releaseDate.toGetYear()})")
                val spanText = SpannableString(title)
                val thinTextLength = title.length - 6
                val size = AbsoluteSizeSpan(14,true)
                spanText.setSpan(size,thinTextLength,title.length,Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.P){
                    val typeFace = Typeface.create(ResourcesCompat.getFont(itemView.context,R.font.roboto_thin),Typeface.NORMAL)
                    spanText.setSpan(TypefaceSpan(typeFace),thinTextLength,title.length,Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
                    movieTitle.text = spanText
                }else{
                    movieTitle.text = spanText
                }

                movieScore.text = itemView.context.getString(R.string.movie_score,movie.userScore)
                movieScoreGraph.progress = movie.userScore
                movieRating.text = movie.ratingMovie
                movieCategory.text = movie.category


                itemView.setOnClickListener { itemCallback.onClickItem(movie) }
            }
        }
    }

    fun setMovies(list:List<MovieEntity>?){
        if(list.isNullOrEmpty())return
        this.listTvShow.clear()
        this.listTvShow.addAll(list)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemsViewBinding = ItemsMoviesBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(itemsViewBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = listTvShow[position]
        holder.bind(data)
    }

    override fun getItemCount(): Int = listTvShow.size
    fun setOnClickListener(itemCallback:ItemsCallback){
        this.itemCallback = itemCallback
    }

    interface ItemsCallback{
        fun onClickItem(movie:MovieEntity)
    }
}