package com.example.kotlineappseconde

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class adminActivity : AppCompatActivity() {



    private lateinit var database : DatabaseReference
    val auth: FirebaseAuth = FirebaseAuth.getInstance()
    val userID: String? = auth.currentUser?.uid

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin)

        val addietm = findViewById(R.id.additem) as Button;
        var itemname = findViewById<TextView>(R.id.itemName)
        var theprice = findViewById<TextView>(R.id.itemPrice)

        addietm.setOnClickListener {

            val stroeName = itemname.text.toString()
            val storeprice = theprice.text.toString()

            database = FirebaseDatabase.getInstance().getReference("Items")
             val User = User(stroeName , storeprice)
            database.child(stroeName).setValue(User).addOnSuccessListener {

                Toast.makeText(baseContext, "Item added",
                    Toast.LENGTH_SHORT).show()
            }
                .addOnFailureListener {
                    Toast.makeText(baseContext, "Something went wrong",
                        Toast.LENGTH_SHORT).show()
                }
            }

        }
    }
