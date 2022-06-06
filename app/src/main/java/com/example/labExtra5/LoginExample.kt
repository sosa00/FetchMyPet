package com.example.labExtra5

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class LoginExample : AppCompatActivity() {

    var usuarios: Usuarios = Usuarios.instance

    override fun onCreate(savedInstanceState: Bundle?) {
        this.setTitle("Fetch my Pet");
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_example)
        // get reference to all views
        var et_mail = findViewById(R.id.et_username) as EditText
        var et_password = findViewById(R.id.et_password) as EditText

        var btn_submit = findViewById(R.id.btn_submit) as Button
        var btn_reg = findViewById(R.id.idReg) as TextView



        btn_reg.setOnClickListener{
            val i = Intent(this, registrarActivity::class.java)
            startActivity(i)
        }


        // set on-click listener
        btn_submit.setOnClickListener {
            val mail = et_mail.text;
            val password = et_password.text;
            //var userRol = ""

            if(usuarios.login(mail.toString(), password.toString())) {
                val bundle = Bundle()
                val Login = usuarios.loginP(mail.toString(), password.toString())


                val i = Intent(this, MenuAdmin::class.java)

                i.putExtra("msg", "Bienvenid@.")
                i.putExtra("Login", Login)
                startActivity(i)

            }
                else {
                Toast.makeText(this, "Usuario incorrecto.", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }