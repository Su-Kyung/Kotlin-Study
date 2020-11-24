package com.example.myapplication.Kotlin

fun main(array: Array<String>) {

    // 문제 1)
    {
        val calculator1 = Calculator1()
        println(plus(4, 5))
        println(calculator1.minus(4, 5))
        println(calculator1.multiply(4, 5))
        println(calculator1.divide(4, 5))
        println()

        val calculator2 = Calculator2()
        println(calculator2.plus(1, 2, 3, 4, 5))
        println(calculator2.minus(10, 1, 2, 3))
        println(calculator2.multiply(1, 2, 3))
        println(calculator2.divide(10, 2, 3))
        println()

        val calculator3 = Calculator3(3)
        calculator3.plus(5).minus(5)
        //---------/ -> Calculator3(3)
        //-------------------------/ -> Calculator3(8)
        //-------------------------------------------/ -> Calculator3(8).minus(5)
        // -> 이런 식으로 자기 자신 클래스를 리턴해서 기능을 이어나가는 것 : Chaining (체이닝)

        // Calculator1 과의 비교
        // calculator1.plus(3, 4).plus(4, 5)
        // -----------/ -> Calculator1
        // ---------------------/ -> 7
        // ----------------------/ -> 7.plus(4, 5) 불가능!
    }

    // 문제 2)
    {
        val account: Account = Account("홍길동", "1990/3/1", 1000)
        println(account.checkBalance())
        println(account.save(1000))
        println(account.withdraw(2000))
        println(account.checkBalance())

        println()

        val account2: Account = Account("홍길동", "1990/3/1", -2000)
        println(account2.checkBalance())
        println()

        val account3: Account2 = Account2("홍길동", "1990/3/1")
        println(account3.checkBalance())
        val account4: Account2 = Account2("홍길동", "1990/3/1", 4000)
        println(account4.checkBalance())
        println()
    }

    // 문제 3)
//    val channels = listOf<String>("K", "M", "S")
//    val tv = TV(channels)
    val tv = TV(listOf<String>("K","M", "S"))
    tv.channelUp()
    println(tv.checkCurrentChannel())
    tv.channelUp()
    println(tv.checkCurrentChannel())
    tv.channelUp()
    println(tv.checkCurrentChannel())
    tv.channelUp()
    println(tv.checkCurrentChannel())
    println()
    tv.channelDown()
    println(tv.checkCurrentChannel())
    tv.channelDown()
    println(tv.checkCurrentChannel())
    tv.channelDown()
    println(tv.checkCurrentChannel())
    tv.channelDown()
    println(tv.checkCurrentChannel())
    println()
    tv.currentChannelNumber // 값 호출
}

// 1) 사칙 연산을 수행할 수 있는 클래스

// 풀이
class Calculate {
    var first: Float = 0.0f
    var second: Float = 0.0f

    constructor(first: Float, second: Float) {
        this.first = first
        this.second = second
    }

    fun myAdd(first: Float, second: Float): Float {
        return(first + second)
    }

    fun mySubtract(first: Float, second: Float): Float {
        return(first - second)
    }

    fun myMultiply(first: Float, second: Float): Float {
        return(first * second)
    }

    fun myDivide(first: Float, second: Float): Unit {
        if (second != 0.0f) println("error: Can't be divided by zero.")
        else println(first / second + first % second) // 음수인 경우는? (테스트 후 보완 필요함)
    }
}

// 답안 (1) -> 두 수간의 사칙연산만 가능
class Calculator1() {
    fun plus(a: Int, b: Int): Int {
        return a + b
    }

    fun minus(a: Int, b: Int): Int {
        // 먼저 들어온 수에서 뒤에 들어온 수를 뺀다 -> 주석으로 약속 명시
        return a - b
    }

    fun multiply(a: Int, b: Int): Int {
        return a * b
    }

    fun divide(a: Int, b: Int): Int {
        // 먼저 들어온 수를 뒤에 들어온 수로 나눈다
        // 리턴은 몫만 한다
        return a / b
    }
}

// 답안 (2) -> (1) 보완. but 순서가 정해져 있음
class Calculator2() {
    fun plus(vararg numbers: Int): Int {
        var result: Int = 0
        numbers.forEach {
            result = result + it
        }
        return result
    }

    fun minus(vararg numbers: Int): Int {   // 10, 1, 2, 3
        // 10 - 1 - 2 - 3
        // 0 - 10 - 1 - 2 - 3
        var result: Int = numbers[0]
        for (i in 0 until numbers.size) {
            if (i != 0) {
                result = result - numbers[i]
            }
        }
        return result
    }

    fun multiply(vararg numbers: Int): Int {
        var result: Int = 1
        numbers.forEach {
            if (it != 0) {
                result = result * it
            }
        }
        return result
    }

    fun divide(vararg numbers: Int): Int {  // 10, 2, 3 -> 10/2/3
        var result: Int = numbers[0]
        numbers.forEachIndexed { index, value ->
            // 10 -> 10/10/2/3 방지
            if (index != 0) {
                if (value != 0) {
                    result = result / value
                }
            }
        }
        return result
    }
}

// 답안 (3) -> (2) 보완
class Calculator3(val initialValue: Int) {

    fun plus(number: Int): Calculator3 {
        val result = this.initialValue + number
        return Calculator3(result)
    }

    fun minus(number: Int): Calculator3 {
        val result = this.initialValue - number
        return Calculator3(result)
    }

    fun multiply(number: Int): Calculator3 {
        val result = this.initialValue * number
        return Calculator3(result)
    }

    fun divide(number: Int): Calculator3 {
        val result = this.initialValue / number
        return Calculator3(result)
    }
}

// 2) 은행 계좌 만들기
//    - 계좌 생성 가능 (이름, 생년 월일)
//    - 잔고를 확인하는 기능
//    - 출금 가능
//    - 예금 가능

// 풀이
class MyAccount {
    var myName: String
    var myBirth: String
    var myMoney: Int = 0

    constructor(myName: String, myBirth: String) {
        this.myName = myName
        this.myBirth = myBirth
    }

    fun checkMyMoney(): Int {
        return myMoney
    }

    fun withdraw(myMoney: Int): String {
        this.myMoney -= myMoney
        return("출금 완료되었습니다. 출금한 돈 {}원, 잔액: {}원".format(myMoney, this.myMoney))
    }

    fun deposit(myMoney: Int): String {
        this.myMoney += myMoney
        return("예금 완료되었습니다. 예금한 돈: {}원, 잔액: {}원".format(myMoney, this.myMoney))
    }
}

// 답안 (1)
class Account {

    val name: String
    val birth: String
    var balance: Int

    constructor(name: String, birth: String, balance: Int) {
        this.name = name
        this.birth = birth
        if (balance >= 0) { // 초기값 검열 및 대응 (ex. -2000원)
            this.balance = balance
        } else {
            this.balance = 0
        }
    }

    fun checkBalance(): Int {
        return balance
    }

    fun withdraw(amount: Int): Boolean {
        if (balance >= amount) {
            balance -= amount
            return true
        } else {
            return false
        }
    }

    fun save(amount: Int) {
        balance += amount
    }
}

// 답안 (2) -> 처음 계좌 생성 시 기본값 설정
class Account2 (val name: String, val birth: String, var balance: Int = 1000) {

    fun checkBalance(): Int {
        return balance
    }

    fun withdraw(amount: Int): Boolean {
        if (balance >= amount) {
            balance -= amount
            return true
        } else {
            return false
        }
    }

    fun save(amount: Int) {
        balance += amount
    }
}

// 답안 (3)
class Account3(initialBalance: Int) {   // val 또는 var 없음 (Account2 와 비교

    val balance: Int = if (initialBalance >= 0) initialBalance else 0

    fun checkBalance(): Int {
        // return initialBalance -> 참조 불가
        return balance
    }
}

// 3) TV 클래스
//    - on/off 기능
//    - 채널을 돌리는 기능
//    - 초기 채널은 (S사 M사 K사 3개)

// 풀이
class MyTelevision {

    var power: String = "off"
    var channel: String

    constructor(power: String) {
        this.power = power
        this.channel = "S사"
    }

    fun changePower() {
        if (this.power == "off") this.power == "on"
        else this.power == "off"
    }

    fun nextChannel() {
        when(this.channel) {
            "S사" -> "M사"
            "M사" -> "K사"
            "K사" -> "S사"
        }
    }

    fun previousChannel() {
        when(this.channel) {
            "S사" -> "K사"
            "M사" -> "S사"
            "K사" -> "M사"
        }
    }
}

// 답안 (1)
class TV(val channels: List<String>) {

    var onOrOff: Boolean = false    // True -> On, False -> Off
    var currentChannelNumber = 0
        // 중요!
        set(value) {
            // currentChannelNumber = value 라고 하면 무한루프에 빠진다! (계속 set 호출)
            field = value   // field: 무한반복을 피하기 위한 키워드
            if (field > 2) field = 0
            if (field < 0 ) field = 2
            //println(value)
        }
        get() { // 값이 호출될 때 실행
            println("호출되었습니다.")
            return field
            // return field + 1 -> 이런식으로 값 조작도 가능
        }

    fun switch() {
        onOrOff = !onOrOff
    }

    fun checkCurrentChannel(): String {
        return channels[currentChannelNumber]
    }

    fun channelUp() {
        currentChannelNumber = currentChannelNumber + 1
//        channels.forEachIndexed { index, value ->
//            if (currentChannelNumber == index) {
//                currentChannelNumber = currentChannelNumber + 1
//                return
//            }
//        }
    }

    fun channelDown() {
        currentChannelNumber = currentChannelNumber - 1
//        channels.forEachIndexed { index, value ->
//            if (currentChannelNumber == index) {
//                currentChannelNumber = currentChannelNumber - 1
//                return
//            }
//        }
    }
}