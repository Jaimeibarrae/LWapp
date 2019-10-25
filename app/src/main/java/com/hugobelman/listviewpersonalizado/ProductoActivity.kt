package com.hugobelman.listviewpersonalizado

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_producto.*

class ProductoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_producto)
        btnRegresar.setOnClickListener {//Te regresa al activity principal
            finish()//Finaliza la actividad
        }

        val producto = intent.getSerializableExtra("producto") as Producto //Manda el valor
                                                                        //tomado de la lista a este
                                                                        // a este activity

        nombre_producto.text = producto.titulo //Se asigna el valor del arreglo a la etiqueta
        detalles_producto.text = producto.descripcion//Se asigna el valor del arreglo a la etiqueta
        imagen.setImageResource(producto.imaTema)//Se asigna el valor del arreglo a la iamgen
        imgCodigo.setImageResource(producto.imaDes)//Se asigna el valor del arreglo a la imagen

        supportActionBar!!.title="Tutorial Kotlin" //Titulo del activity
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)//Habilita la flecha de regreso del activity
    }
}
