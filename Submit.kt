package com.example.crpapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import android.widget.ToggleButton
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.questions.*
import kotlinx.android.synthetic.main.submit.*

class Submit: AppCompatActivity() {
    var greater = "greater than"
    var less = "less than"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.submit)

        val riskValue = intent.getStringExtra("Risk Value")

        fun check(): String {
            return if (riskValue.toDouble() > 0.3) {
                greater
            } else {
                less
            }
        }

        risk.text = "Predicted probability of post-discharge VTE: " + riskValue + "%"
        messageone.text = "This patient has a " + riskValue + "% risk of developing a deep vein thrombosis or pulmonary embolism after discharge from the hospital."
        var show = check()

        messagetwo.text = "This risk is " + show + " the threshold of 0.3%. At this" +
                " threshold, the sensitivity is 55% and the specificity is 64%. 35% of" +
                " patients fall into this category of risk. \n \n Thromboprophylaxis after" +
                " discharge should be considered. For example, Lovenox at 40mg SC" +
                " once daily."

        redo.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }


    }


}