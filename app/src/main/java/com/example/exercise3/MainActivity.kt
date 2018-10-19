package com.example.exercise3

import android.content.Context
import android.content.res.Configuration
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Display
import android.view.Surface
import android.view.WindowManager
import android.widget.*
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createRecyclerView(this, isOrientationLand(), generateCats())

        /* code below only for List View
        val listContainer: ListView = findViewById(R.id.listView)
        val adapter: BaseAdapter = CatAdapter(this, generateCats())
        listContainer.adapter = adapter

        listContainer.setOnItemClickListener { _, view, i, _ ->
         if (i==0){
             view.findViewById<TextView>(R.id.text_in_row).text = "FUCK IT"
         Picasso.get().load("https://mtdata.ru/u28/photo96CE/20466331848-0/original.jpg").into(view.findViewById(R.id.image_in_row) as ImageView)
         } else {
             view.findViewById<ImageView>(R.id.image_in_row).setImageResource(R.drawable.background)
         } }*/
    }

    fun createRecyclerView(context: Context, land: Boolean, items: ArrayList<Cat>){
        val recyclerView = findViewById<RecyclerView>(R.id.recycle_view)
        recyclerView.apply {
            setHasFixedSize(true)
            if (land) {
                layoutManager = GridLayoutManager(context, 2)
            } else {
                layoutManager = LinearLayoutManager(context)
            }
            adapter = CatAdapterForRV(items)
        }
    }

    fun isOrientationLand(): Boolean{
        val display: Display = (getSystemService(Context.WINDOW_SERVICE) as WindowManager).defaultDisplay
        val getOrientation: Int = display.rotation
        if (getOrientation == Surface.ROTATION_90 || getOrientation == Surface.ROTATION_270){return true}
        return false
    }

    fun generateCats(): ArrayList<Cat> {
        val cats: ArrayList<Cat> = ArrayList()
        cats.add(Cat("https://mtdata.ru/u28/photo96CE/20466331848-0/original.jpg"))
        cats.add(Cat("http://bipbap.ru/wp-content/uploads/2017/08/5114e7b13c84a77355cbec162ca7ff45.jpg"))
        cats.add(Cat("http://bipbap.ru/wp-content/uploads/2017/09/2189909404.jpg"))
        cats.add(Cat("http://kakzachem.ru/wp-content/uploads/2018/01/Bez-imeni-2-8.jpg"))
        cats.add(Cat("https://static2.shop033.com/resources/18/160536/picture/5D/85442141.jpg"))
        cats.add(Cat("https://gloss.ua/file/t/17/11/28/bqeye_640x360.jpg"))
        cats.add(Cat("https://obovsem.pp.ua/wp-content/uploads/kotiki-31.jpg"))
        cats.add(Cat("https://www.telegraph.co.uk/content/dam/pets/2017/01/06/1-JS117202740-yana-two-face-cat-news_trans_NvBQzQNjv4BqJNqHJA5DVIMqgv_1zKR2kxRY9bnFVTp4QZlQjJfe6H0.jpg?imwidth=450"))
        cats.add(Cat("https://www.kedisahiplendirme.com/wp-content/uploads/2018/04/Scottish-Fold.jpg"))
        cats.add(Cat("http://honesttopaws.com/wp-content/uploads/sites/5/2017/05/banana-cat-1.png"))
        cats.add(Cat("http://www.catster.com/wp-content/uploads/2017/10/A-kitten-meowing-with-his-mouth-open.jpg"))
        cats.add(Cat("https://static.euronews.com/articles/432451/603x339_432451.jpg"))
        return cats
    }
}