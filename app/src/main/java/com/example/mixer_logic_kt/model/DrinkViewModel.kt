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
    private val localDrinks2 = SomeDrinks().loadDrinks2()
    private val emptyLocalDrinks2 = SomeDrinks().loadNoDrinks2()

    private val _drinks = MutableLiveData<List<Drink2>>()
    val drinks: LiveData<List<Drink2>> = _drinks

    private val _favourites =  MutableLiveData<List<Drink2>>()
    val favourites: LiveData<List<Drink2>> = _favourites

    private val _temp =  MutableLiveData<String>()
    val temp: LiveData<String> = _temp

    /*private val _user = MutableLiveData<>()
    val user: LiveData<> = _user*/

    val favIds = listOf<String>("606597a3761b364be86cc06d","6065980fc0eb384238391be0", "5f6e755ac12d131d00d75054")

    private fun setDrinks() {
       //SomeDrinks().loadNoDrinks()
        //_drinks.value = localDrinks2
        _drinks.value = emptyLocalDrinks2
    }

    private fun setFavourites() {
        //SomeDrinks().loadNoDrinks()
        _favourites.value = localDrinks2
    }

    private fun getDrinks() {
        viewModelScope.launch {

            try {
                // some code that can cause an exception.
                val listResult =  DrinksApi.retrofitService.getDrinks()
                Log.d(TAG, listResult.size.toString())
                Log.d(TAG, listResult[0].toString())
                _drinks.value = listResult
                _favourites.value = listResult.filter { it -> favIds.contains(it.id) }
            }
            catch (e: Exception) {
                // handle the exception to avoid abrupt termination.
                Log.d(TAG, "some error ---> $e")
            }
        }

    }

    init {
        getDrinks()
    }
}