package com.example.mixer_logic_kt.Ui.Screens

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.observe
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mixer_logic_kt.adapter.DrinkAdapter
import com.example.mixer_logic_kt.databinding.FragmentAllDrinksBinding
import com.example.mixer_logic_kt.model.Drink2
import com.example.mixer_logic_kt.model.DrinkViewModel

class AllDrinksFragment : Fragment() {
    private var _binding : FragmentAllDrinksBinding? = null
    private val binding get() = _binding!!
    private var allDrinks: List<Drink2> = listOf()


    private val sharedViewModel: DrinkViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
         _binding = FragmentAllDrinksBinding.inflate(inflater, container, false)
        sharedViewModel.drinks.observe(viewLifecycleOwner) { newList ->  allDrinks= newList }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView: RecyclerView = binding.recyclerView

        //recyclerView.adapter = DrinkAdapter(requireContext(), allDrinks)
        sharedViewModel.drinks.observe(viewLifecycleOwner) { newList ->
            recyclerView.adapter = DrinkAdapter(requireContext(), newList)
        }
        //binding.drinkSearchEditText.
        binding.drinkSearchEditText.addTextChangedListener(textWatcher)

        recyclerView.layoutManager = GridLayoutManager(this.requireContext(), 2)
    }

    private fun findDrinksByName (drinksArr: List<Drink2>, searchText:String): List<Drink2>  {
        Log.d(TAG, "drinksArr = ${drinksArr.size}")
        return drinksArr.filter{ currDrink -> currDrink.name.toLowerCase().contains(searchText)}
    }

    private val textWatcher = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {}
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(str: CharSequence?, start: Int, before: Int, count: Int) {
            binding.recyclerView.adapter =
                    DrinkAdapter(
                            requireContext(),
                            findDrinksByName(sharedViewModel.drinks.value!!, str.toString())
                    )
        }
    }
}

//(currDrink => currDrink.name.toLowerCase().indexOf(searchText.toLowerCase()) !== -1);