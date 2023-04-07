package com.example.kotlineappseconde

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class orderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        val name = findViewById(R.id.ironname) as TextView;
        val price = findViewById(R.id.ironprice) as TextView;
        val userplaceorderbtn = findViewById<Button>(R.id.placeorderbtn)

        userplaceorderbtn.setOnClickListener {
            val homeIntent = Intent(this , homeActivity::class.java)
            homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(homeIntent)
            Toast.makeText(baseContext,  "Oder is placed",
                Toast.LENGTH_SHORT).show()
        }


        val receivedValue = intent.getStringExtra("nameOfElement")
        val ironprice = intent.getStringExtra("ironprice")
        val previoudprice = intent.getStringExtra("previoudprice")

        name.text = receivedValue
        price.text = ironprice



    }
}