package com.example.myapplication

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.core.widget.addTextChangedListener
import kotlinx.android.synthetic.main.activity_open_internet.*

class OpenInternet : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_open_internet)

        btnIntent.setOnClickListener {
            val address = txtUri.text.toString()    // text 속성 가보면 return type 이 editable -> string 으로 형변환
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(address))    // 뒤의 uri 를 보여주라는 인텐트 만듦
            startActivity(intent)   // 인텐트 보냄
        }

        txtUri.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                Log.d("edit", "afterTextChanged : " + p0)

                // 활용
                if (p0.toString() == "abc") {
                    Log.d("edit", "text is abc")
                }
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                Log.d("edit", "beforeTextChanged : " + p0)
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                Log.d("edit", "onTextChanged : " + p0)
            }
        })
    }
}