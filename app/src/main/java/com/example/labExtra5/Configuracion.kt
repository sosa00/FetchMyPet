package com.example.labExtra5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.android.material.floatingactionbutton.FloatingActionButton

class Configuracion : AppCompatActivity() {

    var l : User= User("test","test","test","test","test")
    override fun onCreate(savedInstanceState: Bundle?) {
        this.setTitle("Configuración")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_configuracion)
        var personas: Usuarios = Usuarios.instance
        val bundle = intent.extras

        if(bundle!=null){


            l =  bundle.getSerializable("Login") as User
        }


        var nom = findViewById(R.id.idNom) as EditText
        var mail = findViewById(R.id.idEmail) as EditText
        var pass = findViewById(R.id.idPas) as EditText
        var tel = findViewById(R.id.idTel) as EditText
        var dir = findViewById(R.id.idDir) as EditText


        //sets
        nom.setText(l.nombre)
        mail.setText(l.email)
        pass.setText(l.password)
        tel.setText(l.tel)
        dir.setText(l.dir)

        val but: Button = findViewById(R.id.btn_submit) as Button

        but.setOnClickListener(){
            var newUser : User=User(mail.text.toString(),pass.text.toString(),nom.text.toString(),tel.text.toString(),dir.text.toString())
            personas.editPersonByName(newUser, l.nombre)
            val i = Intent(this, MenuAdmin::class.java)
            i.putExtra("Login",newUser)
            startActivity(i)
        }

        val but2: FloatingActionButton = findViewById(R.id.butBack2) as FloatingActionButton

        but2.setOnClickListener(){

            val i = Intent(this, MenuAdmin::class.java)
            i.putExtra("Login",l)
            startActivity(i)
        }

    }
}