package com.example.triaje

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.triaje.api.ApiService
import com.example.triaje.api.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UbicacionActivity : AppCompatActivity() {
    private val hospitalService = RetrofitClient.instance // Usa el cliente Retrofit configurado

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ubicacion)


    }
}
