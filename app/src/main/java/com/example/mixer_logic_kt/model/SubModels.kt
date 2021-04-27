package com.example.mixer_logic_kt.model

data class Ingredient (val item: String, val amount: Int?, val unitOfMeasurement: String?)

data class Glass (val glassName: String){
    override fun toString(): String {
        return glassName.toString()
    }
}

data class Method (val methodName: String){
    override fun toString(): String {
        return methodName.toString()
    }
}

data class Garnish (val garnishName: String){
    override fun toString(): String {
        return garnishName.toString()
    }
}

data class Category (val categoryName: String)
{
    override fun toString(): String {
        return categoryName.toString()
    }
}

data class Alcohol (val alcoholName: String){
    override fun toString(): String {
        return alcoholName.toString()
    }
}

data class Credit( val source: String, val providedWhat: String){
    override fun toString(): String {
        return "$providedWhat : $source"
    }
}

data class Step (val stepText: String){
    override fun toString(): String {
        return stepText.toString()
    }
}



