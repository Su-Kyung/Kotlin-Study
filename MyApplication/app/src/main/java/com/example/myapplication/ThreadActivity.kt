package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_thread.*

class ThreadActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thread)

        // runnable 만듦
        val runnable: Runnable = object : Runnable {
            override fun run() {
                Log.d("thread-1", "Thread1 is made")
            }
        }

        // 버튼 클릭했을 때 실행
        button.setOnClickListener {
            val thread: Thread = Thread(runnable)   // thread 를 만들고 runnable 넣어줌 -> 뭘 실행해야할지 알게됨
            thread.start()  // 쓰레드 실행 -> 실행하라는 호출
        }

        // 시작하면 바로 실행
        Thread(object : Runnable {
            override fun run() {
                Log.d("thread-1", "Thread2 is made")
            }
        }).start()

        // 시작하면 바로 실행
        Thread(Runnable {
            Thread.sleep(2000)  // 2sec
            Log.d("thread-1", "Thread3 is made")
            // button.setBackgroundColor(getColor(R.color.textview_color)) -> UI Thread (MainThread)가 아니라서 오류!

            // 2초 sleep 후 ui thread 로 이동했음
            runOnUiThread {
                button.setBackgroundColor(getColor(R.color.textview_color))
            }
        }).start()
    }
}