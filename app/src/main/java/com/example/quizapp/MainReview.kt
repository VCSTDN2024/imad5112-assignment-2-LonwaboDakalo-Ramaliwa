package com.example.quizapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.system.exitProcess

class MainReview : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()


        val txtReview = findViewById<TextView>(R.id.txtReview)
       // val btnGame = findViewById<Button>(R.id.btnGame)
        val btnRestart = findViewById<Button>(R.id.btnRestart)
        val btnExit = findViewById<Button>(R.id.btnExit)


        val questions = intent.getStringArrayExtra("questions")
        val answers = intent.getBooleanArrayExtra("answers")

        val reviewText = StringBuilder()
        if (questions != null && answers != null && questions.size == answers.size){
            for (i in questions.indices) {
                reviewText.append("${i + 1}.  ${questions[i]}\n")
                reviewText.append(" Answer:${if (answers[i]) "True" else "False"}\n")
            }
            txtReview.text = reviewText.toString()
        } else{
            txtReview.text = "Error loading your review data."
        }

        btnRestart.setOnClickListener {
            startActivity(Intent(this, MainQuiz::class.java))
       }

       btnExit.setOnClickListener {
            finishAffinity()
            exitProcess(0)
       }


    }
}