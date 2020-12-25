package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.FragmentManager
import kotlinx.android.synthetic.main.activity_fragment.*

// TabLayout, Pager 실습하면서 필요 없는 부분이 오류 발생해서 지움
class FragmentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)
        Log.d("life_cycle", "onCreate")

        val fragmentOne: FragmentOne = FragmentOne()

        // 프라그먼트에 data 를 넣어주는 방법 -> Bundle 만들어서 Fragment 에 넣어준다
        val bundle : Bundle = Bundle()
        bundle.putString("hello", "hello")
        fragmentOne.arguments = bundle

        // 프라그먼트 붙이기
        button.setOnClickListener {
            // 프라그먼트를 동적으로 작동하는 방법
            // 프라그먼트를 붙이는 방법 replace / add (둘이 비슷함)
//            val fragmentOne: FragmentOne = FragmentOne()
            val fragmentManager: FragmentManager = supportFragmentManager   // supportFragmentManager: activity 가 가지고 있음

            // Transaction
            // 작업의 단위 -> 시작과 끝이 있다
            val fragmentTransaction = fragmentManager.beginTransaction()    // 시작
            fragmentTransaction.replace(R.id.container, fragmentOne)    // 할일
            fragmentTransaction.commit()    // 끝 -> 이거까지 해줘야 실행된다
            // 끝을 내는 방법
            // commit    -> 시간 될 때 해 (좀 더 안정적)
            // commitNow -> 지금 당장 해
        }

        // 프라그먼트 떼기
        button2.setOnClickListener {
//            // 실행 안됨 -> why? 새로 만든걸 뗀다고 했으니까! 위에서 붙인 애랑 아래랑 다르다
//            val fragmentOne: FragmentOne = FragmentOne()
            val fragmentManager = supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            // remove, detach 차이: remove 는 다시 붙일 수 있다.
            // 그런데 실제 개발하면서 다시 붙일 일은 많이 없음
            fragmentTransaction.remove(fragmentOne)
            fragmentTransaction.commit()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("life_cycle", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("life_cycle", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("life_cycle", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("life_cycle", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("life_cycle", "onDestroy")
    }
}