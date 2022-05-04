package com.example.unitconverter.ui.conversionScreen

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.example.unitconverter.R
import com.example.unitconverter.databinding.FragmentConversionScreenBinding

class ConversionScreenFragment : Fragment(R.layout.fragment_conversion_screen){
private lateinit var binding: FragmentConversionScreenBinding
lateinit var editText1 : EditText
lateinit var editText2 : EditText
lateinit var customButtonLayout : ConstraintLayout

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        editText1 = view.findViewById(R.id.editText1);

        editText2 = view.findViewById(R.id.editText2);

        customButtonLayout = view.findViewById(R.id.customButtonLayout)

        editText1.setOnClickListener(View.OnClickListener { view ->

            customButtonLayout.isVisible = true
        })
        binding = FragmentConversionScreenBinding.bind(view);


    }


}