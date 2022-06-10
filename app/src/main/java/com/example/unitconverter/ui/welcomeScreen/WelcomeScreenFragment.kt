package com.example.unitconverter.ui.welcomeScreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.unitconverter.R
import com.example.unitconverter.adapters.WelcomeScreenConversionsAdapter
import com.example.unitconverter.data.ConversionData
import com.example.unitconverter.databinding.FragmentWelcomeScreenBinding
import com.example.unitconverter.model.ConversionItem

class WelcomeScreenFragment : Fragment() {
    private var _binding: FragmentWelcomeScreenBinding? = null
    private val binding get() = _binding
    private lateinit var conversionAdapter: WelcomeScreenConversionsAdapter
    private lateinit var items: List<ConversionItem>
    private lateinit var clickedConversionItem: ConversionItem


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWelcomeScreenBinding.inflate(inflater, container, false)
        items = ConversionData.items
        loadConversionData()
        return binding?.root
    }

    override fun onResume() {
        super.onResume()
        loadConversionData()
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
