package com.example.mixer_logic_kt.model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mixer_logic_kt.Ui.Screens.TAG
import com.example.mixer_logic_kt.network.DrinksApi
import kotlinx.coroutines.launch

class DrinkViewModel: ViewModel() {
    private val _drinks = MutableLiveData<List<Drink2>>()
    val drinks: LiveData<List<Drink2>> = _drinks

    private val _favourites =  MutableLiveData<List<Drink2>>()
    val favourites: LiveData<List<Drink2>> = _favourites

    //user will be here. We will check for it in startup
    private val _auth = MutableLiveData<Auth>()
    val auth: LiveData<Auth> = _auth

    //call this function when I have successfully logged in
    private fun getDrinks() {
        viewModelScope.launch {
            try {
                val listResult =  DrinksApi.retrofitService.getDrinks()
                Log.d(TAG, "drinks retrieved: ${listResult.size}")
                _drinks.value = listResult
            }
            catch (e: Exception) {
                // handle the exception to avoid abrupt termination.
                Log.d(TAG, "Error in DrinkViewModel-->getDrinks $e")
            }
        }

    }

    fun login (credentials: LoginRequestObj) {
        viewModelScope.launch {
            try {
                val loginResponse = DrinksApi.retrofitService.login(credentials)
                //set the user obj and the token
                _auth.value= loginResponse

                //populate the favourites based on what is in the list of user favourites list
                _favourites.value = drinks.value?.filter { it -> loginResponse.user.favourites.contains(it.id) }
                Log.d(TAG, loginResponse.toString())
            }catch (e: Exception){
                Log.d(TAG, "Error in DrinkViewModel--> login \n ------${e.message}")
            }
        }
    }

    //upon startup, checkForTokenAndGetUser
    fun checkForTokenAndGetUser() {
        //check for token
        //if it exists login i.e fetch user object
        //if it doesnt exist move to sign in page
    }

    init {
        getDrinks()
        //login ()
    }
}