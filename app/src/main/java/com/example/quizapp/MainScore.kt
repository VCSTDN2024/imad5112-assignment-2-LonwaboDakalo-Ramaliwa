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

        val txtScore = findViewById<TextView>(R.id.txtScore)
        val txtResult = findViewById<TextView>(R.id.txtResult)
        val btnReview = findViewById<Button>(R.id.btnReview)
        val btnExit = findViewById<Button>(R.id.btnExit)


        val score = intent.getIntExtra("score", 0)
        txtScore.text = "Your Score: $score/20"

        val feedback = if (score >= 12) {
            "Well Done!"
        } else {
            "Nice Effort!"
        }
        txtResult.text = feedback


        btnReview.setOnClickListener {
            val intent = Intent(this, Review::class.java)
            intent.putExtra("questions", MainQuiz.questions)
            intent.putExtra("answers", MainQuiz.answers)
            startActivity(intent)
        }


        btnExit.setOnClickListener {
            finishAffinity()
            exitProcess(0)
        }


    }

}