package com.example.myapplication

import java.io.Serializable

// 코틀린이나 자바가 이해할 수 있는 틀
class PersonFromServer(
    var id: Int? = null,
    var name: String? = null,
    var age: Int? = null,
    var intro: String? = null
) : Serializable