package com.example.mixer_logic_kt.Ui.Screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mixer_logic_kt.adapter.FavoritesAdapter
import com.example.mixer_logic_kt.databinding.FragmentFavoritesBinding
import com.example.mixer_logic_kt.testDataSource.SomeDrinks

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

    private lateinit var recyclerView: RecyclerView
    private val drinks = SomeDrinks().loadNoDrinks() //SomeDrinks().loadDrinks()
    private lateinit var  adapter: FavoritesAdapter

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

        adapter = FavoritesAdapter(requireContext(), drinks)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentFavoritesBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
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

        recyclerView.adapter = adapter//FavoritesAdapter(requireContext(), drinks)
        recyclerView.layoutManager = GridLayoutManager(this.requireContext(), 2)

        renderTextOrRecyclerView()
        // Use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true)
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