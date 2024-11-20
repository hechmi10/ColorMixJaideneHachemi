package tn.esprit.colormixjaidenehachemi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import tn.esprit.colormixjaidenehachemi.databinding.ActivityQuestionBinding

//TODO 2 Add string constant val here for RED / BLUE / YELLOW / PURPLE / GREEN / ORANGE

//Initialisation des couleurs
const val RED = "Red"
const val BLUE = "Blue"
const val YELLOW = "Yellow"
const val PURPLE = "Purple"
const val GREEN = "Green"
const val ORANGE = "Orange"

//TODO 3 Add string constant val here for NAME / MIXED_COLOR / COLOR1 / COLOR2 / RESULT / SUCCESS / FAILED

//Initialiser des autres constantes
const val NAME = "Name"
const val MIXED_COLOR = "Mixed_Color"
const val COLOR1 = "Color1"
const val COLOR2 = "Color2"
const val RESULT = "Result"
const val SUCCESS = "Success"
const val FAILED = "Failed"

class QuestionActivity : AppCompatActivity() {

    //TODO 4 Add lateint var for binding
    //Déclarer le binding entre l'activité
    private lateinit var binding: ActivityQuestionBinding

    //TODO 5 Add var for colorMixed / color1 / color2 / name
    //Initialiser des variables pour l'intent
    private var colorMixed:String = ""
    private var color1:String = ""
    private var color2:String = ""
    private var name :String= ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //TODO 6 Bind the view and implement setContentView()
        //Activer le binding pour recevoir tous les ids et puis modifier le contenu de l'activité
        binding= ActivityQuestionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //TODO 7 Implement setOnClickListener on the button Mix and call mixColor()
        //Ajuster l'évenement du clic pour qu'il active la méthode du mélange des couleurs
        binding.btnMix.setOnClickListener {
            mixColor()
        }
    }

    private fun mixColor() {
        //TODO 8 Check if the input for FullName. If it's empty, show a snackbar with the message: "You must enter your name!"
        name = binding.tfFullName.text.toString()
        //Vérifier si le nom est saisi
        if (name.isBlank()) {
            Snackbar.make(binding.root, "You must enter your name", Snackbar.LENGTH_SHORT).show()
            return
        }

        //TODO 9 Check if only 2 colors are selected, then update the values of colorMixed, color1, and color2
        val selectedColors = mutableListOf<String>()
        if (binding.cbRed.isChecked) selectedColors.add(RED)
        if (binding.cbBlue.isChecked) selectedColors.add(BLUE)
        if (binding.cbYellow.isChecked) selectedColors.add(YELLOW)

        if (selectedColors.size == 2) {
            color1 = selectedColors[0]
            color2 = selectedColors[1]
            colorMixed = when {
                (color1 == RED && color2 == BLUE) || (color1 == BLUE && color2== RED) -> PURPLE
                (color1 == BLUE && color2 == YELLOW) || (color1==YELLOW && color2==BLUE) -> GREEN
                else -> ORANGE
            }

        } else {
            Snackbar.make(binding.root, "Please select exactly two colors", Snackbar.LENGTH_SHORT).show()
            return
        }

        //TODO 10 Change the value of name with the input
        //voir TODO 8

        //TODO 11 Create an Intent to AnswerActivity and pass all of the values (name, colorMixed, color1, color2), then start the activity
        //Naviguer vers l'activité de choisir la réponse correcte
        val intent = Intent(this, AnswerActivity::class.java).apply{
            intent.putExtra(NAME, name)
            intent.putExtra(MIXED_COLOR, colorMixed)
            intent.putExtra(COLOR1, color1)
            intent.putExtra(COLOR2, color2)
        }
        startActivity(intent)
    }
}
