package com.example.unitconverter.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.unitconverter.R
import com.example.unitconverter.databinding.ConversionItemLayoutBinding
import com.example.unitconverter.model.ConversionItem
import com.example.unitconverter.util.WelcomeScreenConversionInterface

class WelcomeScreenConversionsAdapter(
    private var clickInterface: WelcomeScreenConversionInterface
) :
    ListAdapter<ConversionItem, WelcomeScreenConversionsAdapter.ViewHolder>(
        DiffCallback()
    ) {

    class ViewHolder(
        private val binding: ConversionItemLayoutBinding,
        private val clickInterface: WelcomeScreenConversionInterface
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(conversionItem: ConversionItem) {
            binding.ConversionItemName.text = conversionItem.conversionName
        }
    }


    private class DiffCallback : DiffUtil.ItemCallback<ConversionItem>() {
        override fun areItemsTheSame(oldItem: ConversionItem, newItem: ConversionItem): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: ConversionItem, newItem: ConversionItem): Boolean {
            return oldItem.conversionName == newItem.conversionName
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ConversionItemLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            clickInterface
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            bind(getItem(position))
            itemView.setOnClickListener {
                clickInterface.goToConversionScreen(position)
            }
        }
    }
}