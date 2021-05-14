package com.example.mixer_logic_kt.Ui.Auth

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.observe
import androidx.navigation.findNavController
import com.example.mixer_logic_kt.Ui.Screens.TAG
import com.example.mixer_logic_kt.Util.hideKeyboardInFragment
import com.example.mixer_logic_kt.databinding.FragmentSignInBinding
import com.example.mixer_logic_kt.model.DrinkViewModel
import com.example.mixer_logic_kt.model.LoginRequestObj


class SignInFragment : Fragment() {
    private val sharedViewModel: DrinkViewModel by activityViewModels()

    private var _binding : FragmentSignInBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSignInBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.signInBtn.setOnClickListener{
            val username:String = binding.editTextUsername.text.toString()
            val password:String =  binding.editTextPassword.text.toString()
            val userCredentials = LoginRequestObj(username, password)

            try {
                hideKeyboardInFragment(requireContext(), it)
                sharedViewModel.login(userCredentials)
            }catch (e: Exception){
                Log.d(TAG,"Login failed --> $e")
            }
        }

        observeUserExistence()
        observeSignInErrorMsg()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun observeUserExistence() {
        //observe whether user exists or not and let user into app based on that
        sharedViewModel.auth.observe(viewLifecycleOwner) { authObj ->
            if (authObj.user.id.isNotEmpty()) {
                Log.d(TAG, "Setting _auth as the auth response obj")
                val action =
                        SignInFragmentDirections.actionSignInFragmentToRecipesTab()
                binding.root.findNavController().navigate(action)
            }
        }
    }

    private fun observeSignInErrorMsg() {
        sharedViewModel.signInErrorMessage.observe(viewLifecycleOwner) { errorMsg ->
            binding.signInErrorMessage.text = errorMsg
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