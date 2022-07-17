package com.neppplus.todolist_recyclerview_20220717.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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