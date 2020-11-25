package com.example.myapplication.Kotlin

import android.speech.tts.TextToSpeech

// 두 번까지는 봐준다
// 두 번 이상이 넘어가면 리팩토링 해라

// 23. 상속
// 부모로부터 설명서를 물려받는다

fun main(args: Array<String>) {
    val superCar100: SuperCar100 = SuperCar100()
    println(superCar100.drive())
    superCar100.stop()
    
//    val bus100: Bus100 = Bus100()
//    carcar100.drive() -> 상속하지 않아 사용할 수 없음
}

/*
// 상속 안한 경우
class Car100(engine: String, body: String) {
    
}

class SuperCar1() {
fun drive() {

}

fun stop() {

}
}

class Truck1() {
fun drive() {

}

fun stop() {

}
}

class Bus1() {
fun drive() {

}

fun stop() {

}
}
*/

// 부모 : Car100
// 자식 : SuperCar100
// open 키워드 있어야 상속 가능
open class Car100() {
    open fun drive(): String {
        return "달린다"
    }
    
    fun stop() {
        
    }
}

class SuperCar100(): Car100() {
    // 부모의 기능 수정해서 사용
    // 우클릭 -> Generator 또는 Alt + Insert 하고 Override method 선택
    override fun drive(): String {
        val run = super.drive()   // super == 부모
        return "빨리 $run"
    }
    
    // open 키워드가 없어 오버라이드 할 수 없음
//    override fun stop() {
//        
//    }
}

//class Bus100() {
//
//}

class Bus100(): Car100() {
    
}