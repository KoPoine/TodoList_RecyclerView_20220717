package com.neppplus.todolist_recyclerview_20220717.adapters

import android.content.Context
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.neppplus.todolist_recyclerview_20220717.R
import com.neppplus.todolistpractice_20220717.datas.TodoData

class TodoRecyclerViewAdapter (
    val mContext: Context,
    val mList : ArrayList<TodoData>
        ): RecyclerView.Adapter<TodoRecyclerViewAdapter.MyViewHolder>() {

    inner class MyViewHolder (view : View) : RecyclerView.ViewHolder(view) {
        fun bind(item : TodoData) {
//            실제 데이터를 한칸 xml의 각 태그에 배치
            val todoRatingBar = itemView.findViewById<RatingBar>(R.id.todoRatingBar)
            val todoTxt = itemView.findViewById<TextView>(R.id.todoTitleTxt)
            val finishedCb = itemView.findViewById<CheckBox>(R.id.finishedCb)

            todoRatingBar.rating = item.rating.toFloat()
            todoTxt.text = item.todoTitle
            finishedCb.isChecked = item.isFinished

//            체크 박스 체크되어있다면 > 완료되었기에 TextView에 취소선 긋기
            if (item.isFinished) {
                todoTxt.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
            } else {
                todoTxt.paintFlags = 0
            }

//            체크박스가 클릭되었을때 (체크 여부 변경 감지 이벤트) > TextView에 취소선 긋기
            finishedCb.setOnCheckedChangeListener { compoundButton, isChecked ->
                if (isChecked) {
                    todoTxt.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
                } else {
                    todoTxt.paintFlags = 0
                }
            }

        }
    }

    //    한칸의 xml을 실제 view와 연결
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val row = LayoutInflater.from(mContext).inflate(R.layout.todo_list_item, parent, false)
        return MyViewHolder(row)
    }

    //    우리만든 ViewHolder 클래스에 실제 데이터 연결
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(mList[position])
    }

    //    전체 리스트의 갯수
    override fun getItemCount(): Int {
        return mList.size
    }

}