package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.inputmethod.CorrectionInfo
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainQuiz : AppCompatActivity() {

    private lateinit var txtQuestions: TextView
    private lateinit var btnTrue: Button
    private lateinit var btnFalse: Button
    private lateinit var btnNext: Button
    private lateinit var txtFeedback: TextView

    companion object {
        val questions = arrayOf(
            "The Sun Rises in the East and sets in The West",
            "The moon has 8 moon cycles",
            "Dr Umar is a doctor",
            "The first made was a Volkswagon",
            "Kendrick Lamar is the first rapper with a Pulitzer Award"
        )
        val answers = booleanArrayOf(true, true, false, false, true)


    }
    private var currentQuestionIndex = 0
    private var score = 0

    private fun displayQuestion() {
        txtQuestions.text = questions[currentQuestionIndex]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_quiz)

       txtQuestions = findViewById(R.id.txtQuestions)
       txtFeedback = findViewById(R.id.txtFeedback)
        btnTrue = findViewById(R.id.btnTrue)
        btnFalse = findViewById(R.id.btnFalse)
        btnNext = findViewById(R.id.btnNext)

        displayQuestion()

        btnTrue.setOnClickListener{ checkAnswer(true) }
        btnFalse.setOnClickListener{ checkAnswer(false) }


        btnNext.setOnClickListener{
        currentQuestionIndex++
        if (currentQuestionIndex < questions.size){
            displayQuestion()
            txtFeedback.text = ""
            btnTrue.isEnabled = true
            btnFalse.isEnabled = true
        }
        else {
            val intent = Intent(this, MainScore::class.java)
            intent.putExtra("score", score)
            startActivity(intent)
            finish()
        }
          btnNext.isEnabled = false


        }




    }

    private fun checkAnswer(userAnswer: Boolean){
        val correctAnswer = answers[currentQuestionIndex]

        if (userAnswer == correctAnswer) {
            txtFeedback.text = "Correct!"
            txtFeedback.setTextColor(Color.GREEN)
            score++
        } else {
            txtFeedback.text = "Incorrect!"
            txtFeedback.setTextColor(Color.RED)
        }
        btnTrue.isEnabled = false
        btnFalse.isEnabled = false
        btnNext.isEnabled = true
    }

}