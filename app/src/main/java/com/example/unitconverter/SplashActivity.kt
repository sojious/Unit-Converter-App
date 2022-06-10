package com.example.unitconverter

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
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
            .postDelayed({ goToMainActivity() }, 3.0.secondToMillisecond())
    }

    private fun startAnimation() {
        binding?.SplashScreenImage?.apply {
            alpha = 0f
            visibility = View.VISIBLE
            animate().alpha(0.7f).setDuration(3.0.secondToMillisecond())
                .setListener(null)

            Thread.sleep(3.0.secondToMillisecond())

            alpha = 0.7f

            animate().alpha(0f).setDuration(2.0.secondToMillisecond())
                .setListener(object : AnimatorListenerAdapter() {
                    override fun onAnimationEnd(animation: Animator?, isReverse: Boolean) {
                        visibility = View.GONE
                    }
                })
        }
    }

    private fun goToMainActivity() {
        startActivity(
            Intent(
                this,
                MainActivity::class.java
            )
        )
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}