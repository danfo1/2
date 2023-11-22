package com.helenjireh.almacenamiento

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.io.OutputStream
import java.io.OutputStreamWriter
import java.lang.StringBuilder
import java.nio.Buffer

class textplano : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_textplano)
        val lista=findViewById<EditText>(R.id.listamercado)
        val guardarm =findViewById<Button>(R.id.guardar_mercado)




            if (fileList().contains("mercado.text")){
                try {
                    val archibo = InputStreamReader(openFileInput("mercado.text"))
                    val  lectura =BufferedReader(archibo)
                    var linea=lectura.readLine()
                    val contebidototal=StringBuilder()
                    while (linea != null){
                        contebidototal.append(linea+"\n")
                        linea=lectura.readLine()
                    }
                    lectura.close()
                    archibo.close()
                    lista.setText(contebidototal)
                }catch (e: IOException){

                }
            }
            guardarm.setOnClickListener{
                try {
                    val archibo = OutputStreamWriter(openFileOutput("mercado.text", Activity.MODE_PRIVATE))
                    archibo.write(lista.text.toString())
                    archibo.close()
                    archibo.flush()

                }catch (e:IOException){

                }
                Toast.makeText(this, "elemento agregado", Toast.LENGTH_SHORT).show()
                finish()
            }


    }
}