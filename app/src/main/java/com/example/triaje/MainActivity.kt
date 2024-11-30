package com.example.triaje


import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Configura un delay de 5 segundos
        Handler().postDelayed({
            // Inicia la actividad de inicio de sesión después de 5 segundos
            val intent = Intent(this, LoginActivity::class.java) // Cambia LoginActivity por el nombre de tu actividad de login
            startActivity(intent)
            finish() // Finaliza MainActivity para que no se pueda volver atrás
        }, 5000) // 5000 milisegundos = 5 segundos
    }
}
