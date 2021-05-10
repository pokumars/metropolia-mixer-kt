package com.example.mixer_logic_kt.model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mixer_logic_kt.Ui.Screens.TAG
import com.example.mixer_logic_kt.network.DrinksApi
import com.example.mixer_logic_kt.testDataSource.SomeDrinks
import kotlinx.coroutines.launch

class DrinkViewModel: ViewModel() {
    private val localDrinks = SomeDrinks().loadDrinks()

    private val _drinks = MutableLiveData<List<Drink>>()
    val drinks: LiveData<List<Drink>> = _drinks

    private val _favourites =  MutableLiveData<List<Drink>>()
    val favourites: LiveData<List<Drink>> = _favourites

    private val _temp =  MutableLiveData<String>()
    val temp: LiveData<String> = _temp

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

    private fun getDrinks() {
        viewModelScope.launch {
            val listResult =  DrinksApi.retrofitService.getDrinks()
            Log.d(TAG, listResult)
        }
    }

    init {
        getDrinks()
    }
}