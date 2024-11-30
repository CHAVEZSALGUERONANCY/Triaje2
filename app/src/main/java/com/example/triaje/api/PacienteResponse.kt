package com.example.triaje.api

data class PacienteResponse(
    val success: Boolean,          // Si la operación fue exitosa
    val message: String,
    val paciente: Paciente?,
)
