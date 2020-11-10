package com.example.myrecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.item_grid_demon.view.*

class GridHeroAdapter(private val listHero: ArrayList<Hero>) : RecyclerView.Adapter<GridHeroAdapter.GridViewHolder>() {
    private var onItemClickCallback: OnItemClickCallback? = null
    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): GridViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_grid_demon, viewGroup, false)
        return GridViewHolder(view)
    }

    override fun onBindViewHolder(holder: GridViewHolder, position: Int) {
        holder.bind(listHero[position])
    }

    override fun getItemCount(): Int = listHero.size

    inner class GridViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(hero: Hero) {
            with(itemView){
                Glide.with(itemView.context)
                    .load(hero.photo)
                    .apply(RequestOptions().override(350, 550))
                    .into(img_item_photo)
                itemView.setOnClickListener { onItemClickCallback?.onItemClicked(hero) }
            }
        }
    }
    interface OnItemClickCallback {
        fun onItemClicked(data: Hero)
    }
}
