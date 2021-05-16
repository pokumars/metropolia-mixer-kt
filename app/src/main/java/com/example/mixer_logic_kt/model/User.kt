package com.example.mixer_logic_kt.model

data class Auth(
        var user: User,
        val token: String
)

data class User(
    val favourites: List<String>,
    val email: String,
    val id: String,
    val myApprovedDrinkRecipes: List<String>,
    val myPendingDrinkRecipes: List<String>,
    val username: String
)

data class UpdatedUser(
        val updatedUser: User
)