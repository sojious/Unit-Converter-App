package com.example.unitconverter.ui.splashScreen

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.navigation.fragment.findNavController
import com.example.unitconverter.R
import com.example.unitconverter.databinding.FragmentSplashScreenBinding

@SuppressLint("CustomSplashScreen")
class SplashScreenFragment : Fragment(R.layout.fragment_splash_screen) {
    private val delay: Long = 2000L

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        object : Handler(Looper.getMainLooper()) {
        }.postDelayed({ jumpToWelcomeScreen() }, delay)
    }

    private fun jumpToWelcomeScreen() {
        findNavController().navigate(
            R.id.action_splashScreenFragment3_to_welcomeScreenFragment
        )
    }

}

