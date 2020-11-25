package com.example.myapplication.Kotlin

// 16. Iterable

fun main(array: Array<String>) {

    val a = mutableListOf<Int>(1, 2, 3, 4, 5, 6, 7, 8, 9)

    // 반복하는 방법 (1)
    for (item in a) {
        if (item == 5) {
            println("item is Five")
        } else {
            println("item is not Five")
        }
    }
    println()

    // 반복하는 방법 (2)
    for ((index, item) in a.withIndex()) {
        println("index : " + index + " value : " + item)
        // 문자열 + Int(정수) = 문자열
        // 문자열 + 아무거나 = 문자열
    }
    println()

    // 반복하는 방법 (3)
    a.forEach {
        println(it)
    }
    println()

    // 반복하는 방법 (4)
    a.forEach { item ->
        println(item)
    }
    println()

    // 반복하는 방법 (5) -> (2)와 똑같은 역할
    a.forEachIndexed { index, item ->
        println("index : " + index + " value : " + item)
    }
    println()

    // 반복하는 방법 (6)
    println(a.size)

    for (i in 0 until a.size) {
        // until 은 마지막을 포함하지 않는다
        // 0 부터 8 까지이다.
        println(a.get(i))
    }
    println()

    // 반복하는 방법 (7)
    for (i in 0 until a.size step (2)) {
        println(a.get(i))
    }
    println()

    // 반복하는 방법 (8)
    for (i in a.size - 1 downTo (0)) {
        // 8 부터 0 까지 반복
        println(a.get(i))
    }
    println()

    // 반복하는 방법 (9)
    for (i in a.size - 1 downTo (0) step (2)) {
        println(a.get(i))
    }
    println()

    // 반복하는 방법 (10)
    for (i in 0..10) {  // 0..9
        // .. -> 마지막을 포함한다
        println(i)
    }
    println()

    // 반복하는 방법 (11)
    var b: Int = 0
    var c: Int = 4

    while (b < c) {
        b++ // while 문을 정지시키기 위한 코드
        println("b")
    }
    println()
    
    // 반복하는 방법 (12)
    var d: Int = 0
    var e: Int = 4
    do {    // while 문 안의 조건에 부합하지 않더라도 한번은 실행
        println("hello")
        d++
    } while (d < e)
}