package com.example.kotlincalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        but_0.setOnClickListener { setTextField("0") }
        but_1.setOnClickListener { setTextField("1") }
        but_2.setOnClickListener { setTextField("2") }
        but_3.setOnClickListener { setTextField("3") }
        but_4.setOnClickListener { setTextField("4") }
        but_5.setOnClickListener { setTextField("5") }
        but_6.setOnClickListener { setTextField("6") }
        but_7.setOnClickListener { setTextField("7") }
        but_8.setOnClickListener { setTextField("8") }
        but_9.setOnClickListener { setTextField("9") }

        but_neg.setOnClickListener { setTextField("-") }
        but_plus.setOnClickListener { setTextField("+") }
        but_mult.setOnClickListener { setTextField("*") }
        divisionBut.setOnClickListener { setTextField("/") }

        bracket_open.setOnClickListener { setTextField("(") }
        bracket_close.setOnClickListener { setTextField(")") }
        but_dote.setOnClickListener{setTextField(".")}

        ac.setOnClickListener {
            math_operation.text = ""
            result_text.text = ""
        }
        but_back.setOnClickListener {
            val str = math_operation.text.toString()
            if (str.isNotEmpty()){
                math_operation.text = str.substring(0, str.length - 1) //обрізати рядок
            }
            result_text.text = ""
        }

        but_equal.setOnClickListener {
            try {
                val ex = ExpressionBuilder(math_operation.text.toString()).build() //із кастомної бібліотеки (перетворю строку в матеметичний вираз)
                val result = ex.evaluate()                 // виводить результат з перетвореноъ строки в рівняння

                result_text.text = result.toString()

            } catch (e: Exception){
                Log.d("Ошибка", "message: ${e.message}")

            }
        }

    }

    fun setTextField(str: String){
        math_operation.append(str) //добавляєм уже до існуючій ише символи
        if(result_text.text != ""){
            math_operation.text = result_text.text
            result_text.text = ""
        }
    }
}
