package com.example.crpapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import android.widget.ToggleButton
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.questions.*
import kotlin.math.pow

class Question: AppCompatActivity() {
    var b1 = 0.36
    var b2 = 0.35
    var b3zero = 0
    var b3 = 0.31
    var b4 = 0.45
    var b5 = 0.62
    var b6 = 0.5
    var b7 = 0.65
    var b8 = 0.7
    var b9 = 0.82
    var b10 = 0.52
    var b11 = 0.35
    var power = 7.12*(-1)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.questions)

        val aone: ToggleButton = findViewById(R.id.aone)
        aone.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                power += b1

            }
        }

        val atwo: ToggleButton = findViewById(R.id.atwo)
        atwo.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                power += b2


            }
        }

        athreezero.setOnClickListener {
            power += b3zero

        }

        athreeone.setOnClickListener {
            power += b3

        }

        athreetwo.setOnClickListener {
            power += b4

        }
        athreethree.setOnClickListener {
            power += b5

        }
        athreefour.setOnClickListener {
            power += b6

        }

        val afour: ToggleButton = findViewById(R.id.afour)
        afour.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                power += b7


            }
        }

        val afive: ToggleButton = findViewById(R.id.afive)
        afive.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                power += b8

            }
        }

        val asix: ToggleButton = findViewById(R.id.asix)
        asix.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                power += b9

            }
        }

        val aseven: ToggleButton = findViewById(R.id.aseven)
        aseven.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                power += b10

            }
        }

        val aeight: ToggleButton = findViewById(R.id.aeight)
        aeight.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                power += b11
            }
        }

        fun showBleedingInfo(view: View?) {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Information on Bleeding Disorder")
            builder.setMessage("Enter “yes” for any patient that has an active condition " +
                    "that places the patient at risk for excessive bleeding, such as: \n\n " +
                    "~ Vitamin K Deficiency\n" +
                    " ~ Hemophilia \n " +
                    "~ Thrombocytopenia \n " +
                    "~ Continuing Anticoagulation Therapy\n" +
                    " ~ Heparin-Induced Thrombocytopenia (HIT)\n" +
                    "\n NSAIDs or Prior HIT are excluded")
            builder.show()
        }


        bleedinginfo.setOnClickListener {
            showBleedingInfo(null)
        }

        fun showUrgentProcInfo(view: View?) {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Information on Urgent Procedure")
            builder.setMessage("Enter “yes” for patients who were inpatients or transferred" +
                    " from another inpatient facility, ED, or clinic, patients undergoing any " +
                    "emergency/urgent surgical case, patients admitted preoperatively for any " +
                    "reason (workup, hydration, bowel prep, TPN, anticoagulation reversal). \n \n" +
                    "Enter “no” for any patients brought to the hospital or facility for a " +
                    "scheduled (elective) surgery from their home or normal living situation " +
                    "(nursing home, care facility, etc.)")
            builder.show()
        }

        urgentinfo.setOnClickListener {
            showUrgentProcInfo(null)
        }

        submit.setOnClickListener {

            var e = 2.7182818284590452353602874713527
            var epow = e.pow(power)
            var denom = 1 + epow
            var quotient = epow/denom
            var risk = quotient * 100

            val number:Double = risk
            val number3digits:Double = Math.round(number * 1000.0) / 1000.0
            val number2digits:Double = Math.round(number3digits * 100.0) / 100.0
            val solution:Double = Math.round(number2digits * 10.0) / 10.0


            val intent = Intent(this, Submit::class.java)
            intent.putExtra("Risk Value",solution.toString())
            startActivity(intent)
        }
    }


}