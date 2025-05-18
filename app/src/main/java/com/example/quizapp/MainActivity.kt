package com.example.quizapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
//Toast.makeText(this, "Please enter a time period of a day.", Toast.LENGTH_LONG).show()//
        val txtAppGreetings = findViewById<TextView>(R.id.txtAppGreetings)
        val txtAppDescription = findViewById<TextView>(R.id.txtAppInfo)
        val btnMainQuiz = findViewById<Button>(R.id.btnQuiz)
        //val btnQuizzes = findViewById<Button>(R.id.btnQuizzes)
        val btnGame = findViewById<Button>(R.id.btnGame)
        val btnExit = findViewById<Button>(R.id.btnExit)


        txtAppGreetings.text="Welcome to Quizzes and Game"
        txtAppDescription.text="True or False questions about basketball"








    }
}