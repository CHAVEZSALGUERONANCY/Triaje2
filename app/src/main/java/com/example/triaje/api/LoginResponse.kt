package com.example.triaje.api

data class LoginResponse(
    val success: Boolean,
    val token: String?,
    val refreshToken: String?,
    val message: String?,
    val idUsuario: Long?
)
