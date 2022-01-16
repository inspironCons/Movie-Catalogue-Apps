package bajp.playground.moviecatalogueapp.ui.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import bajp.playground.moviecatalogueapp.R
import bajp.playground.moviecatalogueapp.data.CompaniesEntity
import bajp.playground.moviecatalogueapp.databinding.ItemsCompaniesBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class CompaniesAdapter: RecyclerView.Adapter<CompaniesAdapter.ViewHolder>() {
    private val listCompanies = ArrayList<CompaniesEntity>()
    inner class ViewHolder(private val binding: ItemsCompaniesBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(cast:CompaniesEntity){
            with(binding){
                Glide.with(itemView.context)
                    .load(cast.logos)
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_image_loader).error(R.drawable.cast_image_default))
                    .into(logoCompanies)

                nameCompanies.text = cast.name
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CompaniesAdapter.ViewHolder {
        val binding = ItemsCompaniesBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CompaniesAdapter.ViewHolder, position: Int) {
        holder.bind(listCompanies[position])
    }

    override fun getItemCount(): Int = listCompanies.size

    fun setCompanies(cast:List<CompaniesEntity>?){
        if(cast.isNullOrEmpty()) return
        this.listCompanies.clear()
        this.listCompanies.addAll(cast)
    }

}