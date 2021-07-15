package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

/**
 * This activity allows the user to roll a dice and view the result
 * on the screen.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.diceRollerButton)
        rollButton.setOnClickListener { rollDices() }

        // Do the dices roll when the app starts
        rollDices()
    }

    /**
     * Roll the dices and update the screen with the results.
     */
    private fun rollDices() {
        // Create new two Dice objects with 6-sides and
        val firstDice = Dice(6)
        val secondDice = Dice(6)

        // Roll the dices
        val firstDiceRoll = firstDice.roll()
        val secondDiceRoll = secondDice.roll()

        // Find the images that named are firstDiceImage and secondDiceImage in the Layout
        val firstDiceImage: ImageView = findViewById(R.id.firstDiceImage)
        val secondDiceImage: ImageView = findViewById(R.id.secondDiceImage)

        // Determine which drawable resource ID to use based on the first dice roll
        val firstDrawableResource = when (firstDiceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        // Determine which drawable resource ID to use based on the second dice roll
        val secondDrawableResource = when (secondDiceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        // Update the firstDiceImage and secondDiceImage with the correct drawable resource ID
        firstDiceImage.setImageResource(firstDrawableResource)
        secondDiceImage.setImageResource(secondDrawableResource)

        // Update the content descriptions
        firstDiceImage.contentDescription = firstDiceRoll.toString()
        secondDiceImage.contentDescription = secondDiceRoll.toString()

    }
}

class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}