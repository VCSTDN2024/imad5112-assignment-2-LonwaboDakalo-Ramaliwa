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

class Review : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_review)


        val reviewTextView = findViewById<TextView>(R.id.review_text_view)
        val btnStudyBreak = findViewById<Button>(R.id.btnStudyBreak)
        val restartBtn = findViewById<Button>(R.id.restart_button)
        val exitBtn = findViewById<Button>(R.id.exit_button)


        val questions = intent.getStringArrayExtra("questions")
        val answers = intent.getBooleanArrayExtra("answers")

        val reviewText = StringBuilder()
        if (questions != null && answers != null && questions.size == answers.size) {
            for (i in questions.indices) {
                reviewText.append("${i + 1}. ${questions[i]}\n")
                reviewText.append("     Answer: ${if (answers[i]) "True" else "False"}\n\n")
            }
            reviewTextView.text = reviewText.toString()
        } else{
            reviewTextView.text = "Error loading review data"
        }


        restartBtn.setOnClickListener{
            startActivity(Intent(this, MainQuiz::class.java))
        }

        exitBtn.setOnClickListener{
            finishAffinity()
            exitProcess(0)
        }

        btnStudyBreak.setOnClickListener{
            val intent = Intent( this, Studybreak::class.java) //Takes to study game: Guess the number
            startActivity(intent)

        }
    }
}