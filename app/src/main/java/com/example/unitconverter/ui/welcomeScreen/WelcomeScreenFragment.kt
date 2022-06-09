package com.example.unitconverter.ui.welcomeScreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.unitconverter.R
import com.example.unitconverter.adapters.WelcomeScreenConversionsAdapter
import com.example.unitconverter.data.ConversionData
import com.example.unitconverter.databinding.FragmentWelcomeScreenBinding
import com.example.unitconverter.model.ConversionItem
import com.example.unitconverter.util.WelcomeScreenConversionInterface

class WelcomeScreenFragment : Fragment() {
    private var _binding: FragmentWelcomeScreenBinding? = null
    private val binding get() = _binding
    private lateinit var conversionAdapter: WelcomeScreenConversionsAdapter
    private var items: List<ConversionItem> = ConversionData.items
    private lateinit var clickedConversionItem: ConversionItem


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWelcomeScreenBinding.inflate(inflater, container, false)

        loadConversionData()
        return binding?.root
    }


    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    private fun loadConversionData() {
        binding?.WelcomeScreenRecyclerView?.layoutManager =
            GridLayoutManager(activity, 3)
        conversionAdapter = WelcomeScreenConversionsAdapter(items) {
            clickedConversionItem = it
            val navigationAction = WelcomeScreenFragmentDirections
                .actionWelcomeScreenFragmentToConversionScreenFragment(clickedConversionItem)
            findNavController().navigate(navigationAction)
            Toast.makeText(activity, "Testing Toast", Toast.LENGTH_SHORT).show()
        }

        binding?.WelcomeScreenRecyclerView?.adapter = conversionAdapter

    }

}
