package com.example.wordlecodepath

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.wordlecompleted.FourLetterWordList

class MainActivity : AppCompatActivity() {
    private val SPLASH_TIME_OUT: Long = 5500 // 3 sec
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rules)


        Handler().postDelayed({
            // This method will be executed once the timer is over
            // Start your app main activity

            val i = Intent(this, MainActivity3::class.java)
            startActivity(i)
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out)

            // close this activity
            finish()
        }, SPLASH_TIME_OUT)
//----------------------------------------------------------------------------
    }





}