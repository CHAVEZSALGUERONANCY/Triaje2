package com.example.triaje.api

import com.google.gson.annotations.SerializedName

data class PerfilResponse(
    @SerializedName("id_usuario") val idUsuario: Int,
    val nombre: String,
    val apellido: String,
    val correo: String,
    val nom_rol: String
)


