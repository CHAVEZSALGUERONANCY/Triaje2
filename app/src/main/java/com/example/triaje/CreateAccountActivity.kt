package com.example.triaje

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.triaje.LoginActivity
import com.example.triaje.R
import com.example.triaje.api.CreateAccountRequest
import com.example.triaje.api.CreateAccountResponse
import com.example.triaje.api.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.widget.ArrayAdapter

class CreateAccountActivity : AppCompatActivity() {

    private lateinit var editTextNombre: EditText
    private lateinit var editTextApellido: EditText
    private lateinit var editTextClave: EditText
    private lateinit var editTextEmail: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var spinnerRole: Spinner // Spinner para el rol

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_account)

        // Referencias a los campos
        editTextNombre = findViewById(R.id.editTextNombre)
        editTextApellido = findViewById(R.id.editTextApellido)
        editTextClave = findViewById(R.id.editTextClave)
        editTextEmail = findViewById(R.id.editTextEmail)
        editTextPassword = findViewById(R.id.editTextPassword)



        val buttonCreateAccount: Button = findViewById(R.id.buttonCreateAccount)
        buttonCreateAccount.setOnClickListener {
            createAccount()
        }
    }

    private fun createAccount() {
        val nombre = editTextNombre.text.toString().trim()
        val apellido = editTextApellido.text.toString().trim()
        val clave = editTextClave.text.toString().trim()
        val correo = editTextEmail.text.toString().trim()
        val contrasena = editTextPassword.text.toString().trim()

        // Validaciones
        if (nombre.isEmpty() || apellido.isEmpty() || clave.isEmpty() || correo.isEmpty() || contrasena.isEmpty()) {
            Toast.makeText(this, "Por favor complete todos los campos", Toast.LENGTH_SHORT).show()
            return
        }

        // Validar formato de correo electrónico
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(correo).matches()) {
            Toast.makeText(this, "Correo electrónico inválido", Toast.LENGTH_SHORT).show()
            return
        }

        // Validar contraseña (mínimo 8 caracteres)
        if (contrasena.length < 8) {
            Toast.makeText(this, "La contraseña debe tener al menos 8 caracteres", Toast.LENGTH_SHORT).show()
            return
        }

        val request = CreateAccountRequest(nombre, apellido, clave, correo, contrasena)

        // Llamada Retrofit para crear la cuenta
        RetrofitClient.instance.createAccount(request).enqueue(object : Callback<CreateAccountResponse> {
            override fun onResponse(call: Call<CreateAccountResponse>, response: Response<CreateAccountResponse>) {
                if (response.isSuccessful) {
                    val createAccountResponse = response.body()
                    if (createAccountResponse != null && createAccountResponse.success == true) {
                        Toast.makeText(this@CreateAccountActivity, "Cuenta creada exitosamente", Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this@CreateAccountActivity, LoginActivity::class.java))
                        finish()
                    } else {
                        Toast.makeText(this@CreateAccountActivity, "Error: ${createAccountResponse?.message}", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(this@CreateAccountActivity, "Error al crear cuenta", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<CreateAccountResponse>, t: Throwable) {
                Toast.makeText(this@CreateAccountActivity, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }




}
