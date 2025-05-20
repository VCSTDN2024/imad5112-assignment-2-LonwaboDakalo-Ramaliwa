package com.example.quizapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.system.exitProcess

class BestPlayers : AppCompatActivity() {

    private lateinit var playerRank : EditText
    private lateinit var btnClr : Button
    private lateinit var btnRank : Button
    private lateinit var btnHome : Button
    private lateinit var dispPlayer : TextView
    private lateinit var btnExit : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_best_players)
        playerRank = findViewById(R.id.playerRank)
        btnClr = findViewById(R.id.btnClr)
        btnRank = findViewById(R.id.btnRank)
        btnHome = findViewById(R.id.btnHome)
        dispPlayer = findViewById(R.id.dispPlayer)
        btnExit = findViewById(R.id.btnExit)


        btnRank.setOnClickListener{
            handleBtnAgeClick()
        }

        btnClr.setOnClickListener{
            handleBtnClrClick()
        }

        btnExit.setOnClickListener{
            finishAffinity()
            exitProcess(0)
        }
        btnHome.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "Welcome to back to the home page!", Toast.LENGTH_LONG).show()
        }
    }
    private fun handleBtnAgeClick(){
        val numberInput = playerRank.text.toString()
        if (numberInput.isEmpty()){
            dispPlayer.text = "Please enter a number from 1 - 10"
            return
        }

        val number = numberInput.toIntOrNull()
        if (number == null){
            dispPlayer.text = "The number is an invalid format.Please enter a valid whole number."
            return
        }

        if (number<1 || number>12){
            dispPlayer.text= "The number is out of range."
            Toast.makeText(this, "Enter a number from 1 - 10", Toast.LENGTH_LONG).show()
            return
        }

        val matchedPerson = matchAgeToRank(number)
        dispPlayer.text = matchedPerson
    }

    private fun matchAgeToRank(number:Int): String{
        val players = mapOf(
            "Shai Gilgeous-Alexander" to 1,
            "Nikola Jokic" to 2,
            "Anthony Edwards" to 3,
            "Jalen Brunson." to 4,
            "Tyrese Haliburton" to 5,
            "Karl Anthony Towns" to 6,
            "Myles Turner" to 7,
            "Jaylen Williams" to 8,
            "Jayson Tatum" to 9,
            "Giannis Antentokounmpo" to 10
        )
        for ((person, rank) in players){
            if(number == rank){
                return "$person"
            }
        }
        return "No player at that rank"
    }
    private fun handleBtnClrClick(){
        playerRank.text.clear()
        dispPlayer.text = ""
    }


}