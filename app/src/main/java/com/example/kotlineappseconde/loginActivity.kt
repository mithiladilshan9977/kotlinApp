package com.example.kotlineappseconde

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class loginActivity : AppCompatActivity() {

    val auth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val emailAddress = findViewById(R.id.useremail) as EditText;
        val password = findViewById(R.id.userpassword) as EditText;

        val signUpButton = findViewById(R.id.signupbutton) as Button;
        val logInButton = findViewById(R.id.loginbutton) as Button;


        signUpButton.setOnClickListener {
            Toast.makeText(applicationContext, "You clicked me.", Toast.LENGTH_SHORT).show()
            val emailaddressofuser = emailAddress.text.toString();
            val userpassword = password.text.toString();

            if (emailaddressofuser.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(emailaddressofuser).matches()){
                Toast.makeText(baseContext, "empty email.",
                    Toast.LENGTH_SHORT).show()
                emailAddress.setError("Empty")


            }
            if (userpassword.length <= 6){

                Toast.makeText(baseContext, "Password is too short",
                    Toast.LENGTH_SHORT).show()
            }

            auth.createUserWithEmailAndPassword(emailaddressofuser, userpassword)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        val homeIntent = Intent(this , homeActivity::class.java)
                        homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                        startActivity(homeIntent)

                        emailAddress.text.clear()
                        password.text.clear()

                        Toast.makeText(baseContext, "Authentication succufull.",
                            Toast.LENGTH_SHORT).show()

                        val user = auth.currentUser

                    } else {

                        Toast.makeText(baseContext, "Authentication failed.",
                            Toast.LENGTH_SHORT).show()

                    }
                }

        }

        logInButton.setOnClickListener {
            val homeIntent = Intent(this , MainActivity::class.java)
            homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(homeIntent)


        }

    }
}