package com.example.unitconverter.ui.conversionScreen

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.example.unitconverter.R
import com.example.unitconverter.data.CurrencyDb
import com.example.unitconverter.databinding.FragmentConversionScreenBinding
import com.example.unitconverter.model.ConversionType
import com.example.unitconverter.model.ConversionUnit
import com.example.unitconverter.util.ConversionBoxView
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class ConversionScreenFragment :
    Fragment(R.layout.fragment_conversion_screen) {


    private var _binding: FragmentConversionScreenBinding? = null
    private val binding get() = _binding
    private var data: List<ConversionUnit> = listOf()
    private var conversionBox1: ConversionBoxView? = null
    private var conversionBox2: ConversionBoxView? = null

    private var currentConversionUnit1: ConversionUnit? = null
    private var currentConversionUnit2: ConversionUnit? = null
    private val TAG = "ConversionFragment"

    private var convertedText: Double? = null

    private val args: ConversionScreenFragmentArgs? by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentConversionScreenBinding
            .inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        data = DataFactory.getData(
            requireContext(),
            args?.conversionItem?.conversionName
        )

        conversionBox1 = binding?.ConversionBox1
        conversionBox2 = binding?.ConversionBox2

        currentConversionUnit1 = conversionBox1?.currentUnitItem
        currentConversionUnit2 = conversionBox2?.currentUnitItem

        conversionBox1?.configureSpinner(requireContext(), data)
        conversionBox2?.configureSpinner(requireContext(), data)
        conversionBox1?.setConversionTextSize(42f)

        lifecycleScope.launch {
            processConversions()
        }


    }

    private fun processConversions() {
        conversionBox1?.getTextField()?.onFocusChangeListener =
            View.OnFocusChangeListener { view, hasFocus ->
                if (hasFocus) {
                    conversionBox1?.getTextField()?.addTextChangedListener(
                        onTextChanged = { text, _, _, _ ->
                            convertedText = if (text.toString() == "") 0.0 else {
                                text.toString()
                                    .convert(
                                        conversionBox1?.currentUnitItem!!,
                                        conversionBox2?.currentUnitItem!!
                                    ).toDouble()
                            }
                            Log.i(TAG, "onTextChanged")
                            conversionBox2?.setConversionTextField(
                                if (convertedText != null) convertedText.toString() else ""
                            )
                        },
                        afterTextChanged = {
                            Log.i(TAG, "afterTextChanged")
                        }
                    )
                }
            }

        conversionBox2?.getTextField()?.onFocusChangeListener =
            View.OnFocusChangeListener { view, hasFocus ->
                if (hasFocus) {
                    conversionBox2?.getTextField()?.addTextChangedListener(
                        onTextChanged = { text, _, _, _ ->
                            convertedText = if (text.toString() == "") 0.0 else {
                                text.toString()
                                    .convert(
                                        conversionBox2?.currentUnitItem!!,
                                        conversionBox1?.currentUnitItem!!
                                    ).toDouble()
                            }
                            Log.i(TAG, "onTextChanged")
                            conversionBox1?.setConversionTextField(
                                if (convertedText != null) convertedText.toString() else ""
                            )
                        },
                        afterTextChanged = {
                            Log.i(TAG, "afterTextChanged")
                        }
                    )
                }
            }
    }

    override fun onDestroyView() {
        _binding = null
        convertedText = null
        super.onDestroyView()
    }

}

class DataFactory {
    companion object {
        fun getData(
            context: Context,
            conversionName: String?
        ): List<ConversionUnit> {
            var units = listOf<ConversionUnit>()

            units = when (conversionName) {
                ConversionType.Currency.name -> {
                    CurrencyDb.currencies(context)
                }
                ConversionType.Length.name -> {
                    //todo
                    emptyList()
                }
                ConversionType.Area.name -> {
                    //todo
                    emptyList()
                }
                else -> emptyList()
            }
            return units
        }
    }
}


fun Double.convert(from: ConversionUnit, to: ConversionUnit): Double {
    val isValid = from::class == to::class
    if (isValid) {
        return this * (to.rate / from.rate)
    }
    return 0.0
}

fun String.convert(from: ConversionUnit, to: ConversionUnit): String {
    return this.toDouble().convert(from, to).toString()
}


//        zero.setOnClickListener(View.OnClickListener { view ->
//
//            if (yellow) addValue2(resources.getString(R.string.zero))
//            else
//                addValue(resources.getString(R.string.zero))
//        })
//
//
//        one.setOnClickListener(View.OnClickListener { view ->
//            if (yellow)
//                addValue2(resources.getString(R.string.one))
//            else addValue(resources.getString(R.string.one))
//
//        })
//
//        two.setOnClickListener(View.OnClickListener { view ->
//            if (yellow) addValue2(resources.getString(R.string.two))
//            else addValue(resources.getString(R.string.two))
//        })
//
//        three.setOnClickListener(View.OnClickListener { view ->
//            if (yellow) addValue2(resources.getString(R.string.three))
//            else addValue(resources.getString(R.string.three))
//
//        })
//
//        four.setOnClickListener(View.OnClickListener { view ->
//            if (yellow) addValue2(resources.getString(R.string.four))
//            else addValue(resources.getString(R.string.four))
//        })
//
//        five.setOnClickListener(View.OnClickListener { view ->
//            if (yellow) addValue2(resources.getString(R.string.five))
//            else addValue(resources.getString(R.string.five))
//
//        })
//
//        six.setOnClickListener(View.OnClickListener { view ->
//            if (yellow) addValue2(resources.getString(R.string.six))
//            else addValue(resources.getString(R.string.six))
//
//        })
//
//        seven.setOnClickListener(View.OnClickListener { view ->
//            if (yellow) addValue2(resources.getString(R.string.seven))
//            else addValue("7")
//
//        })
//
//        eight.setOnClickListener(View.OnClickListener { view ->
//            if (yellow) addValue2(resources.getString(R.string.eight))
//            else addValue("8")
//
//        })
//
//        nine.setOnClickListener(View.OnClickListener { view ->
//            if (yellow) addValue2(resources.getString(R.string.nine))
//            else addValue("9")
//        })
//
//        clear.setOnClickListener(View.OnClickListener { view ->
//            if (yellow) addValue2("")
//            else addValue("")
//
//        })
//        editText1.showSoftInputOnFocus = false;
//
//        editText2.showSoftInputOnFocus = false;
//
//        customButtonLayout = view.findViewById(R.id.customButtonLayout)
//
//        //editText1.setOnClickListener{}
//
//
//        editText1.setOnClickListener(View.OnClickListener { view ->
//
//            yellow = false
//
//            customButtonLayout.isVisible = true
//
//            if (getString(R.string.editText1).equals(editText1.text.toString())) {
//
//                editText1.setText("");
//            }
//
//        })
//
//
//
//        binding = FragmentConversionScreenBinding.bind(view);
//
//
//        editText2.setOnClickListener(View.OnClickListener { view ->
//
//            yellow = true
//
//            customButtonLayout.isVisible = true
//
//            if (getString(R.string.editText2).equals(editText2.text.toString())) {
//
//                editText2.setText("");
//            }
//
//
//        })
//
//    }
//
//    private fun addValue(Value: String) {
//
//
//        var initialValue = editText1.text.toString();
//        val startCursor = editText1.selectionStart
//
//
//        var positiontextBegin = initialValue.substring(0, startCursor)
//        var positiontextEnd = initialValue.substring(startCursor)
//
//        editText1.setText(String.format("%s%s", positiontextBegin, Value, positiontextEnd))
//        editText1.setSelection(startCursor + Value.length)
//    }
//
//
//    private fun addValue2(Value: String) {
//
//
//        var initialValue = editText2.text.toString();
//        val startCursor = editText2.selectionStart
//
//
//        var positiontextBegin = initialValue.substring(0, startCursor)
//        var positiontextEnd = initialValue.substring(startCursor)
//
//        editText2.setText(String.format("%s%s%s", positiontextBegin, Value, positiontextEnd))
//        editText2.setSelection(startCursor + Value.length)
//    }
