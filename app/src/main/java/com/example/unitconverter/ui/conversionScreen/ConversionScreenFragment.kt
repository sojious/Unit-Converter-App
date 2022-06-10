package com.example.unitconverter.ui.conversionScreen

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.Selection
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.unitconverter.R
import com.example.unitconverter.data.ConversionData
import com.example.unitconverter.data.CurrencyDb
import com.example.unitconverter.databinding.FragmentConversionScreenBinding
import com.example.unitconverter.model.ConversionItem
import com.example.unitconverter.model.ConversionType
import com.example.unitconverter.model.ConversionUnit
import com.example.unitconverter.util.KeyboardView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textview.MaterialTextView

class ConversionScreenFragment : Fragment(R.layout.fragment_conversion_screen) {


    private var _binding: FragmentConversionScreenBinding? = null
    private val binding get() = _binding
    private var data: List<ConversionUnit> = listOf()

    private val args: ConversionScreenFragmentArgs? by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentConversionScreenBinding
            .inflate(inflater, container, false)
//        if(args != null) {
//            Toast.makeText(activity, args?.conversionItem?.conversionName, Toast.LENGTH_SHORT).show()
//        }


        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        data = DataFactory.data(requireContext(), args?.conversionItem?.conversionName)

        binding?.ConversionBox1?.background = Color.RED
        binding?.ConversionBox2?.background = Color.YELLOW

        binding?.ConversionBox1?.configureSpinner(requireContext(), data)
        binding?.ConversionBox2?.configureSpinner(requireContext(), data)

//        binding?.ConversionBox1?.onEditTextActivated { value ->
//            binding?.ConversionBox2?.setConversionTextField(value!!)
//        }
//
//        binding?.ConversionBox2?.onEditTextActivated { value ->
//            binding?.ConversionBox1?.setConversionTextField(value!!)
//        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
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


}

class DataFactory {
    companion object {
        fun data(context: Context, conversionName: String?): List<ConversionUnit> {
            return when (conversionName) {
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
        }
    }
}