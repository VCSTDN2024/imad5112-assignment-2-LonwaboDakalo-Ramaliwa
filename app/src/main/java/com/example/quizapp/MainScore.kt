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

class MainScore : AppCompatActivity() {

    private lateinit var txtScore: TextView
    private lateinit var txtResult: TextView
    private lateinit var btnReview: Button
    private lateinit var btnExit: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_score)

        val txtScore = findViewById<TextView>(txtScore)
        val txtResult = findViewById<TextView>(txtResult)
        val btnReview = findViewById<Button>(btnReview)
        val btnExit = findViewById<Button>(btnExit)


        val score = intent.getIntExtra("Score", 0)
        txtScore.text = "Your Score: $score/5"

        val feedback = if (score >= 3) {
            "Well Done!"
        } else {
            "Nice Effort!"
        }
        txtResult.text = feedback


        btnReview.setOnClickListener {
            val intent = Intent(this, MainReview::class.java)
            intent.putExtra("questions", MainQuiz.questions)
            intent.putExtra("answers", MainQuiz.answers)
            startActivity(intent)
        }


        btnExit.setOnClickListener {
            finishAffinity()
            exitProcess(0)
        }


    }

    private fun <T> findViewById(txtScore: T): T {

        return TODO("Provide the return value")
    }
}