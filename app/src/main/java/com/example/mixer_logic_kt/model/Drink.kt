package com.example.mixer_logic_kt.model

import android.net.Uri

class Drink (val name: String, val ingredients: List<Ingredient>, val imageUrl: Uri,
             val glass: Glass, val method: List<Method>, val garnish:List<Garnish>?,
             val categories: List<Category>, val alcohols: List<Alcohol>,
             val credits: List<Credit>, val step: List<Step>, val id: Int){

}