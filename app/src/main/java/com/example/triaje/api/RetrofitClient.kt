package com.example.triaje.api

import android.util.Log
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private const val BASE_URL = "http://192.168.1.104:4000/"  // Cambia esto con tu URL base
    var token: String? = null  // Aquí guardamos el token

    // Configura el cliente Retrofit con un Interceptor para agregar el token
    val instance: ApiService by lazy {
        val client = OkHttpClient.Builder().apply {
            addInterceptor { chain ->
                val originalRequest = chain.request()  // Obtiene la solicitud original
                Log.d("RetrofitClient", "Token: ${token ?: "Nulo"}")
                val newRequest = originalRequest.newBuilder()
                    .apply {
                        token?.let {
                            // Si hay token, lo agregamos a la cabecera Authorization
                            Log.d("RetrofitClient", "Token enviado en la solicitud: $it")
                            addHeader("Authorization", "Bearer $it")
                        }
                    }
                    .build()
                // Agregar log para ver la solicitud
                Log.d("RetrofitClient", "Request URL: ${originalRequest.url}")
                Log.d("RetrofitClient", "Request Headers: ${originalRequest.headers}")
                chain.proceed(newRequest)  // Envía la solicitud modificada
            }
        }.build()
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)  // Usamos el cliente con el interceptor
            .addConverterFactory(GsonConverterFactory.create())  // Convertimos la respuesta en objetos JSON
            .build()

        // Aquí llamamos al método create en la instancia de Retrofit para obtener la implementación del servicio
        retrofit.create(ApiService::class.java)  // Crea la instancia de ApiService
    }


    // Función para establecer el token cuando se autentica el usuario
    fun updateToken(newToken: String) {
        token = newToken
    }



}
