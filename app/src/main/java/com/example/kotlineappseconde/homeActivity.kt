package com.example.kotlineappseconde

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class homeActivity : AppCompatActivity() {
    val auth = FirebaseAuth.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)



        val orderNowBtn = findViewById(R.id.addtoCart) as Button;
        val name = findViewById(R.id.elementName) as TextView;
        val realPrice = findViewById(R.id.realPrice) as TextView;
        val previousPrice = findViewById(R.id.previousPrice) as TextView;



        orderNowBtn.setOnClickListener {

            val namenext = name.text.toString();
            val pricenext = realPrice.text.toString()
            val previousPricenext = previousPrice.text.toString()

            val intent = Intent(this, orderActivity::class.java)
            intent.putExtra("nameOfElement",  namenext)
            intent.putExtra("ironprice",pricenext)
            intent.putExtra("previoudprice", previousPricenext)

            startActivity(intent)

        }

    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.adminpanel -> {

                val intent = Intent(this, adminActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)

                true
            }
            R.id.logout -> {

                auth.signOut()
                val intent = Intent(this, MainActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)



                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }




}