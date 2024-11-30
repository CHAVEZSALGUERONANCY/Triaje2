package com.example.triaje

import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.triaje.api.Hospital
import com.example.triaje.api.Hospitales
import com.example.triaje.api.Paciente
import com.example.triaje.api.PacienteResponse
import com.example.triaje.api.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AddPacienteActivity : AppCompatActivity() {

    private lateinit var editTextNombre: EditText
    private lateinit var editTextApellido: EditText
    private lateinit var editTextFolio: EditText
    private lateinit var editTextEdad: EditText
    private lateinit var spinnerGenero: Spinner
    private lateinit var spinnerHospital: Spinner
    private lateinit var btnSavePatient: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_paciente)

        // Inicializar vistas
        editTextNombre = findViewById(R.id.editTextNombre)
        editTextApellido = findViewById(R.id.editTextApellido)
        editTextFolio = findViewById(R.id.editTextFolio)
        editTextEdad = findViewById(R.id.editTextEdad)
        spinnerGenero = findViewById(R.id.spinnerGenero)
        spinnerHospital = findViewById(R.id.spinnerHospital)
        btnSavePatient = findViewById(R.id.btn_save_patient)

        // Configurar el listener del botón
        btnSavePatient.setOnClickListener {
            validateHospitalAndSavePaciente()  // Validar hospital y luego guardar paciente
        }

        // Llenar el Spinner de géneros
        loadGeneros()

        // Llamada para cargar los hospitales desde la API
        loadHospitales()
    }

    // Método para llenar el Spinner de géneros
    private fun loadGeneros() {
        val generos = listOf("Masculino", "Femenino")
        val generoAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, generos)
        generoAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerGenero.adapter = generoAdapter
    }

    // Método para llenar el Spinner de hospitales desde la API
    private fun loadHospitales() {
        val apiService = RetrofitClient.instance
        val call = apiService.getHospitales() // Consulta a la API para obtener hospitales

        call.enqueue(object : Callback<List<Hospitales>> {
            override fun onResponse(
                call: Call<List<Hospitales>>,
                response: Response<List<Hospitales>>
            ) {
                if (response.isSuccessful) {
                    val hospitales = response.body()
                    if (hospitales != null && hospitales.isNotEmpty()) {
                        // Extraemos solo los nombres de los hospitales
                        val hospitalNames = hospitales.map { it.nombre_hospital }

                        // Creamos el adaptador para el Spinner
                        val hospitalAdapter = ArrayAdapter(
                            this@AddPacienteActivity,
                            android.R.layout.simple_spinner_item,
                            hospitalNames
                        )
                        hospitalAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                        spinnerHospital.adapter = hospitalAdapter
                    } else {
                        Toast.makeText(
                            this@AddPacienteActivity,
                            "No se encontraron hospitales",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                } else {
                    // Si la respuesta no es exitosa, mostramos un error
                    Toast.makeText(
                        this@AddPacienteActivity,
                        "Error al cargar hospitales",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            override fun onFailure(call: Call<List<Hospitales>>, t: Throwable) {
                // Si falla la conexión, mostramos un mensaje de error
                Toast.makeText(
                    this@AddPacienteActivity,
                    "Error de conexión: ${t.message}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }

    // Método para validar el hospital y luego guardar el paciente
    private fun validateHospitalAndSavePaciente() {
        val nombre_hospital = spinnerHospital.selectedItem.toString().trim()

        // Validar si se ha seleccionado un hospital
        if (nombre_hospital.isBlank()) {
            Toast.makeText(this, "Debe seleccionar un hospital", Toast.LENGTH_SHORT).show()
            return
        }

        // Llamada a la API para validar el hospital
        val apiService = RetrofitClient.instance
        val call = apiService.validarHospital(nombre_hospital)

        call.enqueue(object : Callback<Hospital> {
            override fun onResponse(call: Call<Hospital>, response: Response<Hospital>) {
                if (response.isSuccessful) {
                    // Hospital encontrado, proceder con la creación del paciente
                    savePaciente()
                } else {
                    // Hospital no encontrado
                    Toast.makeText(
                        this@AddPacienteActivity,
                        "Hospital no encontrado",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            override fun onFailure(call: Call<Hospital>, t: Throwable) {
                // Error de conexión o cualquier otro fallo
                Toast.makeText(
                    this@AddPacienteActivity,
                    "Error de conexión: ${t.message}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }

    // Método para obtener el token de autenticación desde SharedPreferences
    private fun getToken(): String? {
        val sharedPreferences = getSharedPreferences("app_prefs", MODE_PRIVATE)
        return sharedPreferences.getString("auth_token", null)
    }

    // Método para guardar el token de autenticación en SharedPreferences
    private fun saveToken(token: String) {
        val sharedPreferences = getSharedPreferences("app_prefs", MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString("auth_token", token)
        editor.apply()  // Guardar de manera asíncrona
    }

    // Método para guardar el paciente
    private fun savePaciente() {
        val nombre = editTextNombre.text.toString().trim()
        val apellido = editTextApellido.text.toString().trim()
        val folio = editTextFolio.text.toString().trim()
        val edad = editTextEdad.text.toString().toIntOrNull()
        val genero = spinnerGenero.selectedItem.toString()
        val nombre_hospital = spinnerHospital.selectedItem.toString()

        // Validar los campos
        if (nombre.isBlank() || apellido.isBlank() || folio.isBlank() || edad == null || genero.isBlank() || nombre_hospital.isBlank()) {
            Toast.makeText(
                this,
                "Por favor, complete todos los campos correctamente",
                Toast.LENGTH_SHORT
            ).show()
            return
        }

        // Validar si la edad es un número positivo
        if (edad <= 0) {
            Toast.makeText(
                this,
                "La edad debe ser un número válido y mayor que 0",
                Toast.LENGTH_SHORT
            ).show()
            return
        }

        // Crear el objeto paciente
        val paciente = Paciente(
            nombre = nombre,
            apellido = apellido,
            folio = folio,
            edad = edad,
            genero = genero,
            nombre_hospital = nombre_hospital
        )

        // Enviar los datos a la API utilizando RetrofitClient
        val apiService = RetrofitClient.instance
        val call = apiService.crearPaciente(paciente)  // Llamada directa sin token

        call.enqueue(object : Callback<PacienteResponse> {
            override fun onResponse(
                call: Call<PacienteResponse>,
                response: Response<PacienteResponse>
            ) {
                if (response.isSuccessful) {
                    Toast.makeText(
                        this@AddPacienteActivity,
                        "Paciente creado exitosamente.",
                        Toast.LENGTH_SHORT
                    ).show()
                    finish()  // Regresar a la actividad anterior
                } else {
                    val errorMessage = response.message() ?: "Error desconocido"
                    Toast.makeText(
                        this@AddPacienteActivity,
                        "Error al crear paciente: $errorMessage",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            override fun onFailure(call: Call<PacienteResponse>, t: Throwable) {
                Toast.makeText(
                    this@AddPacienteActivity,
                    "Error de conexión: ${t.message}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }


}