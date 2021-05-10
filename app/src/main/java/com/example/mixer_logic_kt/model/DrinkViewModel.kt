package com.example.mixer_logic_kt.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mixer_logic_kt.testDataSource.SomeDrinks

class DrinkViewModel: ViewModel() {
    private val localDrinks = SomeDrinks().loadDrinks()
    private val _drinks = MutableLiveData<List<Drink>>()
    val drinks: LiveData<List<Drink>> = _drinks

    private val _favourites =  MutableLiveData<List<Drink>>()
    val favourites: LiveData<List<Drink>> = _favourites

    /*private val _user = MutableLiveData<>()
    val user: LiveData<> = _user*/

    fun setDrinks() {
       //SomeDrinks().loadNoDrinks()
        _drinks.value = localDrinks
    }

    fun setFavourites() {
        //SomeDrinks().loadNoDrinks()
        _favourites.value = localDrinks
    }
}