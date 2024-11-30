package com.example.triaje

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.triaje.api.Hospital
import com.example.triaje.api.HospitalResponse
import com.example.triaje.api.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HospitalActivity : AppCompatActivity() {
    private lateinit var editTextNombre: EditText
    private lateinit var editTextDireccion: EditText
    private lateinit var editTextTelefono: EditText
    private lateinit var btn_save_patient: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hospital)

        // Inicializar elementos
        editTextNombre = findViewById(R.id.editTextNombre)
        editTextDireccion = findViewById(R.id.editTextDirecion)
        editTextTelefono = findViewById(R.id.editTextTelefono)
        btn_save_patient = findViewById(R.id.btn_save_patient)

        // Configurar el clic del botón
        btn_save_patient.setOnClickListener {
            saveHospital()
        }
    }

    private fun saveHospital() {
        val nombre_hospital = editTextNombre.text.toString()
        val direccion = editTextDireccion.text.toString()
        val telefono = editTextTelefono.text.toString()

        // Validar campos
        if (nombre_hospital.isEmpty() || direccion.isEmpty() || telefono.isEmpty()) {
            Toast.makeText(this, "Por favor, complete todos los campos.", Toast.LENGTH_SHORT).show()
            return
        }

        // Validar número de teléfono
        if (!telefono.matches(Regex("\\d{7,10}"))) {
            Toast.makeText(this, "Ingrese un número de teléfono válido.", Toast.LENGTH_SHORT).show()
            return
        }

        // Crear la solicitud
        val request = Hospital(nombre_hospital, direccion, telefono)

        // Mostrar el progress dialog
        val progressDialog = ProgressDialog(this)
        progressDialog.setMessage("Guardando datos...")
        progressDialog.setCancelable(false)
        progressDialog.show()

        // Llamar al servicio de la API
        val call = RetrofitClient.instance.createHospital(request)
        call.enqueue(object : Callback<HospitalResponse> {
            override fun onResponse(
                call: Call<HospitalResponse>,
                response: Response<HospitalResponse>
            ) {
                progressDialog.dismiss()
                if (response.isSuccessful) {
                    val body = response.body()
                    if (body?.success == true) {
                        // Si la respuesta es exitosa
                        Toast.makeText(
                            this@HospitalActivity,
                            "Hospital creado exitosamente",
                            Toast.LENGTH_SHORT
                        ).show()
                        // Redirigir a la pantalla principal
                        val intent = Intent(this@HospitalActivity, MainActivity::class.java)
                        startActivity(intent)
                        finish() // Finalizar la actividad actual
                    } else {
                        // Si `success` es false, mostrar el mensaje de error
                        Toast.makeText(
                            this@HospitalActivity,
                            "Error: ${body?.message ?: "Respuesta inesperada"}",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                } else {
                    // Si la respuesta no es exitosa
                    val errorMessage = response.errorBody()?.string() ?: "Error desconocido"
                    Toast.makeText(
                        this@HospitalActivity,
                        "Error: $errorMessage",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            override fun onFailure(call: Call<HospitalResponse>, t: Throwable) {
                progressDialog.dismiss()
                Toast.makeText(
                    this@HospitalActivity,
                    "Fallo la conexión: ${t.message}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }
}