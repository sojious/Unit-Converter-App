package com.example.unitconverter.util

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import androidx.core.content.res.getColorOrThrow
import androidx.core.widget.addTextChangedListener
import com.example.unitconverter.R
import com.example.unitconverter.model.ConversionUnit
import com.example.unitconverter.model.Currency


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
    var background: Int
    var primaryTextSize: Float
    var captionSize: Float
    private var cursorColor: Int

    private var dataSet: MutableList<ConversionUnit> = mutableListOf()

    private var _editTextValue: String? = null
    val editTextValue get() = _editTextValue

    private var listeners: ArrayList<(String?) -> Unit> = arrayListOf()

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


            background = attributeResource.getColor(
                R.styleable.ConversionBoxView_background,
                Color.WHITE
            )

            this.setBackgroundColor(background)

            primaryTextSize = attributeResource.getDimension(
                R.styleable.ConversionBoxView_primaryTextSize,
                8f.toDp(context)
            )

            conversionTextField.textSize = primaryTextSize

            captionSize = attributeResource.getDimension(
                R.styleable.ConversionBoxView_captionSize,
                8f.toDp(context)
            )

            conversionCaption.textSize = captionSize

            cursorColor = attributeResource.getColor(
                R.styleable.ConversionBoxView_cursorColor,
                Color.BLACK
            )


        } finally {
            attributeResource.recycle()
        }

        conversionTextField.addTextChangedListener(
            onTextChanged = { text, start, before, count ->
                // todo get the value from here if being entered here.
                //todo else set the value
                _editTextValue = text.toString()
                listeners.forEach { broadcastText ->
                    broadcastText(editTextValue)
                }
            }
        )


    }

    fun onEditTextActivated(callback: (String?) -> Unit) {
        listeners.add(callback)
    }

    private fun passData(items: List<ConversionUnit>) {
        if (dataSet.isEmpty()) {
            dataSet.addAll(items)
        }
        return
    }

    fun configureSpinner(context: Context, items: List<ConversionUnit>) {
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
                Toast.makeText(
                    context,
                    "You have clicked on ${items[position].conversionName}",
                    Toast.LENGTH_SHORT
                ).show()
                //todo update the edit text sub unit
                _currentUnitItem = items[position]
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }
    }

    fun setConversionTextField(value: String) {
        conversionTextField.setText(value)
    }

}
