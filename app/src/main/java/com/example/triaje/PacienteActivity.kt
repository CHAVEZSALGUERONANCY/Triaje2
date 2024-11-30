package com.example.triaje
import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity


class PacienteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_paciente)

        // Encuentra el botón por su ID
        val addButton = findViewById<ImageButton>(R.id.add_button)

        // Configura el listener para abrir la nueva actividad
        addButton.setOnClickListener {
            val intent = Intent(this, AddPacienteActivity::class.java)
            startActivity(intent)
        }
    }
}