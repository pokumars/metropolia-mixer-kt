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
    private val localDrinks2 = SomeDrinks().loadDrinks2()
    private val emptyLocalDrinks2 = SomeDrinks().loadNoDrinks2()

    private val _drinks = MutableLiveData<List<Drink2>>()
    val drinks: LiveData<List<Drink2>> = _drinks

    private val _favourites =  MutableLiveData<List<Drink2>>()
    val favourites: LiveData<List<Drink2>> = _favourites

    private val _temp =  MutableLiveData<String>()
    val temp: LiveData<String> = _temp

    //user will be here. We will check for it in startup

    private val _auth = MutableLiveData<Auth>()
    val auth: LiveData<Auth> = _auth

    //test to see if i can get a subset of the drinks which are the favourites
    val favIds = listOf<String>("606597a3761b364be86cc06d","6065980fc0eb384238391be0", "5f6e755ac12d131d00d75054")

    //call this function when I have successfully logged in
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
                Log.d(TAG, "Error in DrinkViewModel-->getDrinks $e")
            }
        }

    }

    private fun login () {
        viewModelScope.launch {
            try {
                //TODO remove
                val loginResponse = DrinksApi.retrofitService.login(LoginRequestObj("", ""))
                Log.d(TAG, loginResponse.toString())
            }catch (e: Exception){
                Log.d(TAG, "Error in DrinkViewModel--> login \n ------${e.message}")
            }
        }
    }


    init {
        //getDrinks()
        login ()
    }
}