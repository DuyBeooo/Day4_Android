package com.example.day4_android

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter : RecyclerView.Adapter<ListRowHolder2> {
    private var dataSource: ArrayList<Student> = ArrayList()

    constructor(data: ArrayList<Student>) : super() {
        this.dataSource = data
    }

    // khởi tạo list holder từ file item .xml
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListRowHolder2 {
        return ListRowHolder2(
            LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        )
    }

    // đẩy dữ liệu vào từng row, xử lí sự kiện khi click vào button
    override fun onBindViewHolder(holder: ListRowHolder2, position: Int) {
        holder.textView.text = dataSource[position].userName
        holder.btnDetail.setOnClickListener {
            // lấy view hiện tại từ holder để làm context tạo Intent
            val view = holder.row.context
            val intent = Intent(view, StudentDetailActivity::class.java)
            intent.putExtra("student",dataSource[position])
            view.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return dataSource.size
    }
}
// class list holder
class ListRowHolder2(row: View) : RecyclerView.ViewHolder(row) {
    var textView: TextView = row.findViewById(R.id.tvStudent)
    var btnDetail: Button = row.findViewById(R.id.btnDetail)
    val row = row
}
