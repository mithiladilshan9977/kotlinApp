package com.example.kotlineappseconde

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class orderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        val name = findViewById(R.id.ironname) as TextView;
        val price = findViewById(R.id.ironprice) as TextView;


        val receivedValue = intent.getStringExtra("nameOfElement")
        val ironprice = intent.getStringExtra("ironprice")
        val previoudprice = intent.getStringExtra("previoudprice")

        name.text = receivedValue
        price.text = ironprice



    }
}