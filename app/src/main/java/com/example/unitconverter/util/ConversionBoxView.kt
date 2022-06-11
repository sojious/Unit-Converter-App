package com.example.unitconverter.util

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import androidx.core.widget.addTextChangedListener
import com.example.unitconverter.R
import com.example.unitconverter.model.ConversionUnit


class ConversionBoxView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyle: Int = 0,
    defRes: Int = 0
) : LinearLayout(context, attributeSet, defStyle, defRes) {
    private val conversionSpinner: Spinner
    private val conversionTextField: EditText
    private val conversionCaption: TextView

    var textColor: Int
    var localBackground: Int
    var primaryTextSize: Float
    var captionSize: Float

    private var dataSet: MutableList<ConversionUnit> = mutableListOf()

    private var _editTextValue: String? = null
    private val editTextValue get() = _editTextValue

    private var _currentUnitItem: ConversionUnit? = null
     val currentUnitItem get() = _currentUnitItem


    init {
        orientation = VERTICAL
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)
                as LayoutInflater
        inflater.inflate(R.layout.view_conversion_box, this)
        conversionSpinner = findViewById(R.id.ConversionSpinner)
        conversionTextField = findViewById(R.id.ConversionTextField)
        conversionCaption = findViewById(R.id.ConversionCaption)


        val attributeResource = context.obtainStyledAttributes(
            attributeSet, R.styleable.ConversionBoxView
        )

        try {
            textColor = attributeResource.getColor(
                R.styleable.ConversionBoxView_textColor,
                Color.BLACK
            )
            conversionTextField.setTextColor(textColor)
            conversionCaption.setTextColor(textColor)

            localBackground = attributeResource.getColor(
                R.styleable.ConversionBoxView_background,
                resources.getColor(R.color.local_yellow_bright, null)
            )

            this.setBackgroundColor(localBackground)

            primaryTextSize = attributeResource.getDimension(
                R.styleable.ConversionBoxView_primaryTextSize,
                48f
            )
            conversionTextField.setTextSize(TypedValue.COMPLEX_UNIT_SP, primaryTextSize)

            captionSize = attributeResource.getDimension(
                R.styleable.ConversionBoxView_captionSize,
                12f
            )
            conversionCaption.setTextSize(TypedValue.COMPLEX_UNIT_SP, captionSize)
        } finally {
            attributeResource.recycle()
        }
    }


    private fun passData(items: List<ConversionUnit>) {
        if (dataSet.isEmpty()) {
            dataSet.addAll(items)
        }
        return
    }

    fun configureSpinner(context: Context, items: List<ConversionUnit>): Spinner {
        passData(items)

        val spinnerAdapter = ArrayAdapter<String>(
            context,
            R.layout.simple_spinner_item, dataSet.getConversionNames()
        ).apply {
            setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
        }

        conversionSpinner.adapter = spinnerAdapter
        conversionSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                _currentUnitItem = items[position]
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }
        return conversionSpinner
    }

    fun setConversionTextField(value: String) {
        conversionTextField.setText(value)
    }

    fun getConversionTextValue(): String {
        return editTextValue.toString()
    }

    fun setConversionTextSize(size: Float) {
        conversionTextField.setTextSize(TypedValue.COMPLEX_UNIT_SP, size)
    }

    fun getTextField(): EditText =
        conversionTextField

}
