package com.example.labExtra5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast

class registrarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        this.setTitle("Fetch my Pet")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar)
        var personas: Usuarios = Usuarios.instance
        lateinit var persona: User
        var nom = findViewById(R.id.idNom) as EditText
        var mail = findViewById(R.id.idEmail) as EditText
        var pass = findViewById(R.id.idPas) as EditText
        var tel = findViewById(R.id.idTel) as EditText
        var dir = findViewById(R.id.idDir) as EditText
        var butRegistrar = findViewById(R.id.btn_submit) as Button

        butRegistrar.setOnClickListener {
            val name = nom.getText().toString().trim();
            val email = mail.getText().toString().trim();
            val password = pass.getText().toString().trim();
            val tele = tel.getText().toString().trim();
            val dire = dir.getText().toString().trim();
            val persona1 = User(email, password,name,tele,dire)
            personas.addUser(persona1)

            Toast.makeText(this, "Registrado correctamente.", Toast.LENGTH_SHORT).show()
            val i = Intent(this, LoginExample::class.java)
            startActivity(i)

        }


    }
}