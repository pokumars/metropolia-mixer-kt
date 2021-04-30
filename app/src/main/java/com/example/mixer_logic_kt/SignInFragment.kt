package com.example.mixer_logic_kt

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.mixer_logic_kt.databinding.FragmentSignInBinding


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SignInFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SignInFragment : Fragment() {
    private var _binding : FragmentSignInBinding? = null
    private val binding get() = _binding!!

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSignInBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.signInBtn.setOnClickListener{
            //the original style from the code lab
            val action = SignInFragmentDirections.actionSignInFragmentToRecipesTab()
            binding.root.findNavController().navigate(action)
        }

        binding.forgotPasswordActionTextBtn.setOnClickListener{
            //val action = SignInFragmentDirections.actionSignInFragmentToForgotPasswordFragment()
            //binding.root.findNavController().navigate(action)
            Log.d(TAG,"forgotPasswordActionTextBtn clicked")
        }
        binding.registerActionTextBtn.setOnClickListener{
            //val action = SignInFragmentDirections.actionSignInFragmentToForgotPasswordFragment()
            //binding.root.findNavController().navigate(action)
            Log.d(TAG,"registerActionTextBtn clicked")
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SignInFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SignInFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}

/*
1 Correct behaviour and did not have the back arrow after-login problem
 {
	<action
	android:id="@+id/action_forgotPasswordFragment_to_signInFragment"
	app:destination="@id/signInFragment"
	app:popUpToInclusive="true"
	app:popUpTo="@id/signInFragment"/>

******In MainActivity
	val appBarConfig by lazy { AppBarConfiguration(setOf(R.id.startupFragment, R.id.allDrinksFragment, R.id.favoritesFragment, R.id.profileFragment)) }
setupActionBarWithNavController(navController, appBarConfig)


****SignInFragment
	val action2 = SignInFragmentDirections.actionSignInFragmentToAllDrinksFragment2()
	binding.root.findNavController().navigate(action2)


}

2	Also this one Correct behaviour and did not have the back arrow after-login problem
	difference is using the tabs in appBarConfig instead of screen. In this one,
	the subtabs dont get a back button
 {
	<action
	android:id="@+id/action_forgotPasswordFragment_to_signInFragment"
	app:destination="@id/signInFragment"
	app:popUpToInclusive="true"
	app:popUpTo="@id/signInFragment"/>

******In MainActivity
	 val appBarConfig by lazy { AppBarConfiguration(setOf(R.id.startupFragment, R.id.recipes_tab, R.id.favourites_tab, R.id.profile_tab)) }
setupActionBarWithNavController(navController, appBarConfig)

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }


****SignInFragment
	val action2 = SignInFragmentDirections.actionSignInFragmentToAllDrinksFragment2()
	binding.root.findNavController().navigate(action2)


}

*/