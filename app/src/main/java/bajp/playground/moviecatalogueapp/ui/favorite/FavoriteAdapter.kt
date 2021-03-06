package bajp.playground.moviecatalogueapp.ui.favorite

import android.graphics.Typeface
import android.os.Build
import android.text.Spannable
import android.text.SpannableString
import android.text.style.AbsoluteSizeSpan
import android.text.style.TypefaceSpan
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import bajp.playground.moviecatalogueapp.R
import bajp.playground.moviecatalogueapp.data.DetailMovieEntity
import bajp.playground.moviecatalogueapp.databinding.ItemsMoviesBinding
import bajp.playground.moviecatalogueapp.utils.General.toGetYear
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class FavoriteAdapter:PagingDataAdapter<DetailMovieEntity,FavoriteAdapter.ViewHolder>(diffCallback) {
    private lateinit var itemCallback: ItemsCallback
    inner class ViewHolder(private val binding: ItemsMoviesBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(movie: DetailMovieEntity?){
            with(binding){

                Glide.with(itemView.context)
                    .load(movie?.poster)
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_image_loader).error(R.drawable.ic_empty_poster))
                    .into(moviePoster)

                val getToYear = movie?.releaseDate?.toGetYear()
                val title = itemView.context.getString(R.string.movie_title_and_years,"${movie?.title}","(${getToYear})")
                val spanText = SpannableString(title)
                val thinTextLength = title.length - 6
                val size = AbsoluteSizeSpan(14,true)
                spanText.setSpan(size,thinTextLength,title.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.P){
                    val typeFace = Typeface.create(
                        ResourcesCompat.getFont(itemView.context, R.font.roboto_thin),
                        Typeface.NORMAL)
                    spanText.setSpan(TypefaceSpan(typeFace),thinTextLength,title.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
                    movieTitle.text = spanText
                }else{
                    movieTitle.text = spanText
                }

                movieScore.text = itemView.context.getString(R.string.movie_score,movie?.userScore)
                movieScoreGraph.progress = movie?.userScore ?: 0
                movieOriLanguage.text = movie?.originLanguage?.uppercase()

                itemView.setOnClickListener { itemCallback.onClickItem(movie) }
            }
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemsViewBinding = ItemsMoviesBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(itemsViewBinding)
    }

    fun setOnClickListener(itemCallback:ItemsCallback){
        this.itemCallback = itemCallback
    }

    interface ItemsCallback{
        fun onClickItem(movie: DetailMovieEntity?)
    }

    companion object{
        val diffCallback =object :DiffUtil.ItemCallback<DetailMovieEntity>(){
            override fun areItemsTheSame(
                oldItem: DetailMovieEntity,
                newItem: DetailMovieEntity
            ): Boolean {
                return oldItem.movieId == newItem.movieId &&
                        oldItem.title == newItem.title &&
                        oldItem.tagline == newItem.tagline &&
                        oldItem.poster == newItem.poster &&
                        oldItem.overview == newItem.overview &&
                        oldItem.userScore == newItem.userScore &&
                        oldItem.releaseDate == newItem.releaseDate &&
                        oldItem.category == newItem.category &&
                        oldItem.urlWatch == newItem.urlWatch &&
                        oldItem.productionCountry == newItem.productionCountry &&
                        oldItem.originLanguage == newItem.originLanguage &&
                        oldItem.companies == newItem.companies &&
                        oldItem.type == newItem.type
            }

            override fun areContentsTheSame(
                oldItem: DetailMovieEntity,
                newItem: DetailMovieEntity
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}