package com.example.myapplication.Kotlin

// 과제
// Night, Monster (자식) -> 답안에서는 Charactor 로 바꾸어 진행
// SuperNight, SuperMonster (자식)
// 자식만 가지는 특별한 기능 추가

fun main(args: Array<String>) {
    val monster = SuperMonster(100, 10)
    val night = SuperNight(130, 8)
    monster.attack(night)   // 왼쪽 두 line 왜 되는거지? 라고 생각할 수 있음
    monster.bite(night)     // -> 아래 상속이 만들어낸 특징 참고
}

// 상속이 만들어낸 특징
// - 자식 클래스는 부모 클래스의 타입이다
// - 부모 클래스는 자식 클래스의 타입이 아니다!

// 풀이 (오류 발생 -> 자식 클래스에서 var, val 지우면 됨: 이미 부모클래스에서 선언되어서)
/*
open class MyNight (open var hp: Int, private var power: Int) {

    fun attack(monster: Monster) {
        monster.defense(power)
    }

    open fun defense(damage: Int) {
        hp -= damage
        if (hp > 0) {
            heal()
            println("기사 현재 체력은 $hp 입니다")
        }
        else println("기사가 죽었습니다")
    }

    private fun heal() {
        // 아무때나 사용하는 것이 아니라
        // 공격을 당했을 때 죽지 않았다면 힐을 한다.
        hp += 3
    }
}

open class MyMonster(open var hp: Int, private var power: Int) {

    fun attack(night: Night) {
        night.defense(power)
    }

    open fun defense(damage: Int) {
        hp -= damage
        if (hp > 0) println("몬스터 현재 체력은 $hp 입니다")
        else println("몬스터가 죽었습니다")
    }
}

class SuperNight(private var superhp: Int, private var power: Int, private var life: Int): MyNight(hp, power) {

    override fun defense(damage: Int) { // 바로 죽지 않고 life 감소
        if (life < 0) println("Super 기사가 죽었습니다")
        else life--
    }

    fun superHeal(amount: Int) {   // 기사가 안죽었다면 기사의 hp 증가시켜줌
        if (super.hp > 0) {
            super.hp += amount
            println("기사의 hp를 $amount 만큼 회복시켰습니다")
        }
    }
}

class SuperMonster(private var superhp: Int, private var power: Int, private var life: Int): MyMonster(hp, power) {

    override fun defense(damage: Int) { // 바로 죽지 않고 life 감소
        if (life < 0) println("Super 몬스터가 죽었습니다")
        else life--
    }

    fun superHeal(amount: Int) {   // 몬스터가 안죽었다면 몬스터의 hp 증가시켜줌
        if (super.hp > 0) {
            super.hp += amount
            println("몬스터기사의 hp를 $amount 만큼 회복시켰습니다")
        }
    }
}
*/

// 답안
open class Charactor(var hp: Int, val power: Int) {
    fun attack(charactor: Charactor, power: Int = this.power) { // this.power 임에 주의
        charactor.defense(power)
    }

    open fun defense(damage: Int) {
        hp -= damage
        if (hp > 0) println("${javaClass.simpleName}의 남은 체력 $hp")
        else println("사망했습니다")
    }
}

// 자식 클래스가 인스턴스화 되기 위해서 부모 클래스 선행돼서 인스턴스화 되어야 한다.
class SuperMonster(hp: Int, power: Int) : Charactor(hp, power) {
    fun bite(charactor: Charactor) {
        super.attack(charactor, power + 2)
    }
}

class SuperNight(hp: Int, power: Int) : Charactor(hp, power) {
    val defensePower = 2
    override fun defense(damage: Int) {
        super.defense(damage - defensePower)
    }
}