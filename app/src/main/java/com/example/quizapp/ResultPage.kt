package com.example.quizapp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import kotlin.system.exitProcess

class ResultPage : AppCompatActivity() {
    private lateinit var message : TextView
    private lateinit var champion : ImageView
    private lateinit var end : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_page)
        message = findViewById(R.id.message)
        end = findViewById(R.id.end)
        champion = findViewById(R.id.champion)

        val name = intent.getStringExtra("name")
        val points = intent.getIntExtra("points", 0)

        if(points == 5){
            message.text = "Congratulations $name!!!\nYou have answered all the questions correctly and get $points out of 5"
            Glide.with(this).load(R.drawable.champion).into(champion)
        }
        else{
            message.text = "Ohhh $name...\nYou have not answered all the questions and get $points out of 5"
            Glide.with(this).load(R.drawable.sad).into(champion)
        }


        end.setOnClickListener {
            moveTaskToBack(true);
            exitProcess(-1)
        }
    }
}