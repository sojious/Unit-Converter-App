package com.example.unitconverter.ui.conversionScreen

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.unitconverter.R
import com.example.unitconverter.databinding.FragmentConversionScreenBinding

class ConversionScreenFragment : Fragment(R.layout.fragment_conversion_screen){

    private lateinit var binding: FragmentConversionScreenBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
   binding = FragmentConversionScreenBinding.bind(view)

    }
}