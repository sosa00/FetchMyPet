package com.example.labExtra5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class InsertarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        this.setTitle("Nueva publicación")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insertar)
        var jobs: JobApps = JobApps.instance
        lateinit var job: JobAppObj
        var l : User = User("te","te","te","te","te")
//        var nom = findViewById(R.id.name) as EditText
//        var last = findViewById(R.id.lastName) as EditText
//        var streetAdd = findViewById(R.id.streetAd) as EditText
//        var streetAdd2 = findViewById(R.id.streetAd2) as EditText
//        var city = findViewById(R.id.city) as EditText
//        var state = findViewById(R.id.state) as EditText
//        var postal = findViewById(R.id.zipCode) as EditText
//        var country = findViewById(R.id.country) as EditText
//        var email = findViewById(R.id.email) as EditText
//        var area = findViewById(R.id.areaCode) as EditText
//        var phone = findViewById(R.id.phone) as EditText
//        var position = findViewById(R.id.position) as EditText
//        var month = findViewById(R.id.month) as EditText
//        var day = findViewById(R.id.day) as EditText
//        var year = findViewById(R.id.year) as EditText
//        val butRegistrar = findViewById(R.id.button) as Button
//
//        butRegistrar.setOnClickListener {
//
//
//            val nam = nom.getText().toString().trim();
//            val lastn = last.getText().toString().trim();
//            val streetA = streetAdd.getText().toString().trim();
//            val streetA2 = streetAdd2.getText().toString().trim();
//            val cit = city.getText().toString().trim();
//            val stat = state.getText().toString().trim();
//            val post = postal.getText().toString().trim();
//            val coun = country.getText().toString().trim();
//            val em = email.getText().toString().trim();
//            val ar = area.getText().toString().trim();
//            val pho = phone.getText().toString().trim();
//            val pos = position.getText().toString().trim();
//            val mon = month.getText().toString().trim();
//            val da = day.getText().toString().trim();
//            val ye = year.getText().toString().trim();
//
//            val job1 = JobAppObj(
//                nam,
//                lastn,
//                streetA,
//                streetA2,
//                cit,
//                stat,
//                post.toInt(),
//                coun,
//                em,
//                ar.toInt(),
//                pho.toInt(),
//                pos,
//                mon,
//                da,
//                ye
//            )
//            jobs.addJobApp(job1)
//
//            Toast.makeText(this, "You just applied.", Toast.LENGTH_SHORT).show()
//            l = intent.getSerializableExtra("Login") as User
////            if(l.rol == "standard") {
//                val i = Intent(this, MenuAdmin::class.java)
//                i.putExtra("Login", l)
//                startActivity(i)
////            }else {
////               val i = Intent(this, CrudPersonas::class.java)
////                i.putExtra("Login", l)
////                startActivity(i)
////            }

      //  }
    }
}