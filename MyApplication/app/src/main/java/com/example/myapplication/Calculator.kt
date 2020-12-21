package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_calculator.*

class Calculator : AppCompatActivity() {

    var resultNum = 0
    var currentNum = 0

    // 풀이 -> 이렇게 string 으로 표시해주어야 txtResult 가 두줄, 세 줄로 늘어난다.
    var new = "0"
    var old = "0"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        btn0.setOnClickListener {
//            currentNum = currentNum * 10 + 0
//            txtResult.setText("0" + currentNum)

            new = new + "0"
            txtResult.setText(new)
        }

        btn1.setOnClickListener {
//            currentNum = currentNum * 10 + 1
//            txtResult.setText("0" + currentNum)

            new = new + "1"
            txtResult.setText(new)
        }

        btn2.setOnClickListener {
//            currentNum = currentNum * 10 + 2
//            txtResult.setText("0" + currentNum)

            new = new + "2"
            txtResult.setText(new)
        }

        btn3.setOnClickListener {
//            currentNum = currentNum * 10 + 3
//            txtResult.setText("0" + currentNum)

            new = new + "3"
            txtResult.setText(new)
        }

        btn4.setOnClickListener {
//            currentNum = currentNum * 10 + 4
//            txtResult.setText("0" + currentNum)

            new = new + "4"
            txtResult.setText(new)
        }

        btn5.setOnClickListener {
//            currentNum = currentNum * 10 + 5
//            txtResult.setText("0" + currentNum)

            new = new + "5"
            txtResult.setText(new)
        }

        btn6.setOnClickListener {
//            currentNum = currentNum * 10 + 6
//            txtResult.setText("0" + currentNum)

            new = new + "6"
            txtResult.setText(new)
        }

        btn7.setOnClickListener {
//            currentNum = currentNum * 10 + 7
//            txtResult.setText("0" + currentNum)

            new = new + "7"
            txtResult.setText(new)
        }

        btn8.setOnClickListener {
//            currentNum = currentNum * 10 + 8
//            txtResult.setText("0" + currentNum)

            new = new + "8"
            txtResult.setText(new)
        }

        btn9.setOnClickListener {
//            currentNum = currentNum * 10 + 9
//            txtResult.setText("0" + currentNum)

            new = new + "9"
            txtResult.setText(new)
        }

        btnReset.setOnClickListener {
//            currentNum = 0
//            resultNum = 0
//            txtResult.setText("0")

            new = "0"
            old = "0"
            txtResult.setText("0")
        }

        btnAdd.setOnClickListener {
//            resultNum += currentNum
//            currentNum = 0
//            txtResult.setText(""+resultNum)

            // "1" + "2" = "12"
            // 1 + 2 = 3
            old = (old.toInt() + new.toInt()).toString()    // 형변환
            new = "0"
            txtResult.setText(old)
        }
    }
}