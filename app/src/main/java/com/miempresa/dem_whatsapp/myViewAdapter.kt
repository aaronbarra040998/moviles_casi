package com.miempresa.dem_whatsapp
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

// Definimos una clase llamada `myViewAdapter` que extiende de `FragmentStateAdapter`

class myViewAdapter(fragmentManager: FragmentManager,lifecycle: Lifecycle):FragmentStateAdapter(
    fragmentManager, lifecycle) {
    // Esta función devuelve el número de elementos que se mostrarán en la lista de fragmentos
    override fun getItemCount(): Int {
        return 4
    }
// La función createFragment() se encarga de crear y devolver un fragmento
// dependiendo de la posición indicada en la lista.

    override fun createFragment(position: Int): Fragment {
        // El bloque 'when' compara la posición con diferentes valores.
        // Si la posición es 0, se devuelve una instancia del fragmento FragmentA;
        // Si la posición es 1, se devuelve una instancia del fragmento FragmentB;
        // Si la posición es 2, se devuelve una instancia del fragmento FragmentC;
        // Si la posición no coincide con ningún valor específico, se devuelve una instancia del fragmento FragmentA.

        return when(position){
            0 ->{
                FragmentA()
            }
            1 ->{
                FragmentB()
            }
            2 ->{
                FragmentC()
            }
            3 ->{
                FragmentD()
            }
            else ->{
                FragmentA()
            }
        }
    }
}