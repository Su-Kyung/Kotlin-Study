package com.example.myapplication.Kotlin

// 변수의 접근 범위
// 1. 전역 변수
// 2. 지역 변수

// 접근 범위 가능한 한 작게 설정. 다른 곳에서 필요하게 되면 그 때 범위 수정하는 것이 낫다

var number100: Int = 10     // 전역 변수

fun main(args: Array<String>) {

    val test = Test("홍길동")
    test.testFun()
    test.name
    println(number100)
}

class Test(var name: String) {
    fun testFun() {
        var birth: String = "2000/3/1"  // 지역 변수
        name = "홍길동"    // 지역 변수

        // gender 접근 불가
        fun testFun2() {
            var gender: String = "male" // 지역 변수
        }
    }

    fun testFun2() {
        name
        // birth 접근 불가
    }
}