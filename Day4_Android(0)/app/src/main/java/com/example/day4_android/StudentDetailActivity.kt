package com.example.day4_android

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class StudentDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_detail)

        getData()
    }

    @SuppressLint("SetTextI18n")
    private fun getData() {
//        val userName = intent.extras?.get("uname").toString()
//        val firstName = intent.extras?.get("fname").toString()
//        val lastName = intent.extras?.get("lname").toString()
//        val age = intent.extras?.get("age").toString()
        // get student object
        val student = intent.extras?.get("student") as Student

        findViewById<TextView>(R.id.tvUserName).text = "User name: ${student.userName}"
        findViewById<TextView>(R.id.tvFirstName).text = "First name: ${student.firstName}"
        findViewById<TextView>(R.id.tvLastName).text = "Last name:${student.lastName}"
        findViewById<TextView>(R.id.tvAge).text = "Age: ${student.age}"
    }
}