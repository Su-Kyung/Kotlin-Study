package com.example.myapplication.Kotlin

fun main(args: Array<String>) {

    val a: Int? = null
    val b: Int = 10
    val c: Int = 100

    if (a == null) {
        println("a is null")
    } else {
        println("a is not null")
    }

    if (b + c == 110) {
        println("b plus c is 110")
    } else {
        println("b plus c is not 110")
    }

    // 엘비스 연산자 -> 코틀린 언어의 특징. null에 대해 문법적으로 대응 가능
    val number: Int? = null
    // val number: Int? = 100
    val number2 = number ?: 10
    println()
    println(number2)

    // 모든 경우의 수에 대응
    val num1: Int = 10
    val num2: Int = 20
    val max = if (num1 > num2) {
        a //5
    } else if (num1 == num2) {
        b //10
    } else {

    }
}