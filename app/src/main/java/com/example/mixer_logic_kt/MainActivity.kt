package com.example.mixer_logic_kt

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.mixer_logic_kt.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager
            .findFragmentById((R.id.nav_host_fragment)) as NavHostFragment
        navController = navHostFragment.navController

        val appBarConfig by lazy { AppBarConfiguration(setOf(R.id.startupFragment, R.id.recipes_tab, R.id.favourites_tab, R.id.profile_tab)) }

        setupActionBarWithNavController(navController, appBarConfig)

        NavigationUI.setupWithNavController(binding.bottomNavigationView, navController)

        navController.addOnDestinationChangedListener{_, destination, _ ->
            if(destination.id == R.id.signInFragment ||  destination.id == R.id.startupFragment ||
                destination.id == R.id.registerFragment || destination.id == R.id.forgotPasswordFragment ){
                binding.bottomNavigationView.visibility = View.GONE
            }else{
                binding.bottomNavigationView.visibility = View.VISIBLE
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}

/*
       val appBarConfig by lazy { AppBarConfiguration(setOf(R.id.startupFragment, R.id.allDrinksFragment, R.id.favoritesFragment, R.id.profileFragment)) }
       setupActionBarWithNavController(navController, appBarConfig)*/

/*
// Correct behaviour and did not have the back arrow thing; difference is using the tabs top level
//instead of screen. In this one,	the subtabs dont get a back button
val appBarConfig by lazy { AppBarConfiguration(setOf(R.id.startupFragment, R.id.recipes_tab, R.id.favourites_tab, R.id.profile_tab)) }
setupActionBarWithNavController(navController, appBarConfig)*/