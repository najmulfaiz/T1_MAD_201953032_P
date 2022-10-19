package com.example.t1_mad_201953032_p

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private lateinit var btnMulai: Button;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnMulai = findViewById(R.id.btnMulai)

        btnMulai.setOnClickListener {
            val pemesananIntent = Intent(this, PemesananActivity::class.java)
            startActivity(pemesananIntent)
        }
    }
}