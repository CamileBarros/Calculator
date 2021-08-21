package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import net.objecthunter.exp4j.ExpressionBuilder
import kotlin.Exception


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar!!.hide()

        val result : TextView = findViewById(R.id.resulta)
        val screenExpr : TextView = findViewById(R.id.scrnexpression)

        val numZero : TextView = findViewById(R.id.numbzero)
        val numOne : TextView = findViewById(R.id.numbone)
        val numTwo : TextView = findViewById(R.id.numbtwo)
        val numThree : TextView = findViewById(R.id.numbthree)
        val numFour : TextView = findViewById(R.id.numbfour)
        val numFive : TextView = findViewById(R.id.numbfive)
        val numSix : TextView = findViewById(R.id.numbsix)
        val numSeven : TextView = findViewById(R.id.numbseven)
        val numEight : TextView = findViewById(R.id.numbeight)
        val numNine : TextView = findViewById(R.id.numbnine)
        val buttPow : TextView = findViewById(R.id.bttnPow)
        val buttLess : TextView = findViewById(R.id.bttnless)
        val buttMulti : TextView = findViewById(R.id.multipl)
        val buttDivise : TextView = findViewById(R.id.divise)
        val buttPlus : TextView = findViewById(R.id.bttnplus)
        val buttPoint : TextView = findViewById(R.id.bttnpoint)
        val buttEqual : TextView = findViewById(R.id.bttnequal)
        val buttBack : TextView = findViewById(R.id.bttnback)
        val buttClear : TextView = findViewById(R.id.bttnclear)

        numZero.setOnClickListener { addExpression(string = "0", clear_datas = true) }
        numOne.setOnClickListener { addExpression(string = "1", clear_datas = true) }
        numTwo.setOnClickListener { addExpression(string = "2", clear_datas = true) }
        numThree.setOnClickListener { addExpression(string = "3", clear_datas = true) }
        numFour.setOnClickListener { addExpression(string = "4", clear_datas = true) }
        numFive.setOnClickListener { addExpression(string = "5", clear_datas = true) }
        numSix.setOnClickListener { addExpression(string = "6", clear_datas = true) }
        numSeven.setOnClickListener { addExpression(string = "7", clear_datas = true) }
        numEight.setOnClickListener { addExpression(string = "8", clear_datas = true) }
        numNine.setOnClickListener { addExpression(string = "9", clear_datas = true) }
        buttPoint.setOnClickListener { addExpression(string = ".", clear_datas = true) }

        buttPow.setOnClickListener { addExpression(string = "^", clear_datas = false) }
        buttLess.setOnClickListener { addExpression(string = "-", clear_datas = false) }
        buttMulti.setOnClickListener { addExpression(string = "*", clear_datas = false) }
        buttDivise.setOnClickListener { addExpression(string = "/", clear_datas = false) }
        buttPlus.setOnClickListener { addExpression(string = "+", clear_datas = false) }

        buttBack.setOnClickListener {
            val string = screenExpr.text.toString()
            if (string.isNotBlank()) {
                screenExpr.text = string.substring(0, string.length - 1)
            }
            result.text = ""
        }

        buttClear.setOnClickListener {
            screenExpr.text = ""
            result.text = ""
        }

        buttEqual.setOnClickListener {
            try {
                val express = ExpressionBuilder(screenExpr.text.toString()).build()
                val resul = express.evaluate()
                val longResult = resul.toLong()
                if (resul == longResult.toDouble())
                    result.text = longResult.toString()
                else result.text = resul.toString()

            }catch (e: Exception){

            }
        }
    }


    fun addExpression(string: String, clear_datas : Boolean){
        val result : TextView = findViewById(R.id.resulta)
        val screenExpr : TextView = findViewById(R.id.scrnexpression)
        if (result.text.isNotEmpty()){
            screenExpr.text = ""
        }

        if (clear_datas){
            result.text = ""
            screenExpr.append(string)
        }else{
            screenExpr.append(result.text)
            screenExpr.append(string)
            result.text = ""
        }
    }
}