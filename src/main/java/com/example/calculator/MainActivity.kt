package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder
import kotlin.Exception


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar!!.hide()

        numbzero.setOnClickListener { addExpression(string = "0", clear_datas = true) }
        numbone.setOnClickListener { addExpression(string = "1", clear_datas = true) }
        numbtwo.setOnClickListener { addExpression(string = "2", clear_datas = true) }
        numbthree.setOnClickListener { addExpression(string = "3", clear_datas = true) }
        numbfour.setOnClickListener { addExpression(string = "4", clear_datas = true) }
        numbfive.setOnClickListener { addExpression(string = "5", clear_datas = true) }
        numbsix.setOnClickListener { addExpression(string = "6", clear_datas = true) }
        numbseven.setOnClickListener { addExpression(string = "7", clear_datas = true) }
        numbeight.setOnClickListener { addExpression(string = "8", clear_datas = true) }
        numbnine.setOnClickListener { addExpression(string = "9", clear_datas = true) }
        bttnpoint.setOnClickListener { addExpression(string = ".", clear_datas = true) }

        bttnPow.setOnClickListener { addExpression(string = "^", clear_datas = false) }
        bttnless.setOnClickListener { addExpression(string = "-", clear_datas = false) }
        bttnmultipl.setOnClickListener { addExpression(string = "*", clear_datas = false) }
        bttndivise.setOnClickListener { addExpression(string = "/", clear_datas = false) }
        bttnplus.setOnClickListener { addExpression(string = "+", clear_datas = false) }

        bttnback.setOnClickListener {
            val string = scrnexpression.text.toString()
            if (string.isNotBlank()) {
                scrnexpression.text = string.substring(0, string.length - 1)
            }
            resulta.text = ""
        }

        bttnclear.setOnClickListener {
            scrnexpression.text = ""
            resulta.text = ""
        }

        bttnequal.setOnClickListener {
            try {
                val express = ExpressionBuilder(scrnexpression.text.toString()).build()
                val resul = express.evaluate()
                val longResult = resul.toLong()
                if (resul == longResult.toDouble())
                    resulta.text = longResult.toString()
                else resulta.text = resul.toString()

            }catch (e: Exception){

            }
        }
    }


    fun addExpression(string: String, clear_datas : Boolean){

        if (resulta.text.isNotEmpty()){
            scrnexpression.text = ""
        }

        if (clear_datas){
            resulta.text = ""
            scrnexpression.append(string)
        }else{
            scrnexpression.append(resulta.text)
            scrnexpression.append(string)
            resulta.text = ""
        }
    }
}