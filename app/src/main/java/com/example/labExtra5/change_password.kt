package com.example.labExtra5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast

class change_password : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_password)
        this.setTitle("Change Password")

        var usern = findViewById(R.id.idUser) as EditText
        var oldP = findViewById(R.id.idPass) as EditText
        var newP = findViewById(R.id.idPass2) as EditText
        var btn_pass= findViewById(R.id.butRegi) as ImageView

        val i = Intent(this, LoginExample::class.java)

        btn_pass.setOnClickListener{
            val user_name = usern.text;
            val password = oldP.text;
            val passwordN = newP.text;


            var personas: Usuarios = Usuarios.instance
            var persona: User?

            if(personas.login(user_name.toString(),password.toString())) {
                personas.editPassword(user_name.toString(), passwordN.toString())
                Toast.makeText(this, "Just changed the password.", Toast.LENGTH_SHORT).show()
                startActivity(i)
            }
            else{
                Toast.makeText(this, "User not found.", Toast.LENGTH_SHORT).show()
            }
        }

    }
}
