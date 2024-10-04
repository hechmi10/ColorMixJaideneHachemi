package tn.esprit.colormixjaidenehachemi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.viewbinding.ViewBinding
import tn.esprit.colormixer.R

//TODO 2 Add string constant val here for RED / BLUE / YELLOW / PURPLE / GREEN / ORANGE

private const val RED="Red"
private const val BLUE="Blue"
private const val YELLOW="Yellow"
private const val PURPLE="Purple"
private const val GREEN="Green"
private const val ORANGE="Orange"

//TODO 3 Add string constant val here for NAME / MIXED_COLOR / COLOR1 / COLOR2 / RESULT / SUCCESS / FAILED

private const val NAME="Name"
private const val MIXED_COLOR="Mixed_Color"
private const val COLOR1="Color1"
private const val COLOR2="Color2"
private const val RESULT="Result"
private const val SUCCESS="Success"
private const val FAILED="Failed"

class QuestionActivity : AppCompatActivity() {

    //TODO 4 Add lateint var for binding
    private lateinit var binding: ViewBinding
    private lateinit var btnMix :Button

    //TODO 5 Add var for colorMixed / color1 / color2 / name
    private var colorMixed= MIXED_COLOR
    private var color1= COLOR1
    private var color2= COLOR2
    private var name= NAME

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //TODO 6 Bind the view and implement setContentView()
        setContentView(R.layout.activity_question)

        //TODO 7 Implement setOnClickListener on the button Mix and call mixColor()
        btnMix.setOnClickListener {
            mixColor()
        }

    }

    private fun mixColor(){

        //TODO 8 Check if the input for FullName. IF it's empty show a snackbar with the message : You must enter your name !

        //TODO 9 Check if Only 2 colors are selected then change the value of  colorMixed / color1 / color2

        //TODO 10 Change the value of name with the input

        //TODO 11 Create an Intent to AnswerActivity and add all of the values name / colorMixed / color1 / color2 Then start the Activity

    }
}