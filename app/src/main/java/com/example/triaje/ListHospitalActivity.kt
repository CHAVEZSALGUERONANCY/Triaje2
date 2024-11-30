package com.example.triaje

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.triaje.api.Hospitales
import com.example.triaje.api.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListHospitalActivity : AppCompatActivity() {
    private lateinit var recyclerViewHospital: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_hospital)

        // Inicializar RecyclerView
        recyclerViewHospital = findViewById(R.id.recyclerViewHospital)
        recyclerViewHospital.layoutManager = LinearLayoutManager(this)  // Usa LinearLayoutManager para la lista vertical

        // Llamar a la API
        val api = RetrofitClient.instance  // Usa la instancia ya configurada en RetrofitClient
        api.getHospitales().enqueue(object : Callback<List<Hospitales>> {
            override fun onResponse(
                call: Call<List<Hospitales>>,
                response: Response<List<Hospitales>>
            ) {
                if (response.isSuccessful) {
                    val hospitales = response.body() ?: emptyList()
                    // Configura el adaptador con los datos obtenidos
                    recyclerViewHospital.adapter = HospitalesAdapter(hospitales)
                } else {
                    Toast.makeText(
                        this@ListHospitalActivity,
                        "Error al cargar nombres",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            override fun onFailure(call: Call<List<Hospitales>>, t: Throwable) {
                Toast.makeText(this@ListHospitalActivity, "Error: ${t.message}", Toast.LENGTH_SHORT)
                    .show()
            }
        })
    }
}
