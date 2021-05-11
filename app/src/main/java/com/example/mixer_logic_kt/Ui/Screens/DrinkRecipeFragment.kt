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
import coil.load
import com.example.mixer_logic_kt.R
import com.example.mixer_logic_kt.Util.displayNullString
import com.example.mixer_logic_kt.Util.joinWithAnd
import com.example.mixer_logic_kt.databinding.FragmentDrinkRecipeBinding
import com.example.mixer_logic_kt.model.Drink2
import com.example.mixer_logic_kt.testDataSource.SomeDrinks


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DrinkRecipeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DrinkRecipeFragment : Fragment() {

    private var _binding : FragmentDrinkRecipeBinding? = null
    private val binding get() = _binding!!

    private val localDrinks2 = SomeDrinks().loadDrinks2()

    private var drinkId: String = "3"
    private var drink : Drink2? = null//localDrinks2[drinkId.toInt()]

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
            drinkId = it.getString(DRINKID)!!
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        drink = SomeDrinks().loadDrinks2().find { it -> it.id == drinkId }
        // Inflate the layout for this fragment
        _binding = FragmentDrinkRecipeBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.imageView.load(drink!!.imageUrl)
        binding.drinkNameTv.text= drink?.name.toString()
        binding.drinkGarnishTv.text= joinWithAnd(drink?.garnish?.map { t -> "$t".capitalize() }!!)
        binding.drinkGlassTv.text= drink?.glass.toString()
        binding.drinkMethodTv.text=  joinWithAnd(drink?.method?.map { t -> "$t".capitalize() }!!)


        if (true){//dynamically set icon and tint of icon

            binding.likeDrinkImgView.setImageResource(R.drawable.ic_heart_outline)
            ImageViewCompat.setImageTintList(binding.likeDrinkImgView, ColorStateList.valueOf(ContextCompat.getColor(requireContext(),
                R.color.design_default_color_secondary_variant
            )))
        }else{
            binding.likeDrinkImgView.setImageResource(R.drawable.ic_heart_filled)
            ImageViewCompat.setImageTintList(binding.likeDrinkImgView, ColorStateList.valueOf(ContextCompat.getColor(requireContext(),
                R.color.warning_red
            )))

        }

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

    fun addIngredientView(ingredient: List<Any>) {
        val ingredientListLayout: LinearLayout = binding.ingredientsParentLayout
        val ingredientView: View = layoutInflater.inflate(R.layout.recipe_ingredient_layout, null, false)

        val amountTextView : TextView = ingredientView.findViewById(R.id.amount_tv)
        val ingNameTextView : TextView = ingredientView.findViewById(R.id.ing_name_tv)
        amountTextView.text= "${displayNullString(ingredient[1].toString())} ${displayNullString(ingredient[2].toString())}"
        ingNameTextView.text= "${displayNullString(ingredient[0].toString())}"

        ingredientListLayout.addView(ingredientView)
    }


    //render all the steps of the drink
    private fun populateStepViews () {

        val stepsListLayout: LinearLayout = binding.stepsParentLayout
        //val stepTextView: TextView = layoutInflater.inflate(R.layout.step_tv_layout, null) as TextView


        //give the list and index and then use the index with the avtual value to display the step
        drink?.steps?.withIndex()?.map {
            val stepTextView: TextView = layoutInflater.inflate(R.layout.step_tv_layout, null) as TextView
            stepTextView.text= "${it.index + 1}. ${it.value}"

            stepsListLayout.addView(stepTextView)
        }
    }



    companion object {
        const val DRINKID = "drinkId"
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment DrinkRecipeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            DrinkRecipeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}