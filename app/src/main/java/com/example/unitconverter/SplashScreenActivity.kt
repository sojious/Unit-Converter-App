package com.example.unitconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.navigation.fragment.findNavController

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        //hide the status bar and bottom navigation bar
        hideSystemBars()

        //Delay the transition to the welcome screen by 2 seconds
        object : Handler(Looper.getMainLooper()) {

        }.postDelayed(object : Runnable {
            override fun run() {
                goToWelcomeScreen()
                finish()

            }
        },2000)

    }

    private fun goToWelcomeScreen() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.splash_fragment_container)
        navHostFragment?.findNavController()?.navigate(R.id.action_splashScreenFragment_to_mainActivity)
    }

    private fun hideSystemBars() {
        val windowInsetsController =
            ViewCompat.getWindowInsetsController(findViewById(R.id.splash_fragment_container)) ?: return
        windowInsetsController.systemBarsBehavior =
            WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        windowInsetsController.hide(WindowInsetsCompat.Type.systemBars())
    }
}