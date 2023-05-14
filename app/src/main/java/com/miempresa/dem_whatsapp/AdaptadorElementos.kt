package com.miempresa.dem_whatsapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import android.widget.AdapterView
import java.text.ParsePosition


// Declaramos una clase llamada AdaptadorElementos que extiende de la clase RecyclerView.Adapter y recibe una lista de elementos como parámetro
class AdaptadorElementos (val ListaElementos:ArrayList<Elementos>):RecyclerView.Adapter<AdaptadorElementos.ViewHolder>() {
    // Declaramos una clase interna llamada ViewHolder que extiende de la clase RecyclerView.ViewHolder
    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        // Creamos dos variables para hacer referencia al TextView y al ImageView del elemento de la lista
        val fTexto = itemView.findViewById<TextView>(R.id.elemento_texto)
        val fImagen= itemView.findViewById<ImageView>(R.id.elemento_imagen);
    }

    // Función que se ejecuta cuando se crea un ViewHolder
    override fun onCreateViewHolder(
        parent:ViewGroup,
        viewType:Int
    ): AdaptadorElementos.ViewHolder {
        // Inflamos el layout elementoslista para crear la vista de cada elemento de la lista
        val  v = LayoutInflater.from(parent?.context).inflate(R.layout.elementoslista,parent,false);
        // Creamos un nuevo ViewHolder con la vista inflada y lo retornamos
        return ViewHolder(v);
    }

    // Función que se ejecuta cuando se vincula un ViewHolder con un elemento de la lista
    override fun onBindViewHolder(holder:AdaptadorElementos.ViewHolder,position:Int){
        // Asignamos el texto y la imagen correspondientes al TextView y al ImageView del ViewHolder
        holder?.fTexto?.text=ListaElementos[position].texto
        holder?.fImagen?.setImageBitmap(ListaElementos[position].imagen)

        // Creamos un menú contextual para cada elemento de la lista
        holder.itemView.setOnCreateContextMenuListener { contextMenu, _, _ ->
            // Establecemos el título del menú contextual
            contextMenu.setHeaderTitle("Se eligió opción " + (position + 1))
            true
        }
    }

    // Función que retorna el número de elementos en la lista
    override fun getItemCount(): Int {
        return ListaElementos.size;
    }
}