package com.example.myapplication

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_shared_preference.*

class SharedPreferenceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_preference)
        
        // SharedPreference
//        val sharedPreference = getSharedPreferences("sp1", Context.MODE_PRIVATE)
        // Mode
        // - MODE_PRIVATE : 생성한 application 에서만 사용 가능 -> 대부분 이거로 사용해도 문제 없다
        // - MODE_WORLD_READABLE : 다른 application 사용 가능 -> 읽을 수만 있다
        // - MODE_WORLD_WRITEABLE : 다른 application 사용 가능 -> 기록도 가능
        // - MODE_MULTI_PROCESS : 이미 호출되어 사용중인지 체크
        // - MODE_APPEND : 기존 preference 에 신규로 추가

        // sharedPreference 에 editor 를 활용해서 데이터를 넣는다
//        val editor: SharedPreferences.Editor = sharedPreference.edit()
//        editor.putString("hello", "안녕하세요")
//        editor.commit() // 한 번 저장하면 이 line 지우고 실행해도 값을 찾을 수 있다 = database 를 사용하는 이유
//                        // Settings = Apps - 만든 앱 - Storage - Clear Data (및 Clear Cash) 하면 데이터 지워진다

        // sp1 -> Sharedpreference
        //        (Key, Value) -> ("Hello", "안녕하세요")
        // sp2 -> Sharedpreference
        //        (Key, Value) -> ("Hello", "안녕하세요11")
        // 서로 다른 SharedPreference 이므로 원래의 값이 변경되지 않는다.

        save_button.setOnClickListener {
            val sharedPreference = getSharedPreferences("sp1", Context.MODE_PRIVATE)
            val editor: SharedPreferences.Editor = sharedPreference.edit()
            editor.putString("hello", "안녕하세요")
            editor.putString("goodbye", "안녕히가세요")
            editor.commit()
        }

        load_button.setOnClickListener {
            // SharedPreference 에 값을 불러오는 방법
            val sharedPreference = getSharedPreferences("sp1", Context.MODE_PRIVATE)
            // 값을 넣을 때는 editor 가 필요하고 값을 가져올 때는 그냥 꺼내면 된다
            val value1 = sharedPreference.getString("hello", "데이터 없음1")   // default 값 넣어줘야 한다
            val value2 = sharedPreference.getString("goodbye", "데이터 없음2")
            Log.d("key-value", "Value1 : " + value1)
            Log.d("key-value", "Value2 : " + value2)
        }

        delete_button.setOnClickListener {
            val sharedPreference = getSharedPreferences("sp1", Context.MODE_PRIVATE)
            val editor = sharedPreference.edit()
            editor.remove("hello")
            editor.commit()
        }

        delete_all_button.setOnClickListener {
            val sharedPreference = getSharedPreferences("sp1", Context.MODE_PRIVATE)
            val editor = sharedPreference.edit()
            editor.clear()
            editor.commit()
        }
    }
}