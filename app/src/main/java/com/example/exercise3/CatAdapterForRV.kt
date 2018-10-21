package com.example.exercise3

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import com.squareup.picasso.Picasso
import android.media.MediaPlayer

class CatAdapterForRV(private val catList: ArrayList<Cat>
                      ): RecyclerView.Adapter<CatAdapterForRV.CatHolder>() {

    class CatHolder(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener{
        val imageView: ImageView?
        init {
            imageView = itemView.findViewById(R.id.image_of_cat_for_recycle_view)
            itemView.setOnClickListener(this)
        }
        override fun onClick(view: View){
            if (itemView != null){
                val mediaPlayer = MediaPlayer.create(itemView.context, R.raw.cat_sound)
                mediaPlayer.start()
            }
        }
    }

    override fun onBindViewHolder(tempHolder: CatHolder, position: Int) {
        Picasso.get().load(catList[position].url)
                .error(R.drawable.ic_error_outline_black_24dp)
                .into(tempHolder.imageView)
    }

    override fun getItemCount(): Int = catList.size

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): CatHolder {
        val catImageView = LayoutInflater.from(parent.context).inflate(R.layout.image_of_cat, parent, false)
        return CatHolder(catImageView)
    }

    interface ItemClickListener {
        fun onItemClick(cat: Cat, position: Int)
    }
}