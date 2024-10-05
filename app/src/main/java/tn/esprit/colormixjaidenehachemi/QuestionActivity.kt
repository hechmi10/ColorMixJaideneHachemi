package tn.esprit.colormixjaidenehachemi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

//TODO 2 Add string constant val here for RED / BLUE / YELLOW / PURPLE / GREEN / ORANGE

private const val RED = "Red"
private const val BLUE = "Blue"
private const val YELLOW = "Yellow"
const val PURPLE = "Purple"
const val GREEN = "Green"
const val ORANGE = "Orange"

//TODO 3 Add string constant val here for NAME / MIXED_COLOR / COLOR1 / COLOR2 / RESULT / SUCCESS / FAILED

private const val NAME = "Name"
private const val MIXED_COLOR = "Mixed_Color"
private const val COLOR1 = "Color1"
private const val COLOR2 = "Color2"
private const val RESULT = "Result"
const val SUCCESS = "Success"
const val FAILED = "Failed"

class QuestionActivity : AppCompatActivity() {

    //TODO 4 Add lateint var for binding
    private lateinit var FullName: TextInputEditText
    private lateinit var Mix: Button
    private lateinit var red: CheckBox
    private lateinit var blue: CheckBox
    private lateinit var yellow: CheckBox

    //TODO 5 Add var for colorMixed / color1 / color2 / name
    private var colorMixed = ""
    private var color1 = ""
    private var color2 = ""
    private var name = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //TODO 6 Bind the view and implement setContentView()
        setContentView(R.layout.activity_question)
        FullName = findViewById(R.id.tfFullName)
        Mix = findViewById(R.id.btnMix)
        red = findViewById(R.id.cbRed)
        blue = findViewById(R.id.cbBlue)
        yellow = findViewById(R.id.cbYellow)

        //TODO 7 Implement setOnClickListener on the button Mix and call mixColor()
        Mix.setOnClickListener {
            mixColor()
        }
    }

    private fun mixColor() {
        //TODO 8 Check if the input for FullName. If it's empty, show a snackbar with the message: "You must enter your name!"
        name = FullName.text.toString()
        if (name.isBlank()) {
            Snackbar.make(FullName, "You must enter your name", Snackbar.LENGTH_SHORT).show()
            return
        }

        //TODO 9 Check if only 2 colors are selected, then update the values of colorMixed, color1, and color2
        val selectedColors = mutableListOf<String>()
        if (red.isChecked) selectedColors.add(RED)
        if (blue.isChecked) selectedColors.add(BLUE)
        if (yellow.isChecked) selectedColors.add(YELLOW)

        if (selectedColors.size == 2) {
            color1 = selectedColors[0]
            color2 = selectedColors[1]
            colorMixed = when {
                color1 == RED && color2 == BLUE -> PURPLE
                color1 == BLUE && color2 == YELLOW -> GREEN
                else -> ORANGE
            }
        } else {
            Snackbar.make(FullName, "Please select exactly two colors", Snackbar.LENGTH_SHORT).show()
            return
        }

        //TODO 10 Change the value of name with the input
        // NAME=name is unnecessary because 'name' is a local variable and you are already assigning it earlier

        //TODO 11 Create an Intent to AnswerActivity and pass all of the values (name, colorMixed, color1, color2), then start the activity
        val intent = Intent(this, AnswerActivity::class.java).apply {
            intent.putExtra("Mixed_Color", colorMixed)
            intent.putExtra("Color1", color1)
            intent.putExtra("Color2", color2)
            intent.putExtra("Full_Name", name)
        }
        startActivity(intent)

        // Provide feedback on the activity transition
        Toast.makeText(this, "Navigating to AnswerActivity", Toast.LENGTH_SHORT).show()
    }
}
