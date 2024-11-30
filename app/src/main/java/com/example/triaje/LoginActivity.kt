package com.example.triaje

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.triaje.api.LoginRequest
import com.example.triaje.api.LoginResponse
import com.example.triaje.api.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {

    private lateinit var editTextEmail: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var buttonLogin: Button
    private lateinit var textViewCreateAccount: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Inicializar elementos
        editTextEmail = findViewById(R.id.editTextEmail)
        editTextPassword = findViewById(R.id.editTextPassword)
        buttonLogin = findViewById(R.id.buttonLogin)
        textViewCreateAccount = findViewById(R.id.textViewCreateAccount)

        // Acción del botón de login
        buttonLogin.setOnClickListener {
            login()
        }

        // Redirigir a la pantalla de creación de cuenta
        textViewCreateAccount.setOnClickListener {
            val intent = Intent(this, CreateAccountActivity::class.java)
            startActivity(intent)
        }
    }

    // Verificar si hay conexión a Internet
    private fun isNetworkAvailable(): Boolean {
        val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val network = connectivityManager.activeNetwork
        val networkCapabilities = connectivityManager.getNetworkCapabilities(network)
        return networkCapabilities != null && networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
    }



    private fun login() {
        val correo = editTextEmail.text.toString()
        val contrasena = editTextPassword.text.toString()

        if (correo.isEmpty() || contrasena.isEmpty()) {
            Toast.makeText(this, "Por favor, complete todos los campos.", Toast.LENGTH_SHORT).show()
            return
        }

        // Verificar si hay conexión a Internet antes de intentar el login
        if (!isNetworkAvailable()) {
            Toast.makeText(this, "No hay conexión a Internet", Toast.LENGTH_SHORT).show()
            return
        }

        val request = LoginRequest(correo, contrasena)
        val call = RetrofitClient.instance.login(request)

        call.enqueue(object : Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                if (response.isSuccessful) {
                    val loginResponse = response.body()

                    // Verificar que la respuesta no es nula
                    if (loginResponse != null) {
                        Log.d("LoginResponse", "Respuesta completa del servidor: $loginResponse")

                        // Verificar si el inicio de sesión fue exitoso
                        if (loginResponse.success) {
                            Log.d("LoginResponse", "Inicio de sesión exitoso")
                            Toast.makeText(this@LoginActivity, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show()

                            // Guardar el token en SharedPreferences y RetrofitClient
                            loginResponse.token?.let {
                                guardarToken(it)
                                RetrofitClient.updateToken(it)  // Establecer el token en RetrofitClient
                            }

                            // Guardar el idUsuario en SharedPreferences
                            loginResponse.idUsuario?.let {
                                guardarIdUsuario(it)
                            }

                            // Redirigir a la HomeActivity
                            val intent = Intent(this@LoginActivity, HomeActivity::class.java)
                            startActivity(intent)
                            finish()
                        } else {
                            val errorMessage = loginResponse.message ?: "Error desconocido"
                            Log.d("LoginResponse", "Error: $errorMessage")
                            Toast.makeText(this@LoginActivity, "Error: $errorMessage", Toast.LENGTH_SHORT).show()
                        }
                    } else {
                        Toast.makeText(this@LoginActivity, "Respuesta nula del servidor", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(this@LoginActivity, "Error en el servidor. Inténtalo de nuevo.", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                Toast.makeText(this@LoginActivity, "Error de conexión: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }


    // Guardar el token en SharedPreferences
    private fun guardarToken(token: String) {
        val sharedPreferences = getSharedPreferences("APP_PREFS", MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString("TOKEN", token)
        editor.apply()
        Log.d("LoginActivity", "Token guardado: $token")
    }

    // Guardar el idUsuario en SharedPreferences
    private fun guardarIdUsuario(idUsuario: Long) {
        val sharedPreferences = getSharedPreferences("APP_PREFS", MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putLong("ID_USUARIO", idUsuario)
        editor.apply()
    }
}
