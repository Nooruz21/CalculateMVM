package com.example.lovecalculate

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.lovecalculate.Prefs.Prefs
import com.example.lovecalculate.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    @Inject
    var prefs: Prefs? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navController = findNavController(R.id.nav_host_fragment)

        prefs?.saveState();


        if (!Prefs(this).isShown()) {
            navController.navigate(R.id.boardFragment)
        }
    }
}