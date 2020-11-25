package com.example.myapplication.Kotlin

// 25. Interface
// 코틀린 뿐만 아니라 OOP 에서 굉장히 중요한 개념!
// - 인터페이스는 약속! -> 니가 이것을 구현하면 너도 이 타입이다
// - 생성자가 없다 -> 인스턴스화 시킬 수 없다 -> 설명서가 아니다!
// - 지침서 -> 니가 이것을 구현하고 싶다면 반드시 아래 기능을 구현해라
// - 협업 시에 용이 (무슨 기능 있는지 쉽게 알 수 있으니까)

// 상속이 만들어낸 특징 -> 이 특징이 적용이 된다
// - 자식 클래스는 부모 클래스의 타입이다
// - 부모 클래스는 자식 클래스의 타입이 아니다!

// 상속과 다른 점
// - 상속은 조상을 찾아가는 느낌
// - 인터페이스는 종의 특징

// 언제 활용하면 좋을까?
// 그 기능이 있으면 되는데 서로 너무 상이하다 : 인터페이스가 용이
// 기능의 내용이 공통된다 : 상속이 용이

fun main(args: Array<String>) {
    val student_: Student_ = Student_()

    student_.eat()
    student_.sleep()
}

interface Person_ {
    fun eat()
    fun sleep()
}

// 인터페이스
class Student_: Person_ {
    // Alt + Enter -> Implement method
    override fun eat() {
        TODO("Not yet implemented")
    }

    override fun sleep() {
        TODO("Not yet implemented")
    }
}

class SoccerPlay: Person_ {
    override fun eat() {

    }

    override fun sleep() {

    }
}

// 상속
open class Person() {
    open fun eat() {
        
    }
    
    fun sleep() {
        
    }
}

class Student() : Person() {
    
}