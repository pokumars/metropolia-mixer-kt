package com.example.mixer_logic_kt.model

data class Auth(
    val token: String,
    val user: User
)

data class User(
    val email: String,
    val favourites: List<String>,
    val id: String,
    val myApprovedDrinkRecipes: List<String>,
    val myPendingDrinkRecipes: List<String>,
    val username: String
)