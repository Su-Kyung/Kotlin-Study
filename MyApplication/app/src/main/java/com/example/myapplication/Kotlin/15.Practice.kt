package com.example.myapplication.Kotlin

// map 의 replace 가 api level 24부터 가능 (현재 23)
import android.os.Build
import androidx.annotation.RequiresApi

@RequiresApi(Build.VERSION_CODES.N)
fun main(array: Array<String>) {

    val a = mutableListOf<Int>(1, 2, 3)
    a.add(4)    // 맨 뒤에 추가
    println(a)

    a.add(0, 100)
    println(a)

    a.set(0, 200)
    println(a)

    a.removeAt(2)
    println(a)


    val b = mutableSetOf<Int>(1, 2, 3, 4)
    println()
    b.add(2)    // 인덱스 없음
    println(b)

    b.remove(2)
    println(b)

    b.remove(100)   // 오류나지 않음
    println(b)


    val c = mutableMapOf<String, Int>("one" to 1)
    println()
    c.put("two", 2)
    println(c)

    c.replace("two", 3)
    println(c)
    println(c.keys)
    println(c.values)
    c.clear()
    println(c)
}