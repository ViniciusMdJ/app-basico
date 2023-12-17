package com.example.aplicativoteste.UI.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.aplicativoteste.databinding.ActivityMainBinding
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.aplicativoteste.R

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setToolbar()
    }

    private fun setToolbar() {
        val navHostFrag = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        var navController = navHostFrag.navController
        val appBarConfiguration = AppBarConfiguration(navController.graph)
        binding.toolbar.setupWithNavController(navController, appBarConfiguration)
    }

}