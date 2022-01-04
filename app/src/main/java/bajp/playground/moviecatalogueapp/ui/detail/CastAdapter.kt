package bajp.playground.moviecatalogueapp.ui.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import bajp.playground.moviecatalogueapp.R
import bajp.playground.moviecatalogueapp.data.CastEntity
import bajp.playground.moviecatalogueapp.databinding.ItemsCastBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class CastAdapter: RecyclerView.Adapter<CastAdapter.ViewHolder>() {
    private val listCast = ArrayList<CastEntity>()
    inner class ViewHolder(private val binding: ItemsCastBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(cast:CastEntity){
            with(binding){
                Glide.with(itemView.context)
                    .load(cast.image)
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_image_loader).error(R.drawable.cast_image_default))
                    .into(imageCast)

                actorName.text = cast.actor
                castAs.text = cast.name
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CastAdapter.ViewHolder {
        val binding = ItemsCastBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CastAdapter.ViewHolder, position: Int) {
        holder.bind(listCast[position])
    }

    override fun getItemCount(): Int = listCast.size

    fun setCast(cast:List<CastEntity>?){
        if(cast.isNullOrEmpty()) return
        this.listCast.clear()
        this.listCast.addAll(cast)
    }

}