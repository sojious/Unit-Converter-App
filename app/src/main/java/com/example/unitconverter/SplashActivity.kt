package com.example.unitconverter

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.example.unitconverter.databinding.ActivitySplashBinding
import com.example.unitconverter.util.secondToMillisecond

class SplashActivity : AppCompatActivity() {
    private var _binding: ActivitySplashBinding? = null
    private val binding get() = _binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        startAnimation()
        object : Handler(Looper.getMainLooper()) {}
            .postDelayed({ goToMainActivity() }, 1.0.secondToMillisecond())
    }

    private fun startAnimation() {
        binding?.SplashScreenImage?.apply {
            alpha = 0f
            visibility = View.VISIBLE
            animate().alpha(0.7f).setDuration(3.0.secondToMillisecond())
                .setListener(null)

            Thread.sleep(1.0.secondToMillisecond())

            alpha = 0.7f
            visibility = View.VISIBLE
            animate().alpha(1f).setDuration(3.0.secondToMillisecond())
                .setListener(null)
            Thread.sleep(1.0.secondToMillisecond())

        }
    }

    private fun goToMainActivity() {
        startActivity(
            Intent(
                this,
                MainActivity::class.java
            )
        )
        finish()
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

}