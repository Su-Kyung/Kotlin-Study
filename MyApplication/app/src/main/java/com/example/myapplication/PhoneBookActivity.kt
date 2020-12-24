package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView

class PhoneBookActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone_book)

        val phoneBook = createFakePhoneBook(30)
        createPhoneBookList(phoneBook)
    }

    fun createFakePhoneBook(fakeNumber: Int = 10, phoneBook: PhoneBook = PhoneBook()):PhoneBook {
        // 따로 지정하지 않으면 기본 10명을 만든다, 따로 넣어주지 않으면 기본적으로 PhoneBook 생성한다
        for (i in 0 until fakeNumber) {
            phoneBook.addPerson(
                Person(name = ""+i+"번째 사람", number = ""+i+"번째 사람의 전화 번호")
            )
        }
        return phoneBook
    }

    fun createPhoneBookList(phoneBook: PhoneBook) { // PhoneBook 객체를 받는다
        val layoutInflater = LayoutInflater.from(this@PhoneBookActivity)
        val container = findViewById<LinearLayout>(R.id.phonebook_list_container)
        for (i in 0 until phoneBook.personList.size) {
            val view = layoutInflater.inflate(R.layout.phonebook_item, null)    // container 는 필요없음 (null)
            val personNameView = view.findViewById<TextView>(R.id.person_name)
            personNameView.setText(phoneBook.personList.get(i).name)

            addSetOnClickListener(phoneBook.personList.get(i), view)

            container.addView(view)
        }
    }
    
    // 목록 클릭하면 상세 페이지로 넘어간다
    fun addSetOnClickListener(person: Person, view: View) {
        view.setOnClickListener { 
            val intent = Intent(this@PhoneBookActivity, PhoneBookDetailActivity::class.java)
            intent.putExtra("name", person.name)
            intent.putExtra("number", person.number)
            startActivity(intent)
        }
    }
}

// 전화번호부
class PhoneBook() {
    val personList = ArrayList<Person>()

    // personList 에 Person 을 넣는다
    fun addPerson(person: Person) {
        personList.add(person)
    }
}

class Person(val name: String, var number: String) {

}