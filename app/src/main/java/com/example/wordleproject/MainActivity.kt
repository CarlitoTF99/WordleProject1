package com.example.wordleproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.util.Collections.min
import kotlin.math.min

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val word = findViewById<EditText>(R.id.word)
        val button = findViewById<Button>(R.id.button)

        //turn 1
        val displayWord1 = findViewById<TextView>(R.id.word1)
        val displayResult1 = findViewById<TextView>(R.id.word1Result)

        val guess1 = findViewById<TextView>(R.id.guess1)
        val guess1Check = findViewById<TextView>(R.id.guess1Check)

        //turn 2
        val displayWord2 = findViewById<TextView>(R.id.word2)
        val displayResult2 = findViewById<TextView>(R.id.word2Result)

        val guess2 = findViewById<TextView>(R.id.guess2)
        val guess2Check = findViewById<TextView>(R.id.guess2Check)

        //turn 3
        val displayWord3 = findViewById<TextView>(R.id.word3)
        val displayResult3 = findViewById<TextView>(R.id.word3Result)

        val guess3 = findViewById<TextView>(R.id.guess3)
        val guess3Check = findViewById<TextView>(R.id.guess3Check)


        //end
        val mainResult = findViewById<TextView>(R.id.mainResult)


        var turn = 1
        val wordd = FourLetterWordList()
        val randomWord = wordd.getRandomFourLetterWord()

        button.setOnClickListener() {
            val guess = word.text.toString().lowercase()
            val result = checkGuess(guess, randomWord)

            if (turn == 1) {
                guess1.visibility = View.VISIBLE
                guess1Check.visibility = View.VISIBLE

                displayWord1.text = guess
                displayResult1.text = result

                turn++
            } else if (turn == 2) {
                guess2.visibility = View.VISIBLE
                guess2Check.visibility = View.VISIBLE

                displayWord2.text = guess
                displayResult2.text = result

                turn++

            } else if (turn == 3) {

                guess3.visibility = View.VISIBLE
                guess3Check.visibility = View.VISIBLE

                displayWord3.text = guess
                displayResult3.text = result

                turn++
            } else {
                mainResult.text = randomWord
                button.visibility = View.INVISIBLE
                Toast.makeText(applicationContext, "No more tries left!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun checkGuess(guess: String, wordToGuess: String) : String {
        var result = ""
        for (i in 0..3) {
            if (guess[i] == wordToGuess[i]) {
                result += "O"
            }
            else if (guess[i] in wordToGuess) {
                result += "+"
            }
            else {
                result += "X"
            }
        }
        return result
    }
}