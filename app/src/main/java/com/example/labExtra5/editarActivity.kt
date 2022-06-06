package com.example.labExtra5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Spinner
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class editarActivity : AppCompatActivity() {
    var jobs: JobApps = JobApps.instance
    var job = JobAppObj("test","test","test",0)
    var l : User= User("test","test","test","test","test")
    override fun onCreate(savedInstanceState: Bundle?) {
        this.setTitle("Detalles de publicación")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editar)

        val bundle = intent.extras

        if(bundle!=null){
            job =  bundle.getSerializable("JobApplication") as JobAppObj

            l =  bundle.getSerializable("Login") as User
        }

        val pos = bundle!!.getInt("position")


        val foto = findViewById<ImageView>(R.id.idFoto)
        val titulo = findViewById<TextView>(R.id.idTitulo)
        val raza = findViewById<TextView>(R.id.idNom)
        val desc = findViewById<TextView>(R.id.idEm)


        //sets
        foto.setImageResource(job.foto)
        titulo.setText(job.titulo_)
        raza.setText(job.raza_)
        desc.setText(job.descripcion_)

        val but: FloatingActionButton = findViewById(R.id.butBack3) as FloatingActionButton

        but.setOnClickListener(){

            val i = Intent(this, CrudPersonas::class.java)
            i.putExtra("Login",l)
            startActivity(i)
        }

    }



}