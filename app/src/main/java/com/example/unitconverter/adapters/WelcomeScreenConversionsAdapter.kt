package com.example.unitconverter.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.unitconverter.R
import com.example.unitconverter.data.ConversionData
import com.example.unitconverter.databinding.ConversionItemLayoutBinding
import com.example.unitconverter.model.ConversionItem
import com.example.unitconverter.util.WelcomeScreenConversionInterface
import com.google.android.material.textview.MaterialTextView

class WelcomeScreenConversionsAdapter(
    private val items: List<ConversionItem>,
    val callback: (ConversionItem) -> Unit
) :
    RecyclerView.Adapter<WelcomeScreenConversionsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ConversionItemLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            bind(items[position])
        }
    }


    inner class ViewHolder(
        val binding: ConversionItemLayoutBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(conversionItem: ConversionItem) {
            binding.ConversionItemName.text = conversionItem.conversionName
            itemView.setOnClickListener { callback(conversionItem) }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }


}