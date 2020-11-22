package com.example.myapplication.Kotlin

fun plusThree(first: Int, second: Int, third: Int): Int {
    val result = first + second + third
    return result

    // return first + second + third 로도 가능
}

fun minusThree(first: Int, second: Int, third: Int) = first - second - third

fun multiplyThree(first: Int = 1, second: Int = 1, third: Int = 1): Int {
    return first * second * third
}

// 내부 함수
// - 함수 안에 함수가 있다!
fun showMyPlus(first: Int, second: Int): Int {
    println(first)
    println(second)

    // return first + second
    fun plus(first: Int, second: Int): Int {
        return first + second
    }
    return plus(first, second)
    // ctrl + 클릭 -> 쓰인 곳으로 이동
}


fun main(array: Array<String>) {
    val result = plusThree(1, 2, 3)
    println(result)

    val result2 = minusThree(10, 1, 2)
    println(result2)

    val result3 = multiplyThree(2, 2, 2)
    println(result3)

    val result4 = multiplyThree()
    println(result4)

    // 내부 함수 출력해보기
    val result5 = showMyPlus(4, 5)
    println(result5)
}