package com.example.loginsqlite

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class Login : AppCompatActivity() {

    private lateinit var loginbtt: Button
    private lateinit var edituser: EditText
    private lateinit var editpword: EditText
    private lateinit var dbh: DBHelp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginbtt = findViewById(R.id.bttLogin)
        edituser = findViewById(R.id.editTextTextPersonName2)
        editpword = findViewById(R.id.editTextTextPassword3)
        dbh = DBHelp(this)

        loginbtt.setOnClickListener {
            val useredtx = edituser.text.toString()
            val passdtx = editpword.text.toString()
            if(TextUtils.isEmpty(useredtx) || TextUtils.isEmpty(passdtx)){
                Toast.makeText(this,"Add Username & Password", Toast.LENGTH_SHORT).show()
            }
            else {
                val checkuser = dbh.checkuserpass(useredtx, passdtx)
                if(checkuser==true){
                    Toast.makeText(this,"Login Successful", Toast.LENGTH_SHORT).show()
                    val intent = Intent(applicationContext, Success::class.java)
                    startActivity(intent)
                }
                else {
                    Toast.makeText(this,"Wrong Username & Password", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}