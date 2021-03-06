package com.example.mixer_logic_kt.Ui.Screens

import android.content.res.ColorStateList
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.widget.ImageViewCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.observe
import coil.load
import com.example.mixer_logic_kt.R
import com.example.mixer_logic_kt.Util.joinWithAnd
import com.example.mixer_logic_kt.databinding.FragmentDrinkRecipeBinding
import com.example.mixer_logic_kt.model.Drink2
import com.example.mixer_logic_kt.model.DrinkViewModel


class DrinkRecipeFragment : Fragment() {
    private val sharedViewModel: DrinkViewModel by activityViewModels()

    private var _binding : FragmentDrinkRecipeBinding? = null
    private val binding get() = _binding!!

    private var drinkId: String = "3"
    private var drink : Drink2? = null//localDrinks2[drinkId.toInt()]


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            drinkId = it.getString(DRINKID)!!
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        drink = sharedViewModel.drinks.value?.find { it -> it.id == drinkId }

        // Inflate the layout for this fragment
        _binding = FragmentDrinkRecipeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.imageView.load(drink?.imageUrl)
        binding.drinkNameTv.text= drink?.name.toString()
        binding.drinkGarnishTv.text= joinWithAnd(drink?.garnish?.map { t -> t.capitalize() }!!)
        binding.drinkGlassTv.text= drink?.glass.toString()
        binding.drinkMethodTv.text=  joinWithAnd(drink?.method?.map { t -> t.capitalize() }!!)

        observeFavourites()
        populateStepViews ()

        drink?.ingredients?.forEach {
            addIngredientView(it);
        }
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun addIngredientView(ingredient: List<Any>) {
        val ingredientListLayout: LinearLayout = binding.ingredientsParentLayout
        val ingredientView: View = layoutInflater.inflate(R.layout.recipe_ingredient_layout, null, false)

        //handle scenario when amount or unit is null
        val amount: String = if (ingredient[1] != null) ingredient[1].toString().substringBefore(".") else ""
        val unitOfMeasurement: String = if (ingredient[2] != null) ingredient[2].toString() else ""

        val amountTextView : TextView = ingredientView.findViewById(R.id.amount_tv)
        val ingNameTextView : TextView = ingredientView.findViewById(R.id.ing_name_tv)

        amountTextView.text= "$amount $unitOfMeasurement"
        ingNameTextView.text= ingredient[0].toString()

        ingredientListLayout.addView(ingredientView)
    }


    //render all the steps of the drink
    private fun populateStepViews () {

        val stepsListLayout: LinearLayout = binding.stepsParentLayout

        //give the list and index and then use the index with the avtual value to display the step
        drink?.steps?.withIndex()?.map {
            val stepTextView: TextView = layoutInflater.inflate(R.layout.step_tv_layout, null) as TextView
            stepTextView.text= "${it.index + 1}. ${it.value}"

            stepsListLayout.addView(stepTextView)
        }
    }

    private fun observeFavourites(){
        sharedViewModel.auth.observe(viewLifecycleOwner) { _ ->
            sharedViewModel.setFavourites()
            setFavIconAndLikeFunction()
        }
    }

    private fun setFavIconAndLikeFunction() {
        if (sharedViewModel.auth.value!!.user.favourites.contains(drink?.id)){ //if it is a favourite
            binding.likeDrinkImgView.setImageResource(R.drawable.ic_heart_filled)
            ImageViewCompat.setImageTintList(binding.likeDrinkImgView, ColorStateList.valueOf(ContextCompat.getColor(requireContext(),
                    R.color.warning_red
            )))
            binding.likeDrinkImgView.setOnClickListener{sharedViewModel.unlikeDrink(drinkId, sharedViewModel.auth.value!!.token)}
        }
        else{
            //dynamically set icon and tint of icon
            binding.likeDrinkImgView.setImageResource(R.drawable.ic_heart_outline)
            ImageViewCompat.setImageTintList(binding.likeDrinkImgView, ColorStateList.valueOf(ContextCompat.getColor(requireContext(),
                    R.color.design_default_color_secondary_variant
            )))
            binding.likeDrinkImgView.setOnClickListener{sharedViewModel.likeDrink(drinkId, sharedViewModel.auth.value!!.token)}
        }
    }


    companion object {
        const val DRINKID = "drinkId"
    }
}