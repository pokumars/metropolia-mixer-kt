package com.example.mixer_logic_kt.Util

import android.net.Uri
import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.loadImage(uri: Uri){
    Glide.with(context)
        .load(uri)
        .into(this)
}

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


fun displayNullString (str: String?): String{
    val result = if (str==null|| str=="null") "" else str
    return result
}

