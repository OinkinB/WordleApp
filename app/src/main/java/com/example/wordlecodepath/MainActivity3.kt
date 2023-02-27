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

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        val handler = Handler()
        val delayInMillis = 3000L // 3 seconds



        val btn = findViewById<Button>(R.id.button)
        val text = findViewById<TextView>(R.id.textView)
        val et = findViewById<EditText>(R.id.editText)

        var word = FourLetterWordList.getRandomFourLetterWord()
        word = word.lowercase()
        println(word)
        var count  = 0
        var string = ""
        btn.setOnClickListener {
            var value = et.text.toString().lowercase()
            if(value == word){
                text.text = word
                handler.postDelayed({

                    val intent = Intent(this, MainActivity2::class.java)
                    startActivity(intent)

                }, delayInMillis)

                return@setOnClickListener

            }else if(count==2){

                text.text = word
                handler.postDelayed({
                    val intent = Intent(this, gameOver::class.java)
                    startActivity(intent)

                }, delayInMillis)

                return@setOnClickListener
            }


            if(value.length>4 ||value.length<4){
                Toast.makeText(this,"Please use 4 letters", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            text.text = value

            var i =0
            while (i < word.length) {

                if(word[i]==value[i]){

                    string  = string + "O"//value[i]
                    //word = removeCharAtIndex(word,i)
                }else if(value[i] in word){
                    string = string + "+"

                }else{
                    string = string + "X"
                }
                i++

            }



            /*val replacedChars = value.map {
                if (it !in word) '*' else it
            }
            val replacedString = replacedChars.joinToString("")
            println(replacedString) // prints "he**o***l*"*/
            //text.text = replacedString//countYes.toString()+countNo.toString()
            text.text = string
            count++
            string = ""
            et.setText("")


        }




    }
    fun removeCharAtIndex(str: String, index: Int): String {
        return str.substring(0, index) + str.substring(index + 1)
    }
    }
