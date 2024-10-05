package tn.esprit.colormixjaidenehachemi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast
import com.google.android.material.textview.MaterialTextView

class AnswerActivity : AppCompatActivity() {

    // TODO 12 Add lateint var for binding
    private lateinit var purple: CheckBox
    private lateinit var green: CheckBox
    private lateinit var orange: CheckBox
    private lateinit var submit: Button
    private var correctColor = "NONE"
    private var name = "NONE"
    private var color1 = "NONE"
    private var color2 = "NONE"
    private lateinit var txtChoosed: MaterialTextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO 13 Bind the view and implement setContentView()
        setContentView(R.layout.activity_answer)
        purple = findViewById(R.id.rbPurple)
        green = findViewById(R.id.rbGreen)
        orange = findViewById(R.id.rbOrange)
        submit = findViewById(R.id.btnSubmit)
        txtChoosed = findViewById(R.id.txtChoosed)


        // TODO 14 Change the value of correctColor / name / color1 / color2 with the DATA from the INTENT
        correctColor = intent.getStringExtra("Mixed_Color") ?: "NONE"
        name = intent.getStringExtra("Full_Name") ?: "NONE"
        color1 = intent.getStringExtra("Color1") ?: "NONE"
        color2 = intent.getStringExtra("Color2") ?: "NONE"

        // TODO 15 Change the txtChoosed with: "You chose $color1 and $color2"
        txtChoosed.text = "You chose $color1 and $color2"

        // TODO 16 Implement setOnClickListener on the btnSubmit and call checkAnswer()
        submit.setOnClickListener {
            val isValid = checkAnswer()
            if (!isValid) {
                Toast.makeText(this, "Please select one color.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun checkAnswer(): Boolean {

        // TODO 17 Check if the answer of the chosen color is correct
        var chosenColor = ""
        when {
            purple.isChecked -> chosenColor = PURPLE
            green.isChecked -> chosenColor = GREEN
            else -> chosenColor = ORANGE
        }

        if (chosenColor.isBlank()) {
            // No color was selected, return false
            return false
        }

        val isCorrect = chosenColor == correctColor
        val intent = Intent(this, ResultActivity::class.java)
        intent.putExtra("Full_Name", name)
        intent.putExtra("Result", if (isCorrect) SUCCESS else FAILED)
        startActivity(intent)
        return true
    }
}
