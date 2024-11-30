package com.example.triaje

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class TriajeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_triaje)

        val checkbox1 = findViewById<CheckBox>(R.id.checkbox1)
        val checkbox2 = findViewById<CheckBox>(R.id.checkbox2)
        val checkbox3 = findViewById<CheckBox>(R.id.checkbox3)
        val checkbox4 = findViewById<CheckBox>(R.id.checkbox4)
        val checkbox5 = findViewById<CheckBox>(R.id.checkbox5)
        val checkbox6 = findViewById<CheckBox>(R.id.checkbox6)
        val checkbox7= findViewById<CheckBox>(R.id.checkbox7)
        val checkbox8 = findViewById<CheckBox>(R.id.checkbox8)
        val checkbox9 = findViewById<CheckBox>(R.id.checkbox9)
        val checkbox10 = findViewById<CheckBox>(R.id.checkbox10)
        val checkbox11 = findViewById<CheckBox>(R.id.checkbox11)
        val checkbox12 = findViewById<CheckBox>(R.id.checkbox12)
        val checkbox13 = findViewById<CheckBox>(R.id.checkbox13)
        val checkbox14 = findViewById<CheckBox>(R.id.checkbox14)
        val checkbox15 = findViewById<CheckBox>(R.id.checkbox15)
        val checkbox16 = findViewById<CheckBox>(R.id.checkbox16)
        val checkbox17 = findViewById<CheckBox>(R.id.checkbox17)
        val checkbox18 = findViewById<CheckBox>(R.id.checkbox18)
        val checkbox19 = findViewById<CheckBox>(R.id.checkbox19)
        val checkbox20 = findViewById<CheckBox>(R.id.checkbox20)
        val checkbox21 = findViewById<CheckBox>(R.id.checkbox21)
        val checkbox22 = findViewById<CheckBox>(R.id.checkbox22)
        val checkbox23 = findViewById<CheckBox>(R.id.checkbox23)
        val checkbox24 = findViewById<CheckBox>(R.id.checkbox24)
        val checkbox25 = findViewById<CheckBox>(R.id.checkbox25)
        val checkbox26 = findViewById<CheckBox>(R.id.checkbox26)
        val checkbox27 = findViewById<CheckBox>(R.id.checkbox27)
        val checkbox28 = findViewById<CheckBox>(R.id.checkbox28)
        val checkbox29 = findViewById<CheckBox>(R.id.checkbox29)
        val checkbox30 = findViewById<CheckBox>(R.id.checkbox30)
        val checkbox31 = findViewById<CheckBox>(R.id.checkbox31)
        val checkbox32 = findViewById<CheckBox>(R.id.checkbox32)
        val checkbox33 = findViewById<CheckBox>(R.id.checkbox33)
        val checkbox34 = findViewById<CheckBox>(R.id.checkbox34)
        val checkbox35 = findViewById<CheckBox>(R.id.checkbox35)
        val checkbox36 = findViewById<CheckBox>(R.id.checkbox36)
        val checkbox37 = findViewById<CheckBox>(R.id.checkbox37)
        val checkbox38 = findViewById<CheckBox>(R.id.checkbox38)
        val checkbox39 = findViewById<CheckBox>(R.id.checkbox39)
        val checkbox40 = findViewById<CheckBox>(R.id.checkbox40)
        val checkbox41 = findViewById<CheckBox>(R.id.checkbox41)
        val checkbox42 = findViewById<CheckBox>(R.id.checkbox42)
        val checkbox43 = findViewById<CheckBox>(R.id.checkbox43)
        val checkbox44 = findViewById<CheckBox>(R.id.checkbox44)
        val checkbox45 = findViewById<CheckBox>(R.id.checkbox45)
        val checkbox46 = findViewById<CheckBox>(R.id.checkbox46)
        val checkbox47 = findViewById<CheckBox>(R.id.checkbox47)
        val checkbox48 = findViewById<CheckBox>(R.id.checkbox48)
        val checkbox49 = findViewById<CheckBox>(R.id.checkbox49)
        val checkbox50 = findViewById<CheckBox>(R.id.checkbox50)
        val checkbox51 = findViewById<CheckBox>(R.id.checkbox51)
        val checkbox52 = findViewById<CheckBox>(R.id.checkbox52)
        val checkbox53 = findViewById<CheckBox>(R.id.checkbox53)
        val checkbox54 = findViewById<CheckBox>(R.id.checkbox54)
        val checkbox55 = findViewById<CheckBox>(R.id.checkbox55)
        val checkbox56 = findViewById<CheckBox>(R.id.checkbox56)
        val checkbox57 = findViewById<CheckBox>(R.id.checkbox57)
        val checkbox58 = findViewById<CheckBox>(R.id.checkbox58)
        val checkbox59 = findViewById<CheckBox>(R.id.checkbox59)
        val checkbox60 = findViewById<CheckBox>(R.id.checkbox60)
        val checkbox61 = findViewById<CheckBox>(R.id.checkbox61)
        val checkbox62 = findViewById<CheckBox>(R.id.checkbox62)
        val btnSubmit: Button = findViewById(R.id.btnSubmit)

        btnSubmit.setOnClickListener {
            // Verificar respuestas
            val nivel = determinarNivel(
                nivel1 = listOf(checkbox1, checkbox2, checkbox3, checkbox4, checkbox5, checkbox6, checkbox7, checkbox8, checkbox9),
                nivel2 = listOf(checkbox10, checkbox11, checkbox12, checkbox13, checkbox14, checkbox15, checkbox16, checkbox17, checkbox18, checkbox19, checkbox20, checkbox21, checkbox22, checkbox23, checkbox24, checkbox25, checkbox26),
                nivel3 = listOf(checkbox27, checkbox28, checkbox29, checkbox30, checkbox31, checkbox32, checkbox33, checkbox34, checkbox35, checkbox36, checkbox37),
                nivel4 = listOf(checkbox38, checkbox39, checkbox40, checkbox41, checkbox42, checkbox43, checkbox44, checkbox45, checkbox46, checkbox47, checkbox48),
                nivel5 = listOf(checkbox49, checkbox50, checkbox51, checkbox52, checkbox53, checkbox54, checkbox55, checkbox56, checkbox57, checkbox58, checkbox59, checkbox60, checkbox61, checkbox62)
            )

            // Mostrar nivel determinado
            Toast.makeText(this, "El nivel de triaje es: Nivel $nivel", Toast.LENGTH_LONG).show()
        }
    }
    // Aquí se define la función determinarNivel dentro de la misma clase
    private fun determinarNivel(
        nivel1: List<CheckBox>,
        nivel2: List<CheckBox>,
        nivel3: List<CheckBox>,
        nivel4: List<CheckBox>,
        nivel5: List<CheckBox>
    ): Int {
        // Comprobar si hay respuestas seleccionadas en cada nivel
        return when {
            nivel1.any { it.isChecked } -> 1 // Nivel más crítico
            nivel2.any { it.isChecked } -> 2
            nivel3.any { it.isChecked } -> 3
            nivel4.any { it.isChecked } -> 4
            nivel5.any { it.isChecked } -> 5
            else -> 0 // Sin respuestas seleccionadas
        }
    }
    // Función para mostrar el dialogo dependiendo del nivel
    private fun mostrarDialogoNivel(nivel: Int) {
        val mensaje = when (nivel) {
            1 -> "¡Atención inmediata! El nivel de triaje es crítico."
            2 -> "Necesita atención en los próximos 30 minutos."
            3 -> "Necesita atención en los próximos 60 minutos."
            4 -> "Atención dentro de los próximos 120 minutos."
            5 -> "Atención leve, sin urgencia inmediata."
            else -> "No se han seleccionado respuestas."
        }

        // Crear y mostrar el Dialogo
        AlertDialog.Builder(this)
            .setTitle("Nivel de Triaje: Nivel $nivel")
            .setMessage(mensaje)
            .setPositiveButton("Aceptar") { dialog, _ ->
                dialog.dismiss()
            }
            .setCancelable(false)
            .show()
    }
}


