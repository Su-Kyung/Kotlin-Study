package com.example.myapplication

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatViewInflater
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_phone_book_with_recycler_view.*

class PhoneBookWithRecyclerViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone_book_with_recycler_view)

        // 결국 아래의 phonebookList 에 넣기위한 변수
        // -> 변수를 만든다는 것은 그만큼 관리를 해야 한다는 것이므로 그냥 바로 넣어주는 것이 좋을 수 있다
        val phoneBook = createFakePhoneBook(fakeNumber = 30)
        val phonoBookRecyclerAdapter = PhoneBookRecyclerAdapter(
            // 이렇게 많아지는 경우에는 앞에 변수명 무엇인지 적어두면 편하다 (확인하러 안 가도 됨)
            // but, 라인 수 많아질 수 있음/이해가 안될 수 있음
            phonebookList = phoneBook,  // 위에서 phonebook 변수 선언 안했다면 phonebookList = createFakePhoneBook(fakeNumber = 30)
            inflater = LayoutInflater.from(this@PhoneBookWithRecyclerViewActivity),
            activity = this@PhoneBookWithRecyclerViewActivity
        )
        with(phonebook_recycler_view) {
            this.adapter = phonoBookRecyclerAdapter
            this.layoutManager = LinearLayoutManager(this@PhoneBookWithRecyclerViewActivity)
        }
//        // 위와 같이 with 를 활용해 줄여쓸 수 있다
//        phonebook_recycler_view.adapter = phonoBookRecyclerAdapter
//        phonebook_recycler_view.layoutManager = LinearLayoutManager(this@PhoneBookWithRecyclerViewActivity)

//        // 변수 아예 안만들고도 가능하다
//        with(phonebook_recycler_view) {
//            this.adapter = PhoneBookRecyclerAdapter(
//                phonebookList = createFakePhoneBook(fakeNumber = 30),
//                inflater = LayoutInflater.from(this@PhoneBookWithRecyclerViewActivity),
//                activity = this@PhoneBookWithRecyclerViewActivity
//            )
//            this.layoutManager = LinearLayoutManager(this@PhoneBookWithRecyclerViewActivity)
//        }
    }

    // PhonoBookActivity.kt 에서 가져옴
    fun createFakePhoneBook(fakeNumber: Int = 10, phoneBook: PhoneBook = PhoneBook()):PhoneBook {
        // 따로 지정하지 않으면 기본 10명을 만든다, 따로 넣어주지 않으면 기본적으로 PhoneBook 생성한다
        for (i in 0 until fakeNumber) {
            phoneBook.addPerson(
                Person(name = ""+i+"번째 사람", number = ""+i+"번째 사람의 전화 번호")
            )
        }
        return phoneBook
    }
}

class PhoneBookRecyclerAdapter(
    val phonebookList : PhoneBook,   // ArrayList 로 안받는다 (PhoneBook 타고 가서 확인)
    val inflater: LayoutInflater,
    val activity : Activity // 아이템 클릭했을 때 넘어갈 액티비티
): RecyclerView.Adapter<PhoneBookRecyclerAdapter.ViewHolder>(){

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val personName : TextView
        init {
            personName = itemView.findViewById(R.id.person_name)

            // 아이템 관련해서는 init 에서 다루는것이 좋다 ex.클릭리스너
            itemView.setOnClickListener {
                val intent = Intent(activity, PhoneBookDetailActivity::class.java)
                intent.putExtra("name", phonebookList.personList.get(adapterPosition).name)
                intent.putExtra("number", phonebookList.personList.get(adapterPosition).number)
                // StartActivity 사용하고 싶다 -> AppCompatActivity 필요함
                // 그런데 이 클래스(PhoneBookRecyclerAdapter)은 Activity 가 아니므로 AppCompatActivity 를 상속받기엔 무리가 있다
                // val activity : Activity -> 이걸 활용한다
                activity.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = inflater.inflate(R.layout.phonebook_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return phonebookList.personList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.personName.setText(phonebookList.personList.get(position).name)
    }
}