package com.example.kotlineappseconde

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    val auth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        FirebaseApp.initializeApp(this)


    }
    override fun onStart() {
        super.onStart()
        val currentuser = auth.currentUser;
        if (currentuser != null){
            navigateHome();
        }
    }

    private fun navigateHome() {
        val homeIntent = Intent(this , homeActivity::class.java)
        startActivity(homeIntent)
    }
}