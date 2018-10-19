package com.example.exercise3

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

// This adapter for ListView

class CatAdapter(context: Context, listOfItems: ArrayList<Cat>): BaseAdapter() {

    private val mInflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    private val mListOfItems = listOfItems

    override fun getCount(): Int {
        return mListOfItems.size
    }

    override fun getItem(position: Int): Any {
        return mListOfItems[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    private class ViewHolder(view: View?){
        var nameOfCat: TextView? = view?.findViewById(R.id.text_in_row)
        var imageOfCat: ImageView? = view?.findViewById(R.id.image_in_row)
    }

    private fun onCreateViewHolder(parent: ViewGroup?): View{
        /* we need this method for refactoring*/
        val tempView = mInflater.inflate(R.layout.row_element, parent, false)
        val tempHolder = ViewHolder(tempView)
        tempView.tag = tempHolder
        return tempView
    }

    private fun onBindViewHolder(tempHolder: ViewHolder, tempCat: Cat, tempPosition: Int){
        Picasso.get().setIndicatorsEnabled(true)
        Picasso.get().load(tempCat.url).into(tempHolder.imageOfCat)
        val posPlusOne = tempPosition + 1
        tempHolder.nameOfCat?.text = "My cat with number $posPlusOne"
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        val holder: ViewHolder
        val cats: Cat = mListOfItems[position]
        var view: View? = convertView

        // main logic
        if (convertView == null){
            view = onCreateViewHolder(parent)
        }
        holder = view?.tag as ViewHolder
        onBindViewHolder(holder, cats, position)
        return view
    }
}