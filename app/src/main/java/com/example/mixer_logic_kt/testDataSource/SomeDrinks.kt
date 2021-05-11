package com.example.mixer_logic_kt.testDataSource

import com.example.mixer_logic_kt.model.Drink
import com.example.mixer_logic_kt.model.Drink2

class SomeDrinks() {
        fun loadNoDrinks(): List<Drink>{
                return listOf<Drink>()
        }

        fun loadDrinks(): List<Drink> {
        return listOf<Drink>()
        }

        fun loadDrinks2(): List<Drink2> {
                return listOf<Drink2>(
                        Drink2(name="Vodka Martini",  id= "1",
                                imageUrl= "https://mixer-logic-p2images.s3.eu-central-1.amazonaws.com/vodkaMartini.jpg",
                                alcohols= listOf("vodka", "dry vermouth"), categories= listOf("classic", "martini", "cocktail"),
                                credits= listOf(listOf("Finlandia Vodka", "image"), listOf("Finlandia Vodka", "recipe")),
                                garnish= listOf("olives", "lemon twist"), glass= "cocktail",
                                ingredients= listOf(listOf("vodka", 4, "cl"), listOf("dry vermouth", 1, "dash")),
                                method= listOf("stir"),  page=15,
                                steps= listOf("Chill both the martini and mixing glasses", "Pour the vodka, followed by the dry vermouth in an ice-filled mixing glass and stir.", "Olive - or twist? Your choice." , "Cheers" )
                        ),
                        Drink2(name="Bloody Mary",  id= "2",
                                imageUrl= "https://mixer-logic-p2images.s3.eu-central-1.amazonaws.com/bloodyMaryCocktail.jpg",
                                alcohols=listOf("vodka", "lime vodka"), categories=listOf("classic", "ordinary drink"),
                                credits=listOf(listOf("Finlandia Vodka", "image"), listOf("Finlandia Vodka", "recipe")),
                                garnish=listOf("olives", "celery stalk"), glass= "On The Rocks",
                                ingredients=listOf(listOf("vodka", 2, "cl"), listOf("lemon juice", 1, "cl"), listOf("lime vodka", 2, "cl"), listOf("tomato juice", 8, "cl"), listOf("salt & pepper", "null", "null"), listOf("tabasco/hot sauce ", 3, "drops"), listOf("worcestershire sauce", 2, "dashes")),
                                method=listOf("stir"),  page=15,
                                steps=listOf("Add the ingredients into the mixer", "Mix and chill together with ice", "Strain into a rocks glass", "garnish with celery and cucumber")),

                        Drink2( name="Spicy Mule", id= "3",
                                imageUrl= "https://mixer-logic-p2images.s3.eu-central-1.amazonaws.com/spicyMule.jpg",
                                alcohols=listOf("vodka", "ginger beer"), categories=listOf("vodka", "cocktail"),
                                credits=listOf(listOf("Finlandia Vodka", "image"), listOf("Finlandia Vodka", "recipe")),
                                garnish=listOf("olives", "lime wedge", "cucumber stick"), glass= "highball",
                                ingredients=listOf(listOf("vodka", 4, "cl"), listOf("ginger beer", 10, "cl"), listOf("fresh lime juice", 2, "cl"), listOf("fresh ginger", "null", "null"), listOf("chili pepper","null", "null")),
                                method=listOf("muddle", "build"),  page=15,
                                steps=listOf("Muddle the ginger in a glass with the sliced pepper.", "Add the ice, lime juice and ginger beer.", "Finally, add the vodka and a lime and fresh chili pepper to garnish")),
                        Drink2(name="Mango Breeze",  id= "4",
                                imageUrl= "https://mixer-logic-p2images.s3.eu-central-1.amazonaws.com/mangoBreeze.jpg",
                                alcohols= listOf("vodka", "dry vermouth"), categories= listOf("classic", "martini", "cocktail"),
                                credits= listOf(listOf("Finlandia Vodka", "image"), listOf("Finlandia Vodka", "recipe")),
                                garnish= listOf("olives", "lemon twist"), glass= "cocktail",
                                ingredients= listOf(listOf("vodka", 4, "cl"), listOf("dry vermouth", 1, "dash")),
                                method= listOf("stir"),  page=15,
                                steps= listOf("Chill both the martini and mixing glasses", "Pour the vodka, followed by the dry vermouth in an ice-filled mixing glass and stir.", "Olive - or twist? Your choice." , "Cheers" )
                        ),
                        Drink2(name="Mini Mary",  id= "5",
                                imageUrl= "https://mixer-logic-p2images.s3.eu-central-1.amazonaws.com/miniMary.jpg",
                                alcohols=listOf("vodka", "lime vodka"), categories=listOf("classic", "ordinary drink"),
                                credits=listOf(listOf("Finlandia Vodka", "image"), listOf("Finlandia Vodka", "recipe")),
                                garnish=listOf("olives", "celery stalk"), glass= "On The Rocks",
                                ingredients=listOf(listOf("vodka", 2, "cl"), listOf("lemon juice", 1, "cl"), listOf("lime vodka", 2, "cl"), listOf("tomato juice", 8, "cl"), listOf("salt & pepper", "null", "null"), listOf("tabasco/hot sauce ", 3, "drops"), listOf("worcestershire sauce", 2, "dashes")),
                                method=listOf("stir"),  page=15,
                                steps=listOf("Add the ingredients into the mixer", "Mix and chill together with ice", "Strain into a rocks glass", "garnish with celery and cucumber")),

                        Drink2( name="Long Island Iced Tea", id= "6",
                                imageUrl= "https://mixer-logic-p2images.s3.eu-central-1.amazonaws.com/miniSeaBreeze.jpg",
                                alcohols=listOf("vodka", "ginger beer"), categories=listOf("vodka", "cocktail"),
                                credits=listOf(listOf("Finlandia Vodka", "image"), listOf("Finlandia Vodka", "recipe")),
                                garnish=listOf("olives", "lime wedge", "cucumber stick"), glass= "highball",
                                ingredients=listOf(listOf("vodka", 4, "cl"), listOf("ginger beer", 10, "cl"), listOf("fresh lime juice", 2, "cl"), listOf("fresh ginger", "null", "null"), listOf("chili pepper","null", "null")),
                                method=listOf("muddle", "build"),  page=15,
                                steps=listOf("Muddle the ginger in a glass with the sliced pepper.", "Add the ice, lime juice and ginger beer.", "Finally, add the vodka and a lime and fresh chili pepper to garnish")),


                        Drink2(name="Cinnamini",  id= "7",
                                imageUrl= "https://mixer-logic-p2images.s3.eu-central-1.amazonaws.com/cinnamini.jpg",
                                alcohols= listOf("vodka", "dry vermouth"), categories= listOf("classic", "martini", "cocktail"),
                                credits= listOf(listOf("Finlandia Vodka", "image"), listOf("Finlandia Vodka", "recipe")),
                                garnish= listOf("olives", "lemon twist"), glass= "cocktail",
                                ingredients= listOf(listOf("vodka", 4, "cl"), listOf("dry vermouth", 1, "dash")),
                                method= listOf("stir"),  page=15,
                                steps= listOf("Chill both the martini and mixing glasses", "Pour the vodka, followed by the dry vermouth in an ice-filled mixing glass and stir.", "Olive - or twist? Your choice." , "Cheers" )
                        ),
                        Drink2(name="Caipiroska",  id= "8",
                                imageUrl= "https://mixer-logic-p2images.s3.eu-central-1.amazonaws.com/caipiroska.jpg",
                                alcohols=listOf("vodka", "lime vodka"), categories=listOf("classic", "ordinary drink"),
                                credits=listOf(listOf("Finlandia Vodka", "image"), listOf("Finlandia Vodka", "recipe")),
                                garnish=listOf("olives", "celery stalk"), glass= "On The Rocks",
                                ingredients=listOf(listOf("vodka", 2, "cl"), listOf("lemon juice", 1, "cl"), listOf("lime vodka", 2, "cl"), listOf("tomato juice", 8, "cl"), listOf("salt & pepper", "null", "null"), listOf("tabasco/hot sauce ", 3, "drops"), listOf("worcestershire sauce", 2, "dashes")),
                                method=listOf("stir"),  page=15,
                                steps=listOf("Add the ingredients into the mixer", "Mix and chill together with ice", "Strain into a rocks glass", "garnish with celery and cucumber")),

                        Drink2( name="Oriental Caipiroska", id= "9",
                                imageUrl= "https://mixer-logic-p2images.s3.eu-central-1.amazonaws.com/orientalCaipiroska.jpg",
                                alcohols=listOf("vodka", "ginger beer"), categories=listOf("vodka", "cocktail"),
                                credits=listOf(listOf("Finlandia Vodka", "image"), listOf("Finlandia Vodka", "recipe")),
                                garnish=listOf("olives", "lime wedge", "cucumber stick"), glass= "highball",
                                ingredients=listOf(listOf("vodka", 4, "cl"), listOf("ginger beer", 10, "cl"), listOf("fresh lime juice", 2, "cl"), listOf("fresh ginger", "null", "null"), listOf("chili pepper","null", "null")),
                                method=listOf("muddle", "build"),  page=15,
                                steps=listOf("Muddle the ginger in a glass with the sliced pepper.", "Add the ice, lime juice and ginger beer.", "Finally, add the vodka and a lime and fresh chili pepper to garnish"))
                )
        }

}