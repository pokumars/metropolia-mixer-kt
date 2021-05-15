package com.example.mixer_logic_kt.Ui.Screens

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.example.mixer_logic_kt.R
import com.example.mixer_logic_kt.databinding.FragmentProfileBinding
import com.example.mixer_logic_kt.model.DrinkViewModel

const val TAG = "MainActivity"

class ProfileFragment : Fragment() {
    private val sharedViewModel: DrinkViewModel by activityViewModels()

    private var _binding : FragmentProfileBinding? = null
    private val binding get() = _binding!!

    private lateinit var sharedPref: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor

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
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.logOutTv.setOnClickListener{
            Log.d(TAG, "user clicked log out")
            clearToken()
            logOut()
            //move to startup page and clear backstack
        }
    }

    private fun clearToken() {
        editor.putString(getString(R.string.cles_du_tresor), "")
        editor.commit()
    }
    private fun logOut() {
        sharedViewModel.wipeUser()
        val action = ProfileFragmentDirections.actionProfileFragmentToStartupFragment()
        binding.root.findNavController().navigate(action)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}