package name.pack.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import java.util.Random

class MainActivity : AppCompatActivity() {

    private lateinit var diceImageView: ImageView
    private lateinit var rollButton: Button
    private lateinit var resultTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        diceImageView = findViewById(R.id.diceImageView)
        rollButton = findViewById(R.id.rollButton)
        resultTextView = findViewById(R.id.resultTextView)

        rollButton.setOnClickListener {
            rollDice()
        }
    }

    private fun rollDice() {
        val random = Random()
        val randomNumber = random.nextInt(6) + 1 // Generates a random number between 1 and 6
        val imageName = "dice$randomNumber" // e.g., "dice_3" for a roll of 3
        val imageResourceId = resources.getIdentifier(imageName, "drawable", packageName)

        diceImageView.setImageResource(imageResourceId)
        resultTextView.text = "You rolled a $randomNumber"
    }
}
