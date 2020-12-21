package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_calculator.*

class Calculator : AppCompatActivity() {

    var resultNum = 0
    var currentNum = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        btn0.setOnClickListener {
            currentNum = currentNum * 10 + 0
            txtResult.setText("0" + currentNum)
        }

        btn1.setOnClickListener {
            currentNum = currentNum * 10 + 1
            txtResult.setText("0" + currentNum)
        }

        btn2.setOnClickListener {
            currentNum = currentNum * 10 + 2
            txtResult.setText("0" + currentNum)
        }

        btn3.setOnClickListener {
            currentNum = currentNum * 10 + 3
            txtResult.setText("0" + currentNum)
        }

        btn4.setOnClickListener {
            currentNum = currentNum * 10 + 4
            txtResult.setText("0" + currentNum)
        }

        btn5.setOnClickListener {
            currentNum = currentNum * 10 + 5
            txtResult.setText("0" + currentNum)
        }

        btn6.setOnClickListener {
            currentNum = currentNum * 10 + 6
            txtResult.setText("0" + currentNum)
        }

        btn7.setOnClickListener {
            currentNum = currentNum * 10 + 7
            txtResult.setText("0" + currentNum)
        }

        btn8.setOnClickListener {
            currentNum = currentNum * 10 + 8
            txtResult.setText("0" + currentNum)
        }

        btn9.setOnClickListener {
            currentNum = currentNum * 10 + 9
            txtResult.setText("0" + currentNum)
        }

        btnReset.setOnClickListener {
            currentNum = 0
            resultNum = 0
            txtResult.setText("0")
        }

        btnAdd.setOnClickListener {
            resultNum += currentNum
            currentNum = 0
            txtResult.setText(""+resultNum)
        }
    }
}