package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SecondScreen : AppCompatActivity() {
    private lateinit var name : EditText
    private lateinit var startQuiz : Button
    private lateinit var nameText : String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_screen)
        name = findViewById(R.id.name)
        startQuiz = findViewById(R.id.startQuiz)

        startQuiz.setOnClickListener {
            nameText = name.text.toString()
            if (nameValidation(nameText)) {
                val intent = Intent(this, Question1::class.java)
                intent.putExtra("name", nameText)
                startActivity(intent)
                finish()
            } else {
                name.setBackgroundResource(R.drawable.custom_edit_text_error_background)
                Toast.makeText(this, R.string.errorMessage, Toast.LENGTH_SHORT).show()
            }
        }

    }

    private fun nameValidation(name: String):Boolean{
        return name.isNotEmpty()
    }
}