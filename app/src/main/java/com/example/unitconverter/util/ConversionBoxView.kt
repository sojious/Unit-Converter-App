package com.example.unitconverter.util

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.util.TypedValue
import android.view.LayoutInflater
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Spinner
import android.widget.TextView
import androidx.core.content.res.getColorOrThrow
import com.example.unitconverter.R


class ConversionBoxView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyle: Int = 0,
    defRes: Int = 0
) : LinearLayout(context, attributeSet, defStyle, defRes) {
    private val conversionSpinner: Spinner
    private val conversionTextField: EditText
    private val conversionCaption: TextView

    private var textColor: Int
    private var background: Int
    private var primaryTextSize: Float
    private var captionSize: Float
    private var cursorColor: Int

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

            background = attributeResource.getColor(
                R.styleable.ConversionBoxView_background,
                Color.WHITE
            )

            primaryTextSize = attributeResource.getDimension(
                R.styleable.ConversionBoxView_primaryTextSize,
                toDp(8f)
            )

            captionSize = attributeResource.getDimension(
                R.styleable.ConversionBoxView_captionSize,
                toDp(8f)
            )

            cursorColor = attributeResource.getColor(
                R.styleable.ConversionBoxView_cursorColor,
                Color.BLACK
            )

        } finally {
            attributeResource.recycle()
        }

    }


    private fun toDp(value: Float): Float {
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            value.toFloat(),
            context.resources.displayMetrics
        )
    }

}