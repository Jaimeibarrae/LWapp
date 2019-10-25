package com.hugobelman.listviewpersonalizado

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar!!.title="Tutorial Kotlin" //Esto es el titulo principal

        val tema1 = Producto("Manejo de ListView",R.drawable.ilv,
            "Un ListView es un componente de vista de lista " +
                    "que nos servirá para mostrar datos, " +
                    "tal como puede ser una lista de contactos, lista de productos, etc."
                    ,R.drawable.katodo)//Componenete de la lista Menejo de list view
        val tema2 = Producto("Manejo de Activities",R.drawable.activity,
            "Una Activity es un componente de la aplicación que contiene una pantalla " +
                    "con la que los usuarios pueden interactuar para realizar una acción, como marcar" +
                " un número telefónico, tomar una foto, enviar un correo electrónico o ver un m" +
                    "apa. A cada actividad se le asigna una ventana en la que se puede dibujar su " +
                    "interfaz de usuario.",R.drawable.jaime )//Componenete de manejo de activities
        val tema3 = Producto("SheredPreferences",R.drawable.shered,"Almacenamiento" +
                " interno con SharedPreferences:\n" +
                "Android ofrece diferentes opciones para que guardes los datos de tu " +
                "aplicación. La solución que elijas dependerá de tus necesidades específicas\n" +
                "SharedPreferences: Si tu aplicación no necesita almacenar muchos datos ni requiere" +
                " una estructura, sirve para almacenar datos privados de primitivas en pares " +
                "clave-valor.\n",R.drawable.mama )//Componenete de SharedPreferences
        val tema4 = Producto("Controles de Audio",R.drawable.dio,"Para implementar " +
                "audio a tu App existen diferentes formas, tanto Online o local.\n" +
                "La clase MediaPlayer se puede usar para controlar la reproducción de archivos " +
                "de audio/vídeo y transmisiones.\n",R.drawable.gaga)//Componenete de controles de audio
        val tema5 = Producto("SQLite",R.drawable.lite,"Es un motor de base de datos " +
                "SQL transaccional de código abierto, ligero, autónomo, de configuración simple " +
                "y sin servidor\n" +"Así mismo, por ser de dominio público es gratuito tanto para " +
                "fines privados como para comerciales\n" +"SQLite cumple con las características " +
                "ACID (atomicidad, consistencia, aislamiento y durabilidad), forma parte integral " +
                "de las aplicaciones basadas en el cliente, SQLite utiliza una sintaxis SQL dinámica" +
                " y realiza múltiples tareas para hacer lecturas y escrituras al mismo tiempo, ambas " +
                "(lectura y escritura) se efectúan directamente en los archivos de disco ordinarios.\n"
                ,R.drawable.fafa )//Componenete de SQL


        val listaProductos = listOf(tema1, tema2,tema3,tema4,tema5)//Toma los valores para la lista

        val adapter = ProductosAdapter(this, listaProductos)//Adaptador de la lista

        lista.adapter = adapter//Adaptador de la lista

        lista.setOnItemClickListener { parent, view, position, id ->//Adaptador de la lista
            val intent = Intent(this, ProductoActivity::class.java)//Adaptador de la lista
            intent.putExtra("producto", listaProductos[position])//Manda la informacion al otro activitie
            startActivity(intent)//Inicia la actividad
        }
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {//Codigo del menú
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle item selection
        var mensaje: String=""
        when (item.itemId) {
            R.id.itmAcerca -> {//Se toman los valorea para el menú
                mensaje="Tutorial Kotlin.\n"+
                "Desarrollado por Jaime Cano.\n"+"GDS0143"
            }
            R.id.itmObjetivo -> {//Se toman los valorea para el menú
                mensaje= "El objetivo de este tutorial es mostrar el funcionamiento de diferentes temas en Kotlin"

            }
            R.id.itmSalir -> {//Salir
                System.exit(0)
            }

        }
        Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show()//Widget para mensaje
        return  super.onOptionsItemSelected(item)
    }
}
