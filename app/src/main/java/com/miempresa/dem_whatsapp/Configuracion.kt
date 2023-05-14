package com.miempresa.dem_whatsapp
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

// Declaramos una clase llamada Configuracion que extiende de la clase AppCompatActivity
class Configuracion : AppCompatActivity() {

    // Función que se ejecuta cuando se crea la actividad de configuración
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Establecemos el layout de la actividad
        setContentView(R.layout.activity_configuracion)

        // Configuramos el ActionBar de la actividad
        setSupportActionBar(findViewById(R.id.mitoolbar))
        //supportActionBar?.setHomeAsUpIndicator(android.R.drawable.ic_menu_preferences)

        // Establecemos que el botón de navegación hacia atrás esté visible en el ActionBar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

}
