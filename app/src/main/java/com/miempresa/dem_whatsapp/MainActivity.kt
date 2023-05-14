package com.miempresa.dem_whatsapp

// Importamos las librerías necesarias
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import android.view.Menu
import android.view.MenuItem
import androidx.core.view.GravityCompat
import kotlinx.android.synthetic.main.activity_main.*

// Declaramos una clase llamada MainActivity que extiende de la clase AppCompatActivity
class MainActivity : AppCompatActivity() {

    // Declaramos las variables que vamos a utilizar para el TabLayout y ViewPager2
    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager2: ViewPager2
    private lateinit var adapter: myViewAdapter // nota: se sugiere usar nombres de clases en CamelCase, por ejemplo: MyViewAdapter

    // Función que se ejecuta cuando se crea la actividad principal
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Establecemos el layout de la actividad
        setContentView(R.layout.activity_main)

        setSupportActionBar(findViewById(R.id.mitoolbar))
        supportActionBar?.setHomeAsUpIndicator(android.R.drawable.ic_menu_preferences)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Configuramos el ActionBar de la actividad
        supportActionBar!!.setBackgroundDrawable(ColorDrawable(getColor(R.color.purple)))

        // Configuramos el TabLayout y el ViewPager2
        tabLayout = findViewById(R.id.tab)
        viewPager2 = findViewById(R.id.view)
        adapter = myViewAdapter(supportFragmentManager, lifecycle)
        viewPager2.adapter = adapter
        TabLayoutMediator(tabLayout, viewPager2) { tab, position ->
            when(position) {
                0 -> {
                    tab.icon = resources.getDrawable(R.drawable.camara)
                }
                1 -> {
                    tab.text = "CHATS"
                }
                2 -> {
                    tab.text = "ESTADOS"
                }
                3 -> {
                    tab.text = "LLAMADAS"
                }
            }
        }.attach()
    }

    // Función que se ejecuta cuando se crea el menú de opciones de la actividad
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Inflamos el layout del menú
        menuInflater.inflate(R.menu.menuprincipal, menu)
        return true
    }
    // Función que se ejecuta cuando se selecciona un elemento del menú
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id: Int = item.getItemId()
        if (id == R.id.configuracion) {
// Lanzamos la actividad de Configuración
            val llamaractividad = Intent(applicationContext, Configuracion::class.java)
            startActivity(llamaractividad)
            return true
        }
        if (id == R.id.informacion) {
// Lanzamos la actividad de Información
            val llamaractividad = Intent(applicationContext, Informacion::class.java)
            startActivity(llamaractividad)
            return true
        }
        if (id == android.R.id.home) {
// Abrimos el layout_lateral (NavigationDrawer)
            layout_lateral.openDrawer(GravityCompat.START)
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}

