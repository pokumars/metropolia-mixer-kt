package com.example.mixer_logic_kt.model

import android.net.Uri

class Drink (val name: String, val ingredients: List<Ingredient>, val imageUrl: Uri,
             val glass: Glass, val method: List<Method>, val garnish:List<Garnish>?,
             val categories: List<Category>, val alcohols: List<Alcohol>,
             val credits: List<Credit>, val steps: List<Step>, val id: Int){
    //like
    //unlike
    fun aboutDrink () {
        println("Name: $name; method: ${method}")
    }

}

data class Drink2(
    val alcohols: List<String>,
    val categories: List<String>,
    val credits: List<List<String>>,
    val garnish: List<String>,
    val glass: String,
    val id: String,
    val imageUrl: String,
    val ingredients: List<List<Any>>,
    val method: List<String>,
    val name: String,
    val page: Int,
    val steps: List<String>
)