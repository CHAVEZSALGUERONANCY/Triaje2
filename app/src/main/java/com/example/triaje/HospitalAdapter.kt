package com.example.triaje

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.triaje.api.Hospitales

class HospitalesAdapter(private val hospitales: List<Hospitales>) :
    RecyclerView.Adapter<HospitalesAdapter.HospitalesViewHolder>() {

    // ViewHolder que sostiene la referencia del layout de cada ítem
    class HospitalesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nombre_hospital: TextView = itemView.findViewById(R.id.textViewNombre) // Asegúrate de que este ID esté en tu XML
    }

    // Crea la vista para cada ítem del RecyclerView
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HospitalesViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_hospital, parent, false) // Asegúrate de tener el layout "item_hospital"
        return HospitalesViewHolder(view)
    }

    // Vincula los datos del hospital con la vista
    override fun onBindViewHolder(holder: HospitalesViewHolder, position: Int) {
        holder.nombre_hospital.text = hospitales[position].nombre_hospital
    }

    // Devuelve el tamaño de la lista
    override fun getItemCount() = hospitales.size
}
