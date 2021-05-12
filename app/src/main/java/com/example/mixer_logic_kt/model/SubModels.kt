package com.example.mixer_logic_kt.model


data class LoginRequestObj (val username: String, val password: String)


data class Method (val methodName: String){
    override fun toString(): String {
        return methodName.toString()
    }
}