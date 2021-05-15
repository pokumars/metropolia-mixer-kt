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

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [StartupFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class StartupFragment : Fragment() {
    private var _binding : FragmentStartupBinding? = null
    private val binding get() = _binding!!

    private val sharedViewModel: DrinkViewModel by activityViewModels()


    private lateinit var sharedPref: SharedPreferences

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

        sharedPref= requireActivity().getPreferences(Context.MODE_PRIVATE)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       _binding = FragmentStartupBinding.inflate(inflater, container, false)

        observeUserExistence()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.toSignInBtn.setOnClickListener{
            val action = StartupFragmentDirections.actionStartupFragmentToSignInFragment()
            binding.root.findNavController().navigate(action)
        }

        binding.asGuestBtn.setOnClickListener{
            val action = StartupFragmentDirections.actionStartupFragmentToGuestWebViewFragment()
            binding.root.findNavController().navigate(action)
        }

        //after startup check for token and if it exists log user in.
        checkForToken()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun checkForToken(){
        val token = sharedPref.getString(getString(R.string.cles_du_tresor), "")
        Log.d(TAG, "token.isNullOrEmpty() ${token.isNullOrEmpty()} $token")
        //shows loading spinner by default

        if (!token.isNullOrEmpty()){//if token exists
            //try to get user data and then enter app
            sharedViewModel.getUserWithToken(token)
            observeUserExistence()

        }else{
            //stop showing loading spinner and show the buttons
            binding.startupLoadingLayout.visibility= View.GONE
            binding.appEntranceButtons.visibility = View.VISIBLE
            Log.d(TAG, "Token does not exist")
        }
    }

    private fun observeUserExistence() {
        Log.d(TAG, "observeUserExistence, sharedViewModel.auth ${sharedViewModel.auth.value}")
        //observe whether user exists or not and let user into app based on that
        //as soon as the user is gotten from the backend based on the existing token
        sharedViewModel.auth.observe(viewLifecycleOwner) { authObj ->
            if (authObj.user.id.isNotEmpty()) {

                Log.d(TAG, "user gotten from the backend based on the existing token")
                //navigate into the app

                val action = StartupFragmentDirections.actionStartupFragmentToRecipesTab()
                binding.root.findNavController().navigate(action)
            }
        }
    }

    companion object {
        fun newInstance(param1: String, param2: String) =
            StartupFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}