package com.vidal.covidquestionary

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_resultado.*

class resultado : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)
        var g = intent.extras
        var name = g?.getString("dat1")
        var age=g?.getString("dat2")
        var informe=g?.getString("dat3")
        textMostrarNombre.text=name
        textMostrarEdad.text=age
        textInforme.text=informe
        btnVolver.setOnClickListener {
            val volver = Intent(this, MainActivity::class.java)
            startActivity(volver)
        }


        btnSalir.setOnClickListener {
            finish()
            System.exit(1)
        }
    }
}
