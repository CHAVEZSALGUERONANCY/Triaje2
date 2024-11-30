package com.example.triaje.api

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path


// Data class para representar los datos de la solicitud
data class CreateAccountRequest(
    val nombre: String,
    val apellido: String,
    val clave: String,
    val correo: String,
    val contrasena: String,
    // Incluye este campo si es obligatorio
)


data class LoginRequest(
    val correo: String,
    val contrasena: String,
)


data class HospitalRequest(
    val nombreHospital: String,
    val direccion: String,
    val telefono: String
)


data class Paciente(
    val nombre: String,
    val apellido: String,
    val folio: String,
    val edad: Int,
    val genero: String,
    val nombre_hospital: String
)


data class Hospital(
    val direccion: String,     // Dirección del hospital
    val nombre_hospital: String,        // Nombre del hospital
    val telefono: String       // Teléfono del hospital
)

data class Hospitales(
    val nombre_hospital: String
)




interface ApiService {
    @POST("/api/usuarios/usuario") // Cambia la ruta según la ruta de tu API en Spring Boot
    fun createAccount(@Body request: CreateAccountRequest): Call<CreateAccountResponse>

    @POST("/api/auth/login")
    fun login(@Body request: LoginRequest): Call<LoginResponse>

    @GET("/api/usuarios/perfil")
    fun obtenerPerfil(@Header("Authorization") token: String): Call<PerfilResponse>


    @POST("/api/crearpaciente")
    fun crearPaciente(
    @Body paciente: Paciente
    ): Call<PacienteResponse>


    //@POST("/api/crearpaciente")
    //fun crearPaciente(
      //  @Header("Authorization") token: String,  // Pasamos el token JWT
       // @Body paciente: Paciente                  // Cuerpo con los datos del paciente
   // ): Call<PacienteResponse>


    //@GET("/api/hospitales")  // Ajusta la ruta según tu backend
    //fun getHospitales(): Call<List<Hospitales>>

    @GET("api/hospital/nombre_hospital")  // Cambia a la URL de tu ruta correcta
    fun getHospitales(): Call<List<Hospitales>>

    @POST("/api/hospital")
    fun createHospital(@Body hospitalRequest: Hospital): Call<HospitalResponse>

    @GET("/api/hospital/validar/{nombre_hospital}")
    fun validarHospital(@Path("nombre_hospital") nombreHospital: String): Call<Hospital>

}


