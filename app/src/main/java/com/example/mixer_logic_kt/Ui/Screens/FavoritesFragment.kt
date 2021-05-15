package com.example.mixer_logic_kt.Ui.Screens

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.observe
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mixer_logic_kt.adapter.FavoritesAdapter
import com.example.mixer_logic_kt.databinding.FragmentFavoritesBinding
import com.example.mixer_logic_kt.model.DrinkViewModel

class FavoritesFragment : Fragment() {
    private var _binding :FragmentFavoritesBinding? = null
    private val binding get() = _binding!!

    private val sharedViewModel: DrinkViewModel by activityViewModels()

    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentFavoritesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        /*binding.toRecipeBtn.setOnClickListener{
   val action = AllDrinksFragmentDirections.actionAllDrinksFragmentToDrinkRecipeFragment()
    binding.root.findNavController().navigate(action)
}*/
        recyclerView = binding.favRecyclerView

        sharedViewModel.favourites.observe(viewLifecycleOwner) { newList ->
            recyclerView.adapter = FavoritesAdapter(requireContext(), newList)
            renderTextOrRecyclerView()
        }

        recyclerView.layoutManager = GridLayoutManager(this.requireContext(), 2)
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "how many favs have been found? ${sharedViewModel.auth.value!!.user.favourites}")
    }

    //show the recyclerview or show text that says there are no favourites
    private fun renderTextOrRecyclerView() {
        if(recyclerView.adapter?.itemCount!! < 1){
            //binding.favRecyclerView.visibility(View.VISIBLE)
            //binding.noFavTv

            binding.favRecyclerView.visibility = View.GONE
            binding.noFavTv.visibility= View.VISIBLE
        }
        else{
            binding.favRecyclerView.visibility = View.VISIBLE
            binding.noFavTv.visibility= View.GONE
        }
    }
}