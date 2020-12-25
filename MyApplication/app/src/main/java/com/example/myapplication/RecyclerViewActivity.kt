package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_recycler_view.*

class RecyclerViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        // AddViewActivity.kt
        val carList = ArrayList<CarForList>()
        for (i in 0 until 50) {
            carList.add(CarForList("" + i + " 번째 자동차", "" + i + "순위 엔진"))
        }

        val adapter = RecyclerViewAdapter(carList, LayoutInflater.from(this@RecyclerViewActivity))
        recycler_view.adapter = adapter
        // layout manager 설정
        recycler_view.layoutManager = LinearLayoutManager(this@RecyclerViewActivity)
        //recycler_view.layoutManager = GridLayoutManager(this@RecyclerViewActivity, 2)
    }
}

class RecyclerViewAdapter(
    val itemList: ArrayList<CarForList>,
    val inflater: LayoutInflater
) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {  // 생성자에서 받은 파라미터를 부모클래스에 넘겨준다
        val carName: TextView
        val carEngine: TextView

        // 이 클래스가 생성되자마자 바로 실행 (초기화 블록)
        init {
            // 2: 텍스트뷰 셋팅
            carName = itemView.findViewById(R.id.car_name)
            carEngine = itemView.findViewById(R.id.car_engine)

            itemView.setOnClickListener {
                val position: Int = adapterPosition // 이 변수가 포지션을 가지고 있음 (몇 번째인지)
                // inner 클래스는 outer 클래스에 접근할 수 없음 -> ViewHolder 클래스 안ㅍ에 inner 붙여준다
                val engineName = itemList.get(position).engine
                Log.d("engine", engineName)
            }
        }
    }

    // 뷰를 만들어줌 (1: 아이템 하나가 들어갈 뷰를 만들어 holder 에 넣는다)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = inflater.inflate(R.layout.item_view, parent, false)
        return ViewHolder(view)
    }

    // 아이템 개수 반환
    override fun getItemCount(): Int {
        return itemList.size
    }

    // 뷰를 그려준다 (3: 셋팅된 걸 불러와서 실제로 글자를 넣어준다)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.carName.setText(itemList.get(position).name)
        holder.carEngine.setText(itemList.get(position).engine)
    }
}