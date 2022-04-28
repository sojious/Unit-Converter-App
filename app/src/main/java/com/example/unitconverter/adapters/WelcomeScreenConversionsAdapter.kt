package com.example.unitconverter.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.unitconverter.R
import com.example.unitconverter.databinding.ConversionItemLayoutBinding
import com.example.unitconverter.model.ConversionItem
import com.example.unitconverter.util.InterfaceWelcomeScreenConversion

class WelcomeScreenConversionsAdapter :
    ListAdapter<ConversionItem, WelcomeScreenConversionsAdapter.ViewHolder>(
        DiffCallback()
    ) {

    class ViewHolder(
        private val binding: ConversionItemLayoutBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener { view ->
                //todo go to ConversionScreen
            }
        }

        fun bind(conversionItem: ConversionItem) {
            with(binding) {
                binding.ConversionItemName.text = conversionItem.conversionName
            }
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
                parent.findViewById(R.id.ConversionItemParent),
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}