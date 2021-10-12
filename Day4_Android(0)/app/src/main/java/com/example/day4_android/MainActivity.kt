package com.example.day4_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.io.Serializable

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        // List View
//        // khởi tạo đối tượng list view
//        val listView = findViewById<ListView>(R.id.listStudent)
//        // khởi tạo list các giá trị
//        val listStudent = arrayListOf("Student Duy", "Student Quang", "Student Duy")
//        // tạo adapter để đổ dữ liệu vào list view
//        listView.adapter = CustomAdapter(this@MainActivity, listStudent)

        // Recycle View
        // khởi tại list các student
        val listStudent = ArrayList<Student>()
        listStudent.add(Student("duynq", "Nguyen", "Duy", 21))
        listStudent.add(Student("nqduy", "Duy", "Nguyen", 22))
        listStudent.add(Student("nguyenqd", "Nguyen", "Quang", 19))
        listStudent.add(Student("duqn", "Quang", "Duy", 18))
        listStudent.add(Student("quangnd", "Duy", "Quang", 21))
        // tạo đối tượng recycler view
        val listRecycler: RecyclerView = findViewById(R.id.listStudent)
        // set layout cho list Recycler
        listRecycler.layoutManager = LinearLayoutManager(this)
        listRecycler.addItemDecoration(
            DividerItemDecoration(
                listRecycler.context,
                DividerItemDecoration.VERTICAL
            )
        )
        // tạo adapter để đổ dữ liệu vào
        listRecycler.adapter = RecyclerAdapter(listStudent)
    }
}

// đối tượng student
data class Student(val userName: String, val firstName: String, val lastName: String, val age: Int)
    : Serializable