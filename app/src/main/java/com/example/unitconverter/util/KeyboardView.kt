package com.example.unitconverter.util

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.appcompat.widget.AppCompatButton
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.unitconverter.R

class KeyboardView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defRes: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr, defRes) {

    private lateinit var zero: AppCompatButton
    private lateinit var one: AppCompatButton
    private lateinit var two: AppCompatButton
    private lateinit var three: AppCompatButton
    private lateinit var four: AppCompatButton
    private lateinit var five: AppCompatButton
    private lateinit var six: AppCompatButton
    private lateinit var seven: AppCompatButton
    private lateinit var eight: AppCompatButton
    private lateinit var nine: AppCompatButton
    private lateinit var clearAll: AppCompatButton
    private lateinit var point: AppCompatButton
    private lateinit var doubleZero: AppCompatButton
    private lateinit var clear: AppCompatButton


    init {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)
                as LayoutInflater
        inflater.inflate(R.layout.keyboard_layout, this)
        bindViews()
    }

    private fun bindViews() {
        zero = findViewById(R.id.zero);
        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);
        five = findViewById(R.id.five);
        six = findViewById(R.id.six);
        seven = findViewById(R.id.seven)
        eight = findViewById(R.id.eight);
        nine = findViewById(R.id.nine);
        clearAll = findViewById(R.id.clearAll);
        clear = findViewById(R.id.clear);
        point = findViewById(R.id.point);
        doubleZero = findViewById(R.id.doubleZero);
    }
}