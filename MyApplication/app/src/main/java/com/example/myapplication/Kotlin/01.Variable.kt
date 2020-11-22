package com.example.myapplication.Kotlin

// 01. Variable -> 변수
// - 내 마음대로 원하는 것을 넣는다 : Variable
// - 한 번 넣으면 바꿀 수 없다 : Value

// Variable of Value??
// - 변하지는 않은 값이라면 : Value
// - 진짜 모르겠다! : Value -> 나중에 바꿀 일 있으면 var로 바꾸기


// 변수를 선언하는 방법(1)
// var/val 변수명 = 값
var example1 = 10

// 변수를 선언하는 방법(2)
// var/val 변수명 : 자료형 = 값
var example2 : Int = 20

var num = 10
var hello = "hello"
var point = 3.4

val fix = 20

fun main(args:Array<String>) {

    // 선언한 변수 출력
    println(num)
    println(hello)
    println(point)
    println(fix)

    // 변수 변경
    num = 100
    hello = "Good Bye"
    point = 10.4

    println(num)
    println(hello)
    println(point)
    println(fix)

    // fix = 500 -> 오류!
}