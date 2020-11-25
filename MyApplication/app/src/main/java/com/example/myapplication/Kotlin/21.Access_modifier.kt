package com.example.myapplication.Kotlin

// 21. 접근 제어자

fun main(array: Array<String>) {

    val testAccess : TestAccess = TestAccess("바보")
    // Private 키워드 때문에 외부에서 더 이상 사용할 수 없다. -> 외부와 내부 단절
//    testAccess.test()
//    println(testAccess.name)
//    testAccess.name = "김개똥"
//    println(testAccess.name)

    val reward: Reward = Reward()
    reward.rewardAmount = 2000

    val runningCar: RunningCar = RunningCar()
    runningCar.runFast()
//    runningCar.run()
}

class Reward() {
    var rewardAmount: Int = 1000
}

class TestAccess {
    private var name: String = "홍길동"    // 외부에서 접근 불가능

    constructor(name: String) {
        this.name = name
    }

    fun changeName(newName: String) {
        this.name = newName // 이름 변경 가능 (접근 가능)
    }

    fun test() {
        println("테스트")
    }
}

class RunningCar() {

    fun runFast() {
        run()   // 보조적인 기능
    }

    // 외부에 공개하고 싶지 않은 기능
    private fun run() {

    }
}