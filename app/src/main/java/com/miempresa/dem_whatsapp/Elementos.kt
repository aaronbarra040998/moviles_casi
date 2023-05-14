package com.miempresa.dem_whatsapp


import android.graphics.Bitmap

// Declaramos una clase de datos llamada Elementos
// Esta clase tiene dos propiedades: texto y imagen, ambas de tipos String y Bitmap respectivamente
// data class es una clase especial de Kotlin que nos provee de métodos automáticos de igualdad, hash y toString()
data class Elementos (val texto:String, val imagen:Bitmap);
