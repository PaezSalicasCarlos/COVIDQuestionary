package com.vidal.covidquestionary

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.io.Serializable

class MainActivity : AppCompatActivity()  {
    //data class usuario(var nombre: String, var edad: String): Serializable
    //lateinit var persona : usuario()
    //lateinit var textNombre : EditText
    //lateinit var textEdad : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnRealizarCuestionario.setOnClickListener {
           // lateinit var persona : usuario
           // persona.nombre = textNombre.findViewById<EditText>(R.id.editTextNombre).toString()
           // persona.edad = textEdad.findViewById<EditText>(R.id.editTextEdad).toString()
            var dato = editTextNombre.text.toString()
            var edad1 = editTextEdad.text.toString()

            if(dato==""||edad1==""){
                Toast.makeText(this, "COMPLETAR SUS DATOS", Toast.LENGTH_SHORT).show()
                if(dato=="") editTextNombre.requestFocus()
                if(edad1=="") editTextEdad.requestFocus()
            }else{
                val intent : Intent = Intent(   this, cuestionario::class.java)
                val b:Bundle = Bundle()
                b.putString("dt", dato)
                b.putString("ed", edad1)
                intent.putExtras(b)
                startActivity(intent)
                finish()
            }
        }
    }
}
