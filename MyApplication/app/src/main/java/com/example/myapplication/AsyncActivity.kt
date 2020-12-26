package com.example.myapplication

import android.content.Intent
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ProgressBar
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_async.*
import java.lang.Exception

class AsyncActivity : AppCompatActivity() {

    var task: BackgroundAsyncTask? = null
    var task1: BackgroundAsyncTask? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_async)

        start.setOnClickListener {
            task = BackgroundAsyncTask(progressbar, ment)
            task1 = BackgroundAsyncTask(progressbar, ment)
            task?.execute()
            task1?.execute()    // 테스트해보면 task 가 끝난 후에 task1 이 시작됨을 알 수 있다 (병렬처리 안된다)
        }

        stop.setOnClickListener {
            //task?.cancel(true)
            // test : 구현된 Activity 가 종료될 경우 따라서 종료되지 않는다
            startActivity(Intent(this, Intent2::class.java))
        }
    }

    // 작업 정지
    override fun onPause() {
        task?.cancel(true)
        super.onPause()
    }
}

class BackgroundAsyncTask(
    val progressBar: ProgressBar,
    val progressText: TextView
) : AsyncTask<Int, Int, Int>() {
    // params -> doInBackground 에서 사용할 타입
    // progress -> onProgressUpdate 에서 사용할 타입
    // result -> onPostExecute 에서 사용할 타입

    var percent: Int = 0

    override fun onPreExecute() {
        percent = 0
        progressBar.setProgress(percent)
    }

    override fun doInBackground(vararg p0: Int?): Int {
        while (isCancelled() == false) {    // onCancelled 가 아니다! 주의
            percent++
            // test : 구현된 Activity 가 종료될 경우 따라서 종료되지 않는다 -> 라이프사이클 활용 (onPause)
            Log.d("async", "value : " + percent)

            if(percent > 100) {
                break
            } else {
                publishProgress(percent)
            }

            // 컴퓨터의 연산은 매우 빠르다! -> 변화를 보기 위해 sleep
            try {
                Thread.sleep(50)
            } catch (e: Exception) {
                e.printStackTrace() // 어떤 오류가 발생했는지 찍어봄
            }
        }

        return percent
    }

    override fun onProgressUpdate(vararg values: Int?) {
        progressBar.setProgress(values[0] ?:0)  // 엘비스연산자
        progressText.setText("퍼센트 : " + values[0])
        super.onProgressUpdate(*values)
    }

    override fun onPostExecute(result: Int?) {
        progressText.setText("작업이 완료되었습니다.")
    }

    override fun onCancelled() {
        progressBar.setProgress(0)
        progressText.setText("작업이 취소되었습니다.")
    }
}