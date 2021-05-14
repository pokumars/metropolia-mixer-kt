package com.example.mixer_logic_kt.Util

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager


fun joinWithAnd (theList: List<String>): String{
    var result = ""
    if (theList.isEmpty()) result = "-"
    else if(theList.size == 1)result = theList[0]
    else if(theList.size > 1){
        val preparedList = theList.toMutableList()
        val lastStr = preparedList.last()
        preparedList.removeAt(theList.lastIndex)
        result = "${preparedList.reduce { acc, next -> "$acc, $next" }} & $lastStr"
    }
    return result
}

fun hideKeyboardInFragment(context: Context, view: View) {
    val inputManager = context.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    inputManager.hideSoftInputFromWindow(view.windowToken, 0)
}


