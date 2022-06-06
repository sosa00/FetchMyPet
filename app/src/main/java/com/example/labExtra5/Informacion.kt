package com.example.labExtra5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class Informacion : AppCompatActivity() {
    var l : User= User("test","test","test","test","test")
    override fun onCreate(savedInstanceState: Bundle?) {
        this.setTitle("Información Personal")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_informacion)
        var personas: Usuarios = Usuarios.instance
        val bundle = intent.extras

        if(bundle!=null){


            l =  bundle.getSerializable("Login") as User
        }


        var nom = findViewById(R.id.idNom) as TextView
        var mail = findViewById(R.id.idEm) as TextView
        var tel = findViewById(R.id.idTe) as TextView
        var dir = findViewById(R.id.idDi) as TextView


        //sets
        nom.setText(l.nombre)
        mail.setText(l.email)
        tel.setText(l.tel)
        dir.setText(l.dir)

        val but: FloatingActionButton = findViewById(R.id.butBack) as FloatingActionButton

        but.setOnClickListener(){

            val i = Intent(this, MenuAdmin::class.java)
            i.putExtra("Login",l)
            startActivity(i)
        }

    }
}