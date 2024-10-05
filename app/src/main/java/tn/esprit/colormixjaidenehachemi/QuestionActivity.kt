package tn.esprit.colormixjaidenehachemi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.viewbinding.ViewBinding
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import tn.esprit.colormixer.R

//TODO 2 Add string constant val here for RED / BLUE / YELLOW / PURPLE / GREEN / ORANGE

private const val RED="Red"
private const val BLUE="Blue"
private const val YELLOW="Yellow"
private const val PURPLE="Purple"
private const val GREEN="Green"
private const val ORANGE="Orange"

//TODO 3 Add string constant val here for NAME / MIXED_COLOR / COLOR1 / COLOR2 / RESULT / SUCCESS / FAILED

private var NAME="Name"
private var MIXED_COLOR="Mixed_Color"
private var COLOR1="Color1"
private var COLOR2="Color2"
private const val RESULT="Result"
private const val SUCCESS="Success"
private const val FAILED="Failed"

class QuestionActivity : AppCompatActivity() {

    //TODO 4 Add lateint var for binding
    private lateinit var FullName:TextInputEditText
    private lateinit var Mix :Button
    private lateinit var red:CheckBox
    private lateinit var blue:CheckBox
    private lateinit var yellow:CheckBox

    //TODO 5 Add var for colorMixed / color1 / color2 / name
    private var colorMixed= MIXED_COLOR
    private var color1= COLOR1
    private var color2= COLOR2
    private var name= NAME

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //TODO 6 Bind the view and implement setContentView()
        FullName=findViewById(R.id.tfFullName)
        Mix=findViewById(R.id.btnMix)
        red= findViewById(R.id.cbRed)
        blue=findViewById(R.id.cbBlue)
        yellow=findViewById(R.id.cbYellow)
        setContentView(R.layout.activity_question)

        //TODO 7 Implement setOnClickListener on the button Mix and call mixColor()
        Mix.setOnClickListener {
            mixColor()
        }

    }

    private fun mixColor(){

        //TODO 8 Check if the input for FullName. IF it's empty show a snackbar with the message : You must enter your name !
        val name=FullName.text.toString()
        if(name.equals(null)){
            Snackbar.make(FullName,"You must enter your name",Snackbar.LENGTH_SHORT).show()
        }

        //TODO 9 Check if Only 2 colors are selected then change the value of  colorMixed / color1 / color2
        val checkboxes= listOf(red,blue,yellow)
        val selectedColors= mutableListOf<String>();
        if (red.isChecked) selectedColors.add(RED)
        if (blue.isChecked) selectedColors.add(BLUE)
        if (yellow.isChecked) selectedColors.add(YELLOW)
        if (selectedColors.size==2){
            color1=selectedColors[0]
            color2=selectedColors[1]
            when{
                color1.equals(RED) && color2.equals(BLUE) -> colorMixed=PURPLE
                color1.equals(BLUE) && color2.equals(YELLOW) -> colorMixed=GREEN
                else -> colorMixed=ORANGE
            }
        }

        //TODO 10 Change the value of name with the input
        NAME=name

        //TODO 11 Create an Intent to AnswerActivity and add all of the values name / colorMixed / color1 / color2 Then start the Activity
        val intent= Intent(this,AnswerActivity::class.java)
        intent.putExtra("MIXED_COLOR", colorMixed)
        intent.putExtra("COLOR1",color1)
        intent.putExtra("COLOR2",color2)
        startActivity(intent)

    }
}