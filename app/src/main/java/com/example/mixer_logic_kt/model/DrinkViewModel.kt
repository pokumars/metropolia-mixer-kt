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
    private var _auth = MutableLiveData<Auth>()
    val auth: LiveData<Auth> = _auth

    private val _signInErrorMessage = MutableLiveData<String>()
    val signInErrorMessage: LiveData<String> = _signInErrorMessage

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
                if(e.message!!.contains("HTTP 401 Unauthorized")){
                    _signInErrorMessage.value="The password and username do not match"
                } else if(e.message!!.contains("failed to connect")){
                    _signInErrorMessage.value="failed to connect to the internet/server"
                }else{
                    _signInErrorMessage.value="Something unusual went wrong in connecting or in logging in"
                }
            }
        }
    }

    fun setFavourites(){
        //Log.d(TAG, "setFavourites() _drinks --> ${_drinks.value?.size}")
        _favourites.value = drinks.value?.filter { it -> _auth.value!!.user.favourites.contains(it.id) }
        //Log.d(TAG, "setFavourites() __favourites --> ${_favourites.value?.size}")
        //Log.d(TAG, "setFavourites() _auth --> ${_auth.value}")
    }

    //upon startup, checkForTokenAndGetUser
    fun getUserWithToken(token:String) {
        //check for token
        //if it exists login i.e fetch user object
        //if it doesnt exist move to sign in page
        viewModelScope.launch {
            try {
                val fetchUserResponse = DrinksApi.retrofitService.getUserObject("bearer $token")
                Log.d(TAG, "${fetchUserResponse}")
                //favourites will be populated due to favourites fragment observing any changes that occur in auth
                _auth.value= Auth(fetchUserResponse, token)
            }
            catch (e: Exception){
                Log.e(TAG, "error in getUserWithToken --> ${e.message}")
            }
        }
    }

    fun wipeUser() {
        val emptyAuthObj = Auth(User(listOf(),"","", listOf(), listOf(),""), "")
        _auth.value = emptyAuthObj
    }

    fun likeDrink(drinkId: String, token:String) {
        viewModelScope.launch {
            try {
                val likeResponse = DrinksApi.retrofitService.likeDrink(drinkId, "bearer $token")

                _auth.value = Auth(likeResponse.updatedUser, token)
            }catch (e: Exception){
                Log.d(TAG, "$e")
            }
        }
    }

    init {
        getDrinks()
    }
}