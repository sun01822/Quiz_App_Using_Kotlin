package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton

class Question5 : AppCompatActivity() {
    private lateinit var submit : Button
    private lateinit var next : Button
    private lateinit var rb1 : RadioButton
    private lateinit var rb2 : RadioButton
    private lateinit var rb3 : RadioButton
    private lateinit var rb4 : RadioButton
    private lateinit var name : String
    private var points : Int = 0
    private var checker : Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question5)
        rb1 = findViewById(R.id.rb1)
        rb2 = findViewById(R.id.rb2)
        rb3 = findViewById(R.id.rb3)
        rb4= findViewById(R.id.rb4)
        submit = findViewById(R.id.submit)
        next = findViewById(R.id.next)
        name = intent.getStringExtra("name").toString()
        points = intent.getIntExtra("points", 0)
        next.visibility = View.GONE

        submit.setOnClickListener {
            if(rb1.isChecked){
                checker = 1
            }
            else if(rb2.isChecked){
                checker = 2
            }
            else if(rb3.isChecked){
                checker = 3
            }
            else if(rb4.isChecked){
                checker = 4
            }

            if (checker == 1) {
                points++
            }
            else{
                rb1.setBackgroundResource(R.drawable.correct_answer)
                if(checker==2){
                    rb2.setBackgroundResource(R.drawable.wrong_answer)
                    rb2.setTextColor(Color.WHITE)
                    rb3.setBackgroundResource(R.drawable.default_radio_button)
                    rb4.setBackgroundResource(R.drawable.default_radio_button)
                }
                else if(checker==3){
                    rb2.setBackgroundResource(R.drawable.default_radio_button)
                    rb3.setBackgroundResource(R.drawable.wrong_answer)
                    rb3.setTextColor(Color.WHITE)
                    rb4.setBackgroundResource(R.drawable.default_radio_button)
                }
                else if(checker==4){
                    rb2.setBackgroundResource(R.drawable.default_radio_button)
                    rb3.setBackgroundResource(R.drawable.default_radio_button)
                    rb4.setBackgroundResource(R.drawable.wrong_answer)
                    rb4.setTextColor(Color.WHITE)
                }

            }
            submit.visibility = View.GONE
            next.visibility = View.VISIBLE
        }

        next.setOnClickListener {
            val intent = Intent(this, ResultPage::class.java)
            intent.putExtra("name", name)
            intent.putExtra("points", points)
            startActivity(intent)
            finish()

        }
    }
}