package com.example.unitconverter.ui.welcomeScreen

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.unitconverter.R
import com.example.unitconverter.adapters.WelcomeScreenConversionsAdapter
import com.example.unitconverter.data.ConversionData
import com.example.unitconverter.databinding.FragmentWelcomeScreenBinding
import com.example.unitconverter.model.ConversionItem

class WelcomeScreenFragment : Fragment(R.layout.fragment_welcome_screen) {
    private lateinit var binding: FragmentWelcomeScreenBinding
    private lateinit var conversionAdapter: WelcomeScreenConversionsAdapter
    private lateinit var items: List<ConversionItem>


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentWelcomeScreenBinding.bind(view)
        loadConversionData()
    }

    private fun loadConversionData() {
        items = ConversionData.items
        conversionAdapter = WelcomeScreenConversionsAdapter()
        conversionAdapter.submitList(items)
        binding.WelcomeScreenRecyclerView.adapter = conversionAdapter
        binding.WelcomeScreenRecyclerView.layoutManager =
            GridLayoutManager(activity, 3)
    }
}