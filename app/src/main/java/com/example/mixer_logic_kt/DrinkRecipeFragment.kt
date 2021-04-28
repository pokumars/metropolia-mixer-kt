package com.example.mixer_logic_kt

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.mixer_logic_kt.Util.displayNullString
import com.example.mixer_logic_kt.Util.joinWithAnd
import com.example.mixer_logic_kt.Util.loadImage
import com.example.mixer_logic_kt.databinding.FragmentDrinkRecipeBinding
import com.example.mixer_logic_kt.model.Drink
import com.example.mixer_logic_kt.model.Ingredient
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

    private var drinkId: Int = 1
    private var drink : Drink? =null

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
            drinkId = it.getInt(DRINKID)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        drink = SomeDrinks().loadDrinks().find { it -> it.id == drinkId }
        // Inflate the layout for this fragment
        _binding = FragmentDrinkRecipeBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.imageView.loadImage(drink!!.imageUrl)
        binding.drinkNameTv.text= drink?.name.toString()
        binding.drinkGarnishTv.text= joinWithAnd(drink?.garnish?.map { t -> "$t".capitalize() }!!)
        binding.drinkGlassTv.text= drink?.glass.toString()
        binding.drinkMethodTv.text=  joinWithAnd(drink?.method?.map { t -> "$t".capitalize() }!!)

        drink?.ingredients?.forEach {
            addIngredientView(it);
        }

        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun addIngredientView(ingredient: Ingredient) {
        val ingredientListLayout: LinearLayout = binding.ingredientsParentLayout
        val ingredientView: View = layoutInflater.inflate(R.layout.recipe_ingredient_layout, null, false)

        val amountTextView : TextView = ingredientView.findViewById(R.id.amount_tv)
        val ingNameTextView : TextView = ingredientView.findViewById(R.id.ing_name_tv)



        amountTextView.text= "${displayNullString(ingredient.amount.toString())} ${displayNullString(ingredient.unitOfMeasurement)}"
        ingNameTextView.text= "${displayNullString(ingredient.item)}"

        ingredientListLayout.addView(ingredientView)

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