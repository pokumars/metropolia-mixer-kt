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

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FavoritesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FavoritesFragment : Fragment() {
    private var _binding :FragmentFavoritesBinding? = null
    private val binding get() = _binding!!

    private val sharedViewModel: DrinkViewModel by activityViewModels()

    private lateinit var recyclerView: RecyclerView

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
        //sharedViewModel.setFavourites()
        //adapter = FavoritesAdapter(requireContext(), drinks)
    }

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
        Log.d(TAG, "hwo many favs have been found? ${sharedViewModel.auth.value!!.user.favourites}")
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


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FavoritesFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FavoritesFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}