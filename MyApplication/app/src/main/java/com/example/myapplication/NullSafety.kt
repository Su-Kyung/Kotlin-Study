package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.myapplication.Kotlin.Car
import com.example.myapplication.Kotlin.number
import kotlin.properties.Delegates

class NullSafety : AppCompatActivity() {

    lateinit var lateCar: Car   // 나중에 초기화 할게!

    // lateinit 테스트 위한 클래스
    class Car(var number: Int) {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_null_safety)

//        val number1: Int = 10
////        val number2 : Int = null -> 오류: Null 이 될 수 없는 타입
//        val number2: Int? = null
//
//        // !! 사용하기
//        //val number5: Int = number2 + 10 // 우항이 null 이 될 수 있으므로 불가능
//        val number5: Int = number2!! + 10   // !!는 사람(개발자)이 보장하는 것이기 때문에 위험하다)
//
////        val number3 = number1? + number2 -> 불가능한 문법
//        val number3 = number2?.plus(number)
//        //Log.d("number", "number3 : "+number3)
//
//        // 삼항연산자 -> 엘비스 연산자 (?:)
//        // Null safety 를 위한 도구
//        val number4 = number2 ?:10  // number2 가 null 이면 :뒤의 값인 10이 들어간다
//        //Log.d("number", "number4 : " + number4)
//
//        lateCar = Car(10)
//        // 위아래 두 줄을 바꾸면 오류 발생: 초기화 안되어있으니까
//        Log.d("number", "late number : " + lateCar.number)
    }

    fun plus(a:Int, b:Int?): Int {
        if (b != null) return a + b // if 문이 모든 경우를 포함하고 있지 않다
        else return a
    }

    fun plus2(a: Int, b: Int?): Int? {
        return b?.plus(a)
    }
}