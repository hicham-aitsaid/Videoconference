package com.dev.videoconference

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_sign_up.*


class SignUp : AppCompatActivity() {

    var mAuth: FirebaseAuth? = null
    private val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        mAuth = FirebaseAuth.getInstance()

    }


    fun up(view: View){
        var mail = email.text.toString()
        var pass = password.text.toString()
        mAuth!!.createUserWithEmailAndPassword(mail, pass)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    var intent = Intent(applicationContext,MainActivity::class.java)
                    startActivity(intent)
                    Toast.makeText(this, "compte créé", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Erreur", Toast.LENGTH_SHORT).show()
                }
            }


    }

   /* fun SignUp(view: View?) {
        if (email.text.matches(emailPattern.toRegex())) {
            Toast.makeText(applicationContext, "Valid email address",
                Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(applicationContext, "Invalid email address",
                Toast.LENGTH_SHORT).show()
        }
    }*/
}