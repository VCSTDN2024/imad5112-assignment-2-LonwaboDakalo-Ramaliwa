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
        val questions = arrayOf( //All Questions relate to the NBA
            "The player with the most points in a game is Wilt Chamberlain",
            "Bill Russell won 11 championships in only 13 seasons",
            "Kobe Bryant scored 81 points in a nba game",
            "Kevin Durant won a championship with the Oklahoma City Thunder",
            "Tim Duncan has played for multiple teams in the NBA", // 5 Questions
            "The Charlotte Hornets are the newest team in the nba",
            "Giannis Antentokounmpo is the last player in the NBA to win the MIP, MVP, DPOY, Finals MVP and Conference MVP",
            "Victor Wembanyama is the tallest player in the league",
            "The Boston Celtics have the most championship titles in the nba",
            "Lebron James and Steph Curry were born in the same town, Akron Ohio", // 10 Questions
            "The Oklahoma City Thunder are the replacements of the Seattle SuperSonics",
            "Shai Gilgeous-Alexander is a Canadian born player in the NBA",
            "Giannis Antentokounmpo is a Greek-Nigerian player in the NBA",
            "Steve Nash is a Canadian born player in the NBA",
            "Tim Duncan is known as the Big Fundamental", // 15 Questions
            "Glen Davis is known as Big Baby",
            "Phil Jackson is the most successful coach with 11 championship titles",
            "Wilt Chamberlain was the first NBA player to dunk",
            "There is 32 teams in the NBA league",
            "Teams with the worst records can be relegated to the G-League" // 20 Questions
        )
        val answers = booleanArrayOf(true, true, true , false, false, true, true, false, true, true, true, true, true, false, true, true, true, false, false, false )
        // Answers to corresponding questions with the same index number

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
        if (currentQuestionIndex < questions.size) {
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