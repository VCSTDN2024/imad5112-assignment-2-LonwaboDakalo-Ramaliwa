package com.example.quizapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random
import kotlin.system.exitProcess

class Studybreak : AppCompatActivity() {
    private var randomNumber : Int = 0
    private var txtInput : EditText? = null
    private var txtResult : TextView? = null

    private fun generateRandomNumber(){
        randomNumber = Random.nextInt(1, 100)
    }

    private fun isNotEmpty() : Boolean {

        var b = true
        if(txtInput?.text.toString().trim().isEmpty()){
            txtInput?.error = "Please enter a value"
            b = false
        }
        return  b
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_studybreak)


        generateRandomNumber()

        txtInput = findViewById(R.id.txtInput)
        txtResult = findViewById(R.id.txtResult)

        val btnGuess = findViewById<Button>(R.id.btnGuess)
        val btnClear = findViewById<Button>(R.id.btnClear)
        val btnExit = findViewById<Button>(R.id. btnExit)

        btnGuess.setOnClickListener {
                if (isNotEmpty()) {

                    val guessNumber = txtInput?.text.toString().trim().toInt()

                    if (guessNumber == randomNumber) {

                        txtResult?.text = "Great! $guessNumber is the correct number."
                    } else
                        if (guessNumber > randomNumber) {
                            txtResult?.text = "Sorry, $guessNumber is too high."
                        } else
                        {
                            txtResult?.text = "Sorry, $guessNumber is too low."
                        }

                }

        }

        btnClear.setOnClickListener {
            txtInput?.text?.clear()
            generateRandomNumber()
            txtResult?.text = ""
        }

        btnExit.setOnClickListener{
            finishAffinity()
            exitProcess(0)
        }



    }
}