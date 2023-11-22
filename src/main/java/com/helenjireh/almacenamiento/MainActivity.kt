package com.helenjireh.almacenamiento

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nombre = findViewById<EditText>(R.id.NOMBRE)
        val datos = findViewById<EditText>(R.id.DATOS)
        val guardar =findViewById<Button>(R.id.GUARDAR)
        val consultar =findViewById<Button>(R.id.CONSULTAR)
        val preferencias =getSharedPreferences( "agenda" , Context.MODE_PRIVATE)
        guardar.setOnClickListener {
            val editar=preferencias.edit()
            editar.putString(nombre.text.toString(),datos.text.toString())
            editar.commit()
            Toast.makeText(this, "contacto guardado", Toast.LENGTH_SHORT).show()
            nombre.setText("")
            datos.setText("")
        }
         val datosconultar=preferencias.getString(nombre.text.toString(), "")
        if(datosconultar !=null){
            if (datosconultar.length==0){
                Toast.makeText(this, "no existe", Toast.LENGTH_SHORT).show()
            }else{
                datos.setText(datosconultar)
            }
        }

    }
}