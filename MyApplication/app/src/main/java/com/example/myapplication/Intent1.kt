package com.example.myapplication

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_intent.*

class Intent1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent)

        change_activity.setOnClickListener {

////            val intent = Intent(this@Intent1, Intent2::class.java)
//            val intent = Intent(this, Intent2::class.java) // this 만 넣으면 안될 때도 있다 (특히 다이얼로그에서 종종)
//
//            // Key, Value 방식 -> Key 와 value 를 쌍으로 만들어 저장한다 -> Dictionary
//            intent.putExtra("number1", 1)
//            intent.putExtra("number2", 2)
//            startActivity(intent)

            // 위와 기능은 완전히 같다
//            val intent2 = Intent(this@Intent1, Intent2::class.java)   // -> 명시적 인텐트 (누가 누구에게!)
//            // Apply: 코틀린의 유용한 기능 - this 로 접근할 수 있도록 해줌. 코드를 쉽게 읽을 수 있다.
//            intent2.apply {
//                this.putExtra("number1", 1)
//                this.putExtra("number2", 2)
//            }
////            startActivity(intent2)  // 전달만 하는 Intent 이므로 아래 결과값 출력이 안된다.
//            // requestCode: 구분을 위한 것 -> intent2 를 Intent1 액티비티가 Intent2 액티비티에 200이라는 이름으로 보낸다
//            startActivityForResult(intent2, 200)

            // 암시적 인텐트
            // 행동, 행동에 필요한 정보
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://m.naver.com"))    // 뒤의 uri 를 보여주라는 인텐트 만듦
            startActivity(intent)   // 인텐트 보냄
        }
    }

    // 인텐트 결과값 받기
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 200) {
            Log.d("number", "" + requestCode)
            Log.d("number", "" + resultCode)
            val result = data?.getIntExtra("result", 0)
            Log.d("number", "" + result)
        }
    }
}