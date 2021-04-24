package com.example.mixer_logic_kt.testDataSource

import android.net.Uri
import com.example.mixer_logic_kt.model.*

class SomeDrinks() {
    fun loadDrinks(): List<Drink> {
        return listOf<Drink>(
                Drink("Vodka Martini",
                        listOf<Ingredient>(
                                Ingredient("vodka", 4, "cl"),
                                Ingredient("dry vermouth", 1, "dash")
                        ),
                        Uri.parse("https://mixer-logic-p2images.s3.eu-central-1.amazonaws.com/vodkaMartini.jpg"),
                        Glass("cocktail"), listOf<Method>(Method("stir")),
                        listOf<Garnish>(Garnish("olives"), Garnish("lemon twist")),
                        listOf<Category>(Category("classic"), Category("martini"), Category("cocktail")),
                        listOf<Alcohol>(Alcohol("vodka"), Alcohol("dry vermouth")),
                        listOf<Credit>(Credit("Finlandia Vodka", "image"), Credit("Finlandia Vodka", "recipe")),
                        listOf<Step>(Step("Chill both the martini and mixing glasses"),
                                Step("Pour the vodka, followed by the dry vermouth in an ice-filled mixing glass and stir."),
                                Step("Olive - or twist? Your choice."),
                                Step("Cheers")
                        ),
                        1
                ),
                Drink("Bloody Mary",
                        listOf<Ingredient>(
                                Ingredient("vodka", 2, "cl"),
                                Ingredient("lemon juice", 1, "cl"),
                                Ingredient("lime vodka", 2, "cl"),
                                Ingredient("tomato juice", 8, "cl"),
                                Ingredient("salt & pepper", null, null),
                                Ingredient("tabasco/hot sauce ", 3, "drops"),
                                Ingredient("worcestershire sauce", 2, "dashes")
                        ),
                        Uri.parse("https://mixer-logic-p2images.s3.eu-central-1.amazonaws.com/bloodyMaryCocktail.jpg"),
                        Glass("On The Rocks"), listOf<Method>(Method("stir")),
                        listOf<Garnish>(Garnish("olives"), Garnish("celery stalk"), Garnish("cucumber")),
                        listOf<Category>(Category("classic"), Category("ordinary drink")),
                        listOf<Alcohol>(Alcohol("vodka"), Alcohol("lime vodka")),
                        listOf<Credit>(Credit("Finlandia Vodka", "image"), Credit("Finlandia Vodka", "recipe")),
                        listOf<Step>(Step("Add the ingredients into the mixer"),
                                Step("Mix and chill together with ice"),
                                Step("Strain into a rocks glass"),
                                Step("garnish with celery and cucumber")
                        ),
                        2
                ),

                Drink("Spicy Mule",
                        listOf<Ingredient>(
                                Ingredient("vodka", 4, "cl"),
                                Ingredient("ginger beer", 10, "cl"),
                                Ingredient("fresh lime juice", 2, "cl"),
                                Ingredient("fresh ginger", null, null),
                                Ingredient("chili pepper", null, null)
                        ),
                        Uri.parse("https://mixer-logic-p2images.s3.eu-central-1.amazonaws.com/spicyMule.jpg"),
                        Glass("highball"), listOf<Method>(Method("muddle"), Method("build")),
                        listOf<Garnish>(Garnish("olives"), Garnish("lime wedge"), Garnish("cucumber stick")),
                        listOf<Category>(Category("vodka"), Category("cocktail")),
                        listOf<Alcohol>(Alcohol("vodka"), Alcohol("ginger beer")),
                        listOf<Credit>(Credit("Finlandia Vodka", "image"), Credit("Finlandia Vodka", "recipe")),
                        listOf<Step>(Step("Muddle the ginger in a glass with the sliced pepper."),
                                Step("Add the ice, lime juice and ginger beer."),
                                Step("Finally, add the vodka and a lime and fresh chili pepper to garnish")
                        ),
                        3
                ),
                Drink("Mango Breeze",
                        listOf<Ingredient>(
                                Ingredient("vodka", 2, "cl"),
                                Ingredient("lemon juice", 1, "cl"),
                                Ingredient("lime vodka", 2, "cl"),
                                Ingredient("tomato juice", 8, "cl"),
                                Ingredient("salt & pepper", null, null),
                                Ingredient("tabasco/hot sauce ", 3, "drops"),
                                Ingredient("worcestershire sauce", 2, "dashes")
                        ),
                        Uri.parse("https://mixer-logic-p2images.s3.eu-central-1.amazonaws.com/mangoBreeze.jpg"),
                        Glass("On The Rocks"), listOf<Method>(Method("stir")),
                        listOf<Garnish>(Garnish("olives"), Garnish("celery stalk"), Garnish("cucumber")),
                        listOf<Category>(Category("classic"), Category("ordinary drink")),
                        listOf<Alcohol>(Alcohol("vodka"), Alcohol("lime vodka")),
                        listOf<Credit>(Credit("Finlandia Vodka", "image"), Credit("Finlandia Vodka", "recipe")),
                        listOf<Step>(Step("Add the ingredients into the mixer"),
                                Step("Mix and chill together with ice"),
                                Step("Strain into a rocks glass"),
                                Step("garnish with celery and cucumber")
                        ),
                        4
                ),
                Drink("Mini Mary",
                        listOf<Ingredient>(
                                Ingredient("vodka", 4, "cl"),
                                Ingredient("ginger beer", 10, "cl"),
                                Ingredient("fresh lime juice", 2, "cl"),
                                Ingredient("fresh ginger", null, null),
                                Ingredient("chili pepper", null, null)
                        ),
                        Uri.parse("https://mixer-logic-p2images.s3.eu-central-1.amazonaws.com/miniMary.jpg"),
                        Glass("highball"), listOf<Method>(Method("muddle"), Method("build")),
                        listOf<Garnish>(Garnish("olives"), Garnish("lime wedge"), Garnish("cucumber stick")),
                        listOf<Category>(Category("vodka"), Category("cocktail")),
                        listOf<Alcohol>(Alcohol("vodka"), Alcohol("ginger beer")),
                        listOf<Credit>(Credit("Finlandia Vodka", "image"), Credit("Finlandia Vodka", "recipe")),
                        listOf<Step>(Step("Muddle the ginger in a glass with the sliced pepper."),
                                Step("Add the ice, lime juice and ginger beer."),
                                Step("Finally, add the vodka and a lime and fresh chili pepper to garnish")
                        ),
                        5
                ),
                Drink("Mini Sea Breeze",
                        listOf<Ingredient>(
                                Ingredient("vodka", 4, "cl"),
                                Ingredient("dry vermouth", 1, "dash")
                        ),
                        Uri.parse("https://mixer-logic-p2images.s3.eu-central-1.amazonaws.com/miniSeaBreeze.jpg"),
                        Glass("cocktail"), listOf<Method>(Method("stir")),
                        listOf<Garnish>(Garnish("olives"), Garnish("lemon twist")),
                        listOf<Category>(Category("classic"), Category("martini"), Category("cocktail")),
                        listOf<Alcohol>(Alcohol("vodka"), Alcohol("dry vermouth")),
                        listOf<Credit>(Credit("Finlandia Vodka", "image"), Credit("Finlandia Vodka", "recipe")),
                        listOf<Step>(Step("Chill both the martini and mixing glasses"),
                                Step("Pour the vodka, followed by the dry vermouth in an ice-filled mixing glass and stir."),
                                Step("Olive - or twist? Your choice."),
                                Step("Cheers")
                        ),
                        6
                ),
                Drink("Cinnamini",
                        listOf<Ingredient>(
                                Ingredient("vodka", 2, "cl"),
                                Ingredient("lemon juice", 1, "cl"),
                                Ingredient("lime vodka", 2, "cl"),
                                Ingredient("tomato juice", 8, "cl"),
                                Ingredient("salt & pepper", null, null),
                                Ingredient("tabasco/hot sauce ", 3, "drops"),
                                Ingredient("worcestershire sauce", 2, "dashes")
                        ),
                        Uri.parse("https://mixer-logic-p2images.s3.eu-central-1.amazonaws.com/cinnamini.jpg"),
                        Glass("On The Rocks"), listOf<Method>(Method("stir")),
                        listOf<Garnish>(Garnish("olives"), Garnish("celery stalk"), Garnish("cucumber")),
                        listOf<Category>(Category("classic"), Category("ordinary drink")),
                        listOf<Alcohol>(Alcohol("vodka"), Alcohol("lime vodka")),
                        listOf<Credit>(Credit("Finlandia Vodka", "image"), Credit("Finlandia Vodka", "recipe")),
                        listOf<Step>(Step("Add the ingredients into the mixer"),
                                Step("Mix and chill together with ice"),
                                Step("Strain into a rocks glass"),
                                Step("garnish with celery and cucumber")
                        ),
                        7
                ),
                Drink("Caipiroska",
                        listOf<Ingredient>(
                                Ingredient("vodka", 4, "cl"),
                                Ingredient("ginger beer", 10, "cl"),
                                Ingredient("fresh lime juice", 2, "cl"),
                                Ingredient("fresh ginger", null, null),
                                Ingredient("chili pepper", null, null)
                        ),
                        Uri.parse("https://mixer-logic-p2images.s3.eu-central-1.amazonaws.com/caipiroska.jpg"),
                        Glass("highball"), listOf<Method>(Method("muddle"), Method("build")),
                        listOf<Garnish>(Garnish("olives"), Garnish("lime wedge"), Garnish("cucumber stick")),
                        listOf<Category>(Category("vodka"), Category("cocktail")),
                        listOf<Alcohol>(Alcohol("vodka"), Alcohol("ginger beer")),
                        listOf<Credit>(Credit("Finlandia Vodka", "image"), Credit("Finlandia Vodka", "recipe")),
                        listOf<Step>(Step("Muddle the ginger in a glass with the sliced pepper."),
                                Step("Add the ice, lime juice and ginger beer."),
                                Step("Finally, add the vodka and a lime and fresh chili pepper to garnish")
                        ),
                        8
                ),
                Drink("Oriental Caipiroska",
                listOf<Ingredient>(
                        Ingredient("vodka", 4, "cl"),
                        Ingredient("dry vermouth", 1, "dash")
                ),
                Uri.parse("https://mixer-logic-p2images.s3.eu-central-1.amazonaws.com/orientalCaipiroska.jpg.jpg"),
                Glass("cocktail"), listOf<Method>(Method("stir")),
                listOf<Garnish>(Garnish("olives"), Garnish("lemon twist")),
                listOf<Category>(Category("classic"), Category("martini"), Category("cocktail")),
                listOf<Alcohol>(Alcohol("vodka"), Alcohol("dry vermouth")),
                listOf<Credit>(Credit("Finlandia Vodka", "image"), Credit("Finlandia Vodka", "recipe")),
                listOf<Step>(Step("Chill both the martini and mixing glasses"),
                        Step("Pour the vodka, followed by the dry vermouth in an ice-filled mixing glass and stir."),
                        Step("Olive - or twist? Your choice."),
                        Step("Cheers")
                ),
                9
                )
        )
    }
}