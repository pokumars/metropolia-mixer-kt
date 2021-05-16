package com.example.mixer_logic_kt.Ui.Auth

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.observe
import androidx.navigation.findNavController
import com.example.mixer_logic_kt.R
import com.example.mixer_logic_kt.Ui.Screens.TAG
import com.example.mixer_logic_kt.databinding.FragmentStartupBinding
import com.example.mixer_logic_kt.model.DrinkViewModel

class StartupFragment : Fragment() {
    private var _binding : FragmentStartupBinding? = null
    private val binding get() = _binding!!

    private val sharedViewModel: DrinkViewModel by activityViewModels()

    private lateinit var sharedPref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPref= requireActivity().getPreferences(Context.MODE_PRIVATE)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       _binding = FragmentStartupBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //after startup check for token and if it exists log user in.
        checkForToken()
        observeUserExistence()

        binding.toSignInBtn.setOnClickListener{
            val action = StartupFragmentDirections.actionStartupFragmentToSignInFragment()
            binding.root.findNavController().navigate(action)
        }

        binding.asGuestBtn.setOnClickListener{
            val action = StartupFragmentDirections.actionStartupFragmentToGuestWebViewFragment()
            binding.root.findNavController().navigate(action)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun checkForToken(){
        //shows loading spinner by default
        val token = sharedPref.getString(getString(R.string.cles_du_tresor), "")
        Log.d(TAG, "token.isNullOrEmpty() ${token.isNullOrEmpty()} $token")

        if (!token.isNullOrEmpty()){
            //if token exists, try to get user data and then enter app
            sharedViewModel.getUserWithToken(token)
        }
        else{
            //stop showing loading spinner and show the buttons
            showAppEntranceButtons ()
            Log.d(TAG, "Token does not exist")
        }
    }

    private fun observeUserExistence() {
        //Log.d(TAG, "observeUserExistence, sharedViewModel.auth ${sharedViewModel.auth.value}")
        //observe whether user exists or not and let user into app based on that
        //as soon as the user is gotten from the backend based on the existing token
        sharedViewModel.auth.observe(viewLifecycleOwner) { authObj ->
            if (authObj.user.id.isNotEmpty()) {

                //Log.d(TAG, "user gotten from the backend based on the existing token")
                //navigate into the app
                val action = StartupFragmentDirections.actionStartupFragmentToRecipesTab()
                binding.root.findNavController().navigate(action)
            }
        }
    }

    private fun showAppEntranceButtons (){
        //stop showing loading spinner and show the buttons
        binding.startupLoadingLayout.visibility= View.GONE
        binding.appEntranceButtons.visibility = View.VISIBLE
    }
}