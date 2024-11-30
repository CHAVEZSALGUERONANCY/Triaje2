package com.example.triaje

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {

    private lateinit var tvGreeting: TextView
    private lateinit var searchCard: CardView
    private lateinit var searchEditText: EditText
    private lateinit var searchIcon: ImageView
    private lateinit var bottomNavigation: BottomNavigationView
    private lateinit var btnSaveSpecialists: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // Inicialización de vistas
        tvGreeting = findViewById(R.id.tv_greeting)
        searchCard = findViewById(R.id.search_card)
        searchEditText = findViewById(R.id.search_edit_text)
        searchIcon = findViewById(R.id.search_icon)
        bottomNavigation = findViewById(R.id.bottom_navigation)
        btnSaveSpecialists = findViewById(R.id.btn_save_specialists)

        // Obtener el nombre del usuario desde SharedPreferences
        val sharedPreferences: SharedPreferences = getSharedPreferences("MyAppPrefs", MODE_PRIVATE)
        val userName = sharedPreferences.getString("username", "Usuario")

        // Configurar el saludo al usuario
        tvGreeting.text = "Hola, $userName."

        // Configurar el comportamiento del icono de búsqueda
        searchIcon.setOnClickListener {
            val query = searchEditText.text.toString()
            if (query.isNotEmpty()) {
                performSearch(query)
            }
        }

        // Configurar el botón para dirigir a TriajeActivity
        btnSaveSpecialists.setOnClickListener {
            val intent = Intent(this, TriajeActivity::class.java)
            startActivity(intent)
        }

        // Configurar el menú inferior
        bottomNavigation.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_documentos -> {
                    startActivity(Intent(this, PacienteActivity::class.java))
                    true
                }
                R.id.medical -> {
                    startActivity(Intent(this, MedicamentoActivity::class.java))
                    true
                }
                R.id.nav_ubicacion -> {
                    startActivity(Intent(this, HospitalActivity::class.java))
                    true
                }
                R.id.nav_perfil -> {
                    startActivity(Intent(this, PerfilActivity::class.java))
                    true
                }
                else -> false
            }
        }
    }

    private fun performSearch(query: String) {
        // Implementa la lógica de búsqueda aquí
    }
}
