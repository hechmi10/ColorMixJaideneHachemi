package tn.esprit.colormixjaidenehachemi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import tn.esprit.colormixjaidenehachemi.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    //TODO 18 Add lateint var for binding
    //Déclarer le binding entre l'activité et les données
    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //TODO 19 Bind the view and implement setContentView()
        //Lier l'activité aux données
        binding= ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //TODO 20 Check the RESULT from the intent and change rlBackground BackgroundColor / btnQuit BackgroundColor / imgResult / txtResult / txtName / txtAnswer
        //Afficher le résultat du réponse correcte ou incorrecte
        val result=intent.getStringExtra(RESULT).toString()
        val name=intent.getStringExtra(NAME).toString()
        if(result== SUCCESS){
            binding.rlBackground.setBackgroundColor(resources.getColor(R.color.success))
            binding.btnQuit.setBackgroundColor(resources.getColor(R.color.success))
            binding.imgResult.setImageResource(R.drawable.ic_success)
            binding.txtResult.text="Success"
            binding.txtName.text="Congratulations $name"
            binding.txtAnswer.text="Your answer is correct"
        }else{
            binding.rlBackground.setBackgroundColor(resources.getColor(R.color.error))
            binding.btnQuit.setBackgroundColor(resources.getColor(R.color.error))
            binding.imgResult.setImageResource(R.drawable.ic_failure)
            binding.txtResult.text="Failure"
            binding.txtName.text="Better luck next time $name"
            binding.txtAnswer.text="Your answer is wrong"

        }
        //TODO 21 Implement setOnClickListener for btnQuit to destroy the activity
        //Retourner dans l'activité précedente
        binding.btnQuit.setOnClickListener {
            finish()
        }
    }
}