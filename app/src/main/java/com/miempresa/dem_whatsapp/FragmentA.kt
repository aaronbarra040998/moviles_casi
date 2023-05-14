package com.miempresa.dem_whatsapp

import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


// Declaramos una clase llamada FragmentA que extiende de la clase Fragment
class FragmentA : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_a, container, false)

        // Configuramos el RecyclerView para mostrar la lista de elementos
        val listita: RecyclerView = view.findViewById(R.id.listita)
        listita.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                DividerItemDecoration.VERTICAL
            )
        )
        listita.layoutManager = LinearLayoutManager(requireContext())

        val llenarLista = ArrayList<Elementos>()
        for (i in 1 until 2) {
            llenarLista.add(
                Elementos(
                    "Elementos " + i,
                    BitmapFactory.decodeResource(resources, R.drawable.perfil)
                )
            )
        }

        val adapter = AdaptadorElementos(llenarLista)
        listita.adapter = adapter

        registerForContextMenu(listita)

        return view
    }
}

