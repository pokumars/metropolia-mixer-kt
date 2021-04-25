package com.example.mixer_logic_kt.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mixer_logic_kt.R
import com.example.mixer_logic_kt.model.Drink

class DrinkAdapter (private val context: Context,
                    private val dataset: List<Drink>
): RecyclerView.Adapter<DrinkAdapter.DrinkViewHolder>() {

    class DrinkViewHolder(private val view: View): RecyclerView.ViewHolder(view) {
        val drinkNameTextView : TextView = view.findViewById(R.id.drink_title_tv)
        val drinkImage: ImageView = view.findViewById(R.id.drink_img_view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DrinkViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
                .inflate(R.layout.drink_item, parent,false)

        return DrinkViewHolder(adapterLayout)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: DrinkViewHolder, position: Int) {
        val drink = dataset[position]
        holder.drinkNameTextView.text = drink.name.toUpperCase()
        holder.drinkImage.setImageURI(drink.imageUrl)
    }
}