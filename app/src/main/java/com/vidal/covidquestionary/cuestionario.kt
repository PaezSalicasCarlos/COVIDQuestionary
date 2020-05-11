package com.vidal.covidquestionary

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_cuestionario.*
import androidx.core.view.isVisible as isVisible1

class cuestionario() : AppCompatActivity() {
    var mensaje = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cuestionario)

        var mostrar = intent.extras
        var name = mostrar?.getString("dt")
        var age = mostrar?.getString("ed")


        btEvaluar.setOnClickListener{
            if(!rbPreg1RtaSi.isChecked && !rbPreg1RtaNo.isChecked) {
                Toast.makeText(this, "DEBE RESPONDER TODAS LAS PREGUNTAS", Toast.LENGTH_SHORT).show()
            }else{
                if(!rbPreg2RtaSi.isChecked && !rbPreg2RtaNo.isChecked) {
                    Toast.makeText(this, "DEBE RESPONDER TODAS LAS PREGUNTAS", Toast.LENGTH_SHORT).show()
                }else{
                    if(!rbPreg3RtaSi.isChecked && !rbPreg3RtaNo.isChecked) {
                        Toast.makeText(this, "DEBE RESPONDER TODAS LAS PREGUNTAS", Toast.LENGTH_SHORT).show()
                    }else{
                        if(!rbPreg4RtaSi.isChecked && !rbPreg4RtaNo.isChecked) {
                            Toast.makeText(this, "DEBE RESPONDER TODAS LAS PREGUNTAS", Toast.LENGTH_SHORT).show()
                        }else{
                            evaluarRespuestas()
                        }
                    }
                }
            }
        }

        btnSiguiente.setOnClickListener {
            if(mensaje == ""){
                Toast.makeText(this, "PRIMERO DEBE EVALUAR SUS RESPUESTAS", Toast.LENGTH_SHORT).show()
            }else{
                val ir = Intent(this, resultado::class.java)
                val c:Bundle = Bundle()
                var nombre = name
                var edad = age
                val diagnostico = mensaje
                c.putString("dat1", nombre)
                c.putString("dat2", edad)
                c.putString("dat3", diagnostico)
                ir.putExtras(c)
                startActivity(ir)
                finish()
            }
        }
    }


   fun evaluarRespuestas(){

        if(rbPreg1RtaSi.isChecked) {
            if(rbPreg2RtaSi.isChecked || rbPreg3RtaSi.isChecked || rbPreg4RtaSi.isChecked) {
                mensaje = "POSIBLE CASO, LLAMAR AL 107 Y PEDIR ANALISIS"
            }else{
                mensaje = "SU SALUD ES BUENA, ESTAR ATENTO A CUALQUIER SINTOMA"
            }
        }else{
            if (rbPreg2RtaSi.isChecked){
                if(rbPreg3RtaSi.isChecked || rbPreg4RtaSi.isChecked){
                    mensaje = "POSIBLE CASO, LLAMAR AL 107 Y PEDIR ANALISIS"
                }else{
                    mensaje = "VISITAR A SU MEDICO DE CABECERA"
                }
            }else{
                if (rbPreg3RtaSi.isChecked){
                    if(rbPreg4RtaSi.isChecked){
                        mensaje = "POSIBLE CASO, LLAMAR AL 107 Y PEDIR ANALISIS"
                    }else{
                        mensaje = "VISITE A SU MEDICO"
                    }
                }else{
                    if(rbPreg4RtaSi.isChecked) {
                        mensaje = "VISITE A SU MEDICO"
                    }else{
                        mensaje = "SALUD EN BUEN ESTADO"
                    }
                }
            }
        }

        if (rbPreg1RtaNo.isChecked && rbPreg2RtaNo.isChecked && rbPreg3RtaNo.isChecked && rbPreg4RtaNo.isChecked){
            mensaje = "SALUD EN BUEN ESTADO"
        }


    }


}
