package com.example.helloui

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Switch
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val inputNama = findViewById<EditText>(R.id.inputNama)
        val btnSapa = findViewById<Button>(R.id.btnSapa)
        val txtHasil = findViewById<TextView>(R.id.txtHasil)
        val switchTheme = findViewById<Switch>(R.id.switch1)

        btnSapa.setOnClickListener {
            val nama = inputNama.text.toString()
            txtHasil.text = "Hello $nama!"
        }

        switchTheme.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }
    }
}