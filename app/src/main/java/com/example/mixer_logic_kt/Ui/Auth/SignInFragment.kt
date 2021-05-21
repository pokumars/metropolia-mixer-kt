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
import com.example.mixer_logic_kt.Util.hideKeyboardInFragment
import com.example.mixer_logic_kt.databinding.FragmentSignInBinding
import com.example.mixer_logic_kt.model.DrinkViewModel
import com.example.mixer_logic_kt.model.LoginRequestObj


class SignInFragment : Fragment() {
    private val sharedViewModel: DrinkViewModel by activityViewModels()

    private lateinit var sharedPref: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor

    private var _binding : FragmentSignInBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPref= requireActivity().getPreferences(Context.MODE_PRIVATE)
        editor= sharedPref.edit()
    }

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
                //at this point, the user is existing so we persist the token
                saveToken(authObj.token)
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

    private fun saveToken(token: String) {
        editor.putString(getString(R.string.cles_du_tresor), token)
        editor.apply()
    }
}
