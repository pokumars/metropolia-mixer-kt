package com.example.mixer_logic_kt.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.lifecycle.LiveData
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.mixer_logic_kt.R
import com.example.mixer_logic_kt.Ui.Screens.AllDrinksFragmentDirections
import com.example.mixer_logic_kt.model.Drink2

class DrinkAdapter(private val context: Context,
                   private val dataset: LiveData<List<Drink2>>
): RecyclerView.Adapter<DrinkAdapter.DrinkViewHolder>() {

    class DrinkViewHolder(val view: View): RecyclerView.ViewHolder(view) {
        val drinkNameTextView : TextView = view.findViewById(R.id.drink_title_tv)
        val drinkImage: ImageView = view.findViewById(R.id.drink_img_view)
        val drinkCard: CardView = view.findViewById(R.id.drink_card_view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DrinkViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
                .inflate(R.layout.drink_item, parent,false)

        return DrinkViewHolder(adapterLayout)
    }

    override fun getItemCount(): Int {
        return dataset.value?.size!!
    }

    override fun onBindViewHolder(holder: DrinkViewHolder, position: Int) {
        val drink = dataset.value?.get(position)!!
        holder.drinkNameTextView.text = drink.name.toUpperCase()
        holder.drinkImage.load(drink.imageUrl)
        //holder.drinkImage.loadImage(drink.imageUrl)

        holder.drinkCard.setOnClickListener {
            val action = AllDrinksFragmentDirections.actionAllDrinksFragmentToDrinkRecipeFragment(drinkId = drink.id, drinkName = drink.name)
            holder.view.findNavController().navigate(action)
        }
    }
}

