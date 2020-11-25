package com.example.myapplication.Kotlin

fun main(array: Array<String>) {

//    first()
//    println(second(88))
//    println(third(89))
    gugudan()
}

// 1번 문제
// List 를 두 개 만든다
// 첫 번째 List 에는 0 부터 9 까지 값을 넣는다 (반복문 사용)
// 두 번째 List 에는 첫 번째 List 의 값을 하나씩 확인한 후
// 짝수면 True 홀수면 False 를 넣어 준다

// 풀이
//fun first(): Unit {
//    var a = mutableListOf<Int>()
//    var b = mutableListOf<Boolean>()
//
//    for (i in 0 until 10) {
//        a.add(i, i)
//    }
//    println(a)
//
//    for (i in 0 until 10) {
//        if (a[i] % 2 == 0) b.add(i, true)
//        else b.add(i, false)
//    }
//    println(b)
//}

// 답안
fun first() {
    val list1 = MutableList(9, { 0 })
    val list2 = MutableList(9, { true })

    for (i in 0..8) {   // 1..9
        list1[i] = i + 1    // i
    }
    println(list1)

    list1.forEachIndexed { index, value ->
        if (value % 2 == 0) list2[index] = true // 짝수
        else list2[index] = false  // 홀수
    }
    println(list2)
}


// 2번 문제
// 학점을 구하자
// 80 - 90 -> A
// 70 - 79 -> B
// 60 - 69 -> C
// 나머지 F

// 풀이
//fun second(result: Int) {
//
//    if (result in 80..90) println("A")
//    else if (result in 70..79) println("B")
//    else if (result in 60..69) println("C")
//    else println("F")
//}

// 답안
fun second(score: Int): String {
    when (score) {
        in 90..100 -> return "A"
        in 80..89 -> return "B"
        in 70..79 -> return "C"
        else -> return "F"
    }
}

// 3번 문제
// 전달 받은 숫자의 각 자리 수의 합을 구하자
// 조건 : 전달 받은 숫자는 무조건 두자리 숫자이다

// 풀이
//fun third(number: Int): Int {
//    return (number / 10) + (number % 10)
//}

// 답안
fun third(number: Int): Int {
    // 89 -> 8 + 9
    val a: Int = number / 10
    val b: Int = number % 10

    return a + b
}


// 4번 문제
// 구구단을 출력하자

// 풀이
//fun gugudan() {
//    for (i in 2..9) {
//        for (j in 1..9) {
//            println( " " + i + " x " + j + " = " + i * j) // 문자열 맨 처음 아닐 때 출력 오류 이유?
//        }
//    }
//}

// 답안
fun gugudan() {
    for (x in 1..9) {
        // 1 -> 2 -> ...
        for (y in 1..9) {
            // 1 부터 9까지 반복 -> 1 부터 9까지 반복 -> ...
            println("$x x $y = ${x * y}")
        }
    }
}