package tn.esprit.colormixjaidenehachemi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import com.google.android.material.textview.MaterialTextView

class AnswerActivity : AppCompatActivity() {

    // TODO 12 Add lateint var for binding
    private lateinit var purple: RadioButton
    private lateinit var green: RadioButton
    private lateinit var orange: RadioButton
    private lateinit var radioGroup:RadioGroup
    private lateinit var submit: Button
    private var correctColor = "NONE"
    private var name = "NONE"
    private var color1 = "NONE"
    private var color2 = "NONE"
    private lateinit var txtChosen: MaterialTextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO 13 Bind the view and implement setContentView()
        setContentView(R.layout.activity_answer)
        purple = findViewById(R.id.rbPurple)
        green = findViewById(R.id.rbGreen)
        orange = findViewById(R.id.rbOrange)
        radioGroup=findViewById(R.id.radioGroup)
        submit = findViewById(R.id.btnSubmit)
        txtChosen = findViewById(R.id.txtChoosed)


        // TODO 14 Change the value of correctColor / name / color1 / color2 with the DATA from the INTENT
        correctColor = intent.getStringExtra(MIXED_COLOR).toString()
        name = intent.getStringExtra(NAME).toString()
        color1 = intent.getStringExtra(COLOR1).toString()
        color2 = intent.getStringExtra(COLOR2).toString()

        // TODO 15 Change the txtChoosed with: "You chose $color1 and $color2"
        txtChosen.text = "You chose $color1 and $color2"

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
        val chosenColor:String = when(radioGroup.checkedRadioButtonId) {
            R.id.rbPurple -> PURPLE
            R.id.rbGreen ->  GREEN
            else -> ORANGE
        }

        if (chosenColor.isBlank()) {
            return false
        }

        val isCorrect = chosenColor == correctColor
        val intent = Intent(this, ResultActivity::class.java)
        intent.putExtra(NAME, name)
        intent.putExtra(RESULT, if (isCorrect) SUCCESS else FAILED)
        startActivity(intent)
        return true
    }
}
