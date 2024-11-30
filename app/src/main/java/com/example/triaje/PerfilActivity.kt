package com.example.triaje

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.triaje.api.PerfilResponse
import com.example.triaje.api.RetrofitClient
import com.google.android.material.bottomnavigation.BottomNavigationView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PerfilActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil)

        // Configuración del BottomNavigationView
        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigation.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_documentos -> {
                    startActivity(Intent(this, PacienteActivity::class.java)) // Cambia PacienteActivity por la actividad correcta
                    true
                }
                R.id.medical -> {
                    startActivity(Intent(this, MedicamentoActivity::class.java)) // Cambia MedicamentoActivity por la actividad correcta
                    true
                }
                R.id.nav_ubicacion -> {
                    startActivity(Intent(this, HospitalActivity::class.java)) // Cambia HospitalActivity por la actividad correcta
                    true
                }
                R.id.nav_perfil -> {
                    true // Estamos en PerfilActivity, no hacemos nada
                }
                else -> false
            }
        }
        bottomNavigation.selectedItemId = R.id.nav_perfil // Marca la opción actual como seleccionada

        // Recupera el token de SharedPreferences
        val sharedPreferences = getSharedPreferences("APP_PREFS", MODE_PRIVATE)
        val token = sharedPreferences.getString("TOKEN", "") ?: ""

        // Log para verificar que el token se ha recuperado correctamente
        Log.d("PerfilActivity", "Token recuperado: $token")

        if (token.isNotEmpty()) {
            cargarPerfil("Bearer $token")
        } else {
            Toast.makeText(this, "Token no encontrado", Toast.LENGTH_SHORT).show()
        }
    }

    private fun cargarPerfil(token: String) {
        // Usamos la instancia de RetrofitClient directamente
        val api = RetrofitClient.instance

        // Log para verificar que estamos enviando el token correcto
        Log.d("PerfilActivity", "Token enviado: $token")

        api.obtenerPerfil(token).enqueue(object : Callback<PerfilResponse> {
            override fun onResponse(
                call: Call<PerfilResponse>,
                response: Response<PerfilResponse>
            ) {
                if (response.isSuccessful) {
                    val perfil = response.body()
                    perfil?.let {
                        // Actualiza la UI con los datos del perfil
                        mostrarPerfil(it)
                    }
                } else {
                    // Si la respuesta no es exitosa, mostramos el código de error
                    Toast.makeText(this@PerfilActivity, "Error al obtener perfil: ${response.message()}", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<PerfilResponse>, t: Throwable) {
                // Mostrar el error si la solicitud falla
                Log.e("PerfilActivity", "Error al cargar perfil: ${t.message}")
                Toast.makeText(this@PerfilActivity, "Error de conexión: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun mostrarPerfil(perfil: PerfilResponse) {
        // Muestra un saludo con el nombre y apellido
        Toast.makeText(this, "Bienvenido ${perfil.nombre} ${perfil.apellido}", Toast.LENGTH_LONG).show()

        // Asigna los valores de perfil a los elementos de la UI
        val editTextNombre = findViewById<EditText>(R.id.editTextNombre)
        editTextNombre.setText(perfil.nombre)

        val editTextApellido = findViewById<EditText>(R.id.editTextApellido)
        editTextApellido.setText(perfil.apellido)

        val editTextEmail = findViewById<EditText>(R.id.editTextEmail)
        editTextEmail.setText(perfil.correo)

        val editTextRol = findViewById<EditText>(R.id.editTextRol)
        editTextRol.setText(perfil.nom_rol)

        // Si deseas mostrar otros datos o imágenes, también puedes agregarlo aquí
        // Por ejemplo, si tienes una URL de imagen:
        // Glide.with(this).load(perfil.imagenUrl).into(imageView)
    }
}
