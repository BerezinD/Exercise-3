package com.example.exercise3

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import com.squareup.picasso.Picasso

class CatAdapterForRV(private val catList: ArrayList<Cat>
                      /*private val mClickListener: ItemClickListener*/): RecyclerView.Adapter<CatAdapterForRV.CatHolder>() {

    /*private val internalClickListener = View.OnClickListener {
        val kitty: Cat = it.getTag(R.id.key_for_click) as Cat
        if (kitty != null){
            val position = catList.indexOf(kitty)
            mClickListener.onItemClick(kitty, position)
        }
    }*/

    class CatHolder(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener{
        val imageView: ImageView?
        init {
            imageView = itemView.findViewById(R.id.image_of_cat_for_recycle_view)
            itemView.setOnClickListener(this)
        }
        override fun onClick(view: View){
            if (itemView != null){
                Toast.makeText(view.context, "meaow", Toast.LENGTH_LONG).show()
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