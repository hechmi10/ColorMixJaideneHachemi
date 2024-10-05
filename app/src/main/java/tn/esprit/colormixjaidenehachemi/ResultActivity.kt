package tn.esprit.colormixjaidenehachemi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView

class ResultActivity : AppCompatActivity() {

    //TODO 18 Add lateint var for binding
    private lateinit var rlBackground: RelativeLayout
    private lateinit var imgResult: ImageView
    private lateinit var txtResult:TextView
    private lateinit var txtName:TextView
    private lateinit var txtAnswer:TextView
    private lateinit var quit: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //TODO 19 Bind the view and implement setContentView()
        setContentView(R.layout.activity_result)
        rlBackground=findViewById(R.id.rlBackground)
        imgResult=findViewById(R.id.imgResult)
        txtResult=findViewById(R.id.txtResult)
        txtName=findViewById(R.id.txtName)
        txtAnswer=findViewById(R.id.txtAnswer)
        quit=findViewById(R.id.btnQuit)


        //TODO 20 Check the RESULT from the intent and change rlBackground BackgroundColor / btnQuit BackgroundColor / imgResult / txtResult / txtName / txtAnswer
        val result=intent.getStringExtra("Result").toString()
        val name=intent.getStringExtra("Full_Name").toString()
        txtName.text="$name"
        if(result== SUCCESS){
            rlBackground.setBackgroundColor(resources.getColor(R.color.success))
            quit.setBackgroundColor(resources.getColor(R.color.success))
            imgResult.setImageResource(R.drawable.ic_success)
            txtResult.text="Congratulations"
            txtAnswer.text="Your answer is correct"
        }else{
            rlBackground.setBackgroundColor(resources.getColor(R.color.error))
            quit.setBackgroundColor(resources.getColor(R.color.error))
            imgResult.setImageResource(R.drawable.ic_failure)
            txtName.text="Better luck next time"
            txtAnswer.text="Your answer is wrong"

        }
        //TODO 21 Implement setOnClickListener for btnQuit to destroy the activity
        quit.setOnClickListener {
            finish()
        }
    }
}