package com.example.day4_android

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

// tự custom 1 adapter : truyền vào môi trường hiện tại và list dữ liệu cần show ra
class CustomAdapter(
    private val context: Context,
    private val dataSource: ArrayList<String>
) : BaseAdapter() {

    // chuyển layout file (xml) thành đối tượng view
    private val inflater: LayoutInflater =
        context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int {
        return dataSource.size
    }

    override fun getItem(position: Int): Any {
        return dataSource[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View
        val viewHolder: ListRowHolder
        // lần đầu tiên chạy, chưa có view nào
        if (convertView == null) {
            // chuyển đổi xml thành đối tượng view
            view = inflater.inflate(R.layout.item_list, parent, false)
            // truyền view vào list holder để khởi tạo lân đầu tiên
            viewHolder = ListRowHolder(view)
            // tag để lưu lại, các lần sau chạy chỉ việc lấy ra, không phải tạo lại nữa
            view.tag = viewHolder
        } else {// các lần sau chạy, khi mà view đã tồn tại
            view = convertView
            // lấy view được lưu ra sử dụng lại
            viewHolder = view.tag as ListRowHolder
        }
        // gán giá trị vào view
        viewHolder.textView?.text = dataSource[position]
        return view
    }

}

private class ListRowHolder(row: View) {
    var textView: TextView? = null

    init {
        this.textView = row?.findViewById(R.id.tvStudent) as TextView
    }
}
