package com.example.quizapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val txtAppGreetings = findViewById<TextView>(R.id.txtAppGreetings)
        val txtAppDescription = findViewById<TextView>(R.id.txtAppInfo)
        val btnQuiz = findViewById<Button>(R.id.btnQuiz)
        //val btnQuizzes = findViewById<Button>(R.id.btnQuizzes)
        val btnGame = findViewById<Button>(R.id.btnGame)
        val btnExit = findViewById<Button>(R.id.btnExit)


        txtAppGreetings.text="Welcome to Quizzes and Game"
        txtAppDescription.text="True or False questions about basketball"


        btnGame.setOnClickListener{
            val intent = Intent( this, GuessGame::class.java) //Takes to study game: Guess the number
            startActivity(intent)

        }

        btnQuiz.setOnClickListener{
            val intent = Intent( this, MainQuiz::class.java) //Takes to quiz: Basketball Quiz
            startActivity(intent)
            Toast.makeText(this, "Once you start the quiz you cannot exit until it is completed.", Toast.LENGTH_LONG).show()//
        }

        btnExit.setOnClickListener {
            finishAffinity()
            exitProcess(0)
        }


    }
}