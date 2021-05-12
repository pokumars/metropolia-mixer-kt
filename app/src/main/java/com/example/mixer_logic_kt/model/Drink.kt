package com.example.mixer_logic_kt.model

import android.net.Uri

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