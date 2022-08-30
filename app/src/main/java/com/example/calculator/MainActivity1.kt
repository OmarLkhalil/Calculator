package com.example.calculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.calculator.R

class MainActivity1 : AppCompatActivity() {
    var resultTv: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main1) // This is the layout inflater for the activity_main.xml file creates the views
        resultTv = findViewById(R.id.result_tv)
    }

    fun onDigitClick(v: View) {
        resultTv!!.append((v as Button).text)
    }

    var operator = ""
    var res = ""
    var rhs = ""
    fun onOperatorClick(v: View) {
        val ClickedOperator = v as Button
        if (operator.isEmpty()) {
            res = resultTv!!.text.toString() // get result from the user text views
            // save clicked operator to variable
            operator = ClickedOperator.text.toString()
            resultTv!!.setText(null) // emtpy the result text view
        } else {
            val rhs = resultTv!!.text.toString()
            calculate(res, operator, rhs)
        }
    }

    fun calculate(res: String, operator: String, rhs: String): String {
        var operator = operator
        var result = 0.0
        val rhsDouble = rhs.toDouble()
        val resDouble = res.toDouble()

        if (operator == "+") {
            result = resDouble + rhsDouble
        }
        if (operator == "-") {
            result = resDouble - rhsDouble
        }
        if (operator == "×") {
            result = resDouble * rhsDouble
        }
        if (operator == "÷") {
            result = resDouble / rhsDouble
        }
        if (operator == "^") {
            result = Math.pow(resDouble, rhsDouble)
        }
        resultTv!!.text = result.toString()
        operator = ""
        return result.toString()
    }

    fun onEqualClick(v: View?) {
        val rhs = resultTv!!.text.toString()
        res = calculate(res, operator, rhs)
        resultTv!!.text = res
    }

    fun allClearOperator(v: View?) {
        operator = ""
        res = ""
        resultTv!!.text = ""
    }

    fun backSpaceClick(v: View?) {
        resultTv!!.text = res.substring(0, res.length - 1)
    }
}