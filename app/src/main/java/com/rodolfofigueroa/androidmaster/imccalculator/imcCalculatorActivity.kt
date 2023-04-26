package com.rodolfofigueroa.androidmaster.imccalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider
import com.rodolfofigueroa.androidmaster.R
import java.text.DecimalFormat

class imcCalculatorActivity : AppCompatActivity() {

    private var isMaleSelected:Boolean = true
    private var isFemaleSelected:Boolean = false

    private var currentHeight:Int = 120
    private var currentWeight:Int = 50
    private var currentAge = 20

    private lateinit var viewMale:CardView
    private lateinit var viewFemale:CardView

    private lateinit var tvHeight:TextView
    private lateinit var rsHeight:RangeSlider

    private lateinit var btnSubstractWeight:FloatingActionButton
    private lateinit var btnPlusWeight:FloatingActionButton
    private lateinit var tvWeight:TextView

    private lateinit var btnSubstractAge:FloatingActionButton
    private lateinit var btnPlusAge:FloatingActionButton
    private lateinit var tvAge:TextView

    private lateinit var btnCalculate:Button

    companion object {
        const val IMC_KEY = "IMC_RESULT"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc_calculator)

        initComponents()
        initListeners()
    }

    private fun initComponents() {
        viewMale = findViewById(R.id.viewMale)
        viewFemale = findViewById(R.id.viewFemale)
        tvHeight = findViewById(R.id.tvHeight)
        rsHeight = findViewById(R.id.rsHeight)

        btnSubstractWeight = findViewById(R.id.btnSubstractWeight)
        btnPlusWeight = findViewById(R.id.btnPlusWeight)
        tvWeight = findViewById(R.id.tvWeight)

        btnSubstractAge = findViewById(R.id.btnSubstractAge)
        btnPlusAge = findViewById(R.id.btnPlusAge)
        tvAge = findViewById(R.id.tvAge)

        btnCalculate = findViewById(R.id.btnCalculate)
    }

    private fun initListeners() {
        viewMale.setOnClickListener {
            isMaleSelected = true
            isFemaleSelected = false
            changecardColors()
        }

        viewFemale.setOnClickListener {
            isFemaleSelected = true
            isMaleSelected = false
            changecardColors()
        }

        rsHeight.addOnChangeListener { _, value, _ ->
            val df = DecimalFormat("#.##")
            currentHeight = df.format(value).toInt()
            tvHeight.text = "$currentHeight cm" }

        btnSubstractWeight.setOnClickListener {
            currentWeight -= 1
            setWeight()
        }

        btnPlusWeight.setOnClickListener {
            currentWeight += 1
            setWeight()
        }

        btnSubstractAge.setOnClickListener {
            currentAge -= 1
            setAge()
        }

        btnPlusAge.setOnClickListener {
            currentAge += 1
            setAge()
        }

        btnCalculate.setOnClickListener {
            val result = calculateIMC()
            navigateToResult(result)
        }
    }

    private fun navigateToResult(result: Double) {
        val intent = Intent(this, ResultIMCActivity::class.java)
        intent.putExtra(IMC_KEY, result)
        startActivity(intent)
    }

    private fun calculateIMC():Double {
        val df = DecimalFormat("#.##")
        val imc = df.format(currentWeight / (currentHeight.toDouble()/100 * currentHeight.toDouble()/100)).toDouble()
        return imc

    }

    private fun setAge() {
        tvAge.text = "$currentAge"
    }

    private fun changecardColors(){
        if (isMaleSelected){
            viewMale.setCardBackgroundColor(ContextCompat.getColor(this, R.color.background_component_selected))
            viewFemale.setCardBackgroundColor(ContextCompat.getColor(this, R.color.background_component))
        }else{
            viewMale.setCardBackgroundColor(ContextCompat.getColor(this, R.color.background_component))
            viewFemale.setCardBackgroundColor(ContextCompat.getColor(this, R.color.background_component_selected))
        }
    }

    private fun setWeight(){
        tvWeight.text = "$currentWeight"
    }







}