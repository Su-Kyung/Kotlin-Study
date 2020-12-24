package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_list_view.*
import org.w3c.dom.Text

class ListViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        // AddViewActivity.kt
        val carList = ArrayList<CarForList>()
        for (i in 0 until 50) {
            carList.add(CarForList("" + i + " 번째 자동차", "" + i + "순위 엔진"))
        }

        val adapter = ListViewAdapter(carList, LayoutInflater.from(this@ListViewActivity))   // 아래에서 만든 Adapter
        listView.adapter = adapter

        // 클릭하면 토스트메세지 띄우기
        listView.setOnItemClickListener { parent, view, position, id ->
            val carName = (adapter.getItem(position) as CarForList).name
            val carEngine = (adapter.getItem(position) as CarForList).engine

            Toast.makeText(this@ListViewActivity, carName + " " + carEngine, Toast.LENGTH_SHORT).show()
        }
    }
}

class ListViewAdapter(
    // 생성자
    val carForList: ArrayList<CarForList>,
    val layoutInflater : LayoutInflater
) : BaseAdapter() {
    
    // 뷰를 그림
    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
//        val view = layoutInflater.inflate(R.layout.item_view, null)
//
//        // 개선이 필요한 코드 (findViewById : 오래 걸린다!) -> ViewHolder 활용
//        val carNameTextView = view.findViewById<TextView>(R.id.car_name)
//        val carEngineTextView = view.findViewById<TextView>(R.id.car_engine)
//
//        carNameTextView.setText(carForList.get(p0).name)
//        carEngineTextView.setText(carForList.get(p0).engine)
//
//        return view

        val view : View
        val holder : ViewHolder

        // 중요!
        if (p1 == null) {   // p1 는 convertView
            Log.d("convert", "1")
            view = layoutInflater.inflate(R.layout.item_view, null)
            holder = ViewHolder()

            holder.carName = view.findViewById(R.id.car_name)
            holder.carEngine = view.findViewById(R.id.car_engine)

            view.tag = holder
        } else {    // convert 있다면
            Log.d("convert", "2")
            holder = p1.tag as ViewHolder
            view = p1
        }

        holder.carName?.setText(carForList.get(p0).name )   //p0 는 position
        holder.carEngine?.setText((carForList.get(p0).engine))

        return view
    }

    // 아이템 가져옴
    override fun getItem(p0: Int): Any {
        // 그리고자 하는 아이템 리스트의 하나 (포지션에 해당하는)
        return carForList.get(p0)
    }

    // 아이디 부여
    override fun getItemId(p0: Int): Long {
        // 해당 포지션에 위치해 있는 아이템뷰의 아이디 설정
        return p0.toLong()
    }

    // 전체 사이즈 알려줌
    override fun getCount(): Int {
        // 그리고자 하는 아이템 리스트의 전체 개수
        return carForList.size
    }
}

class ViewHolder{
    var carName: TextView? = null
    var carEngine: TextView? = null
}