package com.example.labExtra5


import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView


class MenuAdmin : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener  {

    private lateinit var appBarConfiguration: AppBarConfiguration
    var l : User = User("te","te","te","te","te")

        override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_example)
        val users : Usuarios = Usuarios.instance
        val bundle = intent.extras

        l =  bundle?.getSerializable("Login") as User

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view_admin)
        val navController = findNavController(R.id.nav_host_fragment)
        val headerview : View = navView.getHeaderView(0)
        val nombre: TextView = headerview.findViewById(R.id.idNombre)
        nombre.setText(l.nombre)
            val mail: TextView = headerview.findViewById(R.id.idCorreo)
            mail.setText(l.email)
      //  modifyOptions(navView)

        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home,R.id.nav_List, R.id.nav_Logout
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
        navView.setNavigationItemSelectedListener(this)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_example, menu)
        return true
    }


    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when (item.itemId){

            R.id.nav_List -> {
                val i = Intent(this, CrudPersonas::class.java)
                i.putExtra("Login", l)
                startActivity(i)
              //  Toast.makeText(this, "Publicaciones Generales", Toast.LENGTH_SHORT).show()

            }
            R.id.nav_Logout -> {
               // users.setUsuarioLog(null)
                finish()
                val i = Intent(this, LoginExample::class.java)
                startActivity(i)

                Toast.makeText(this, "Se ha cerrado la sesión.", Toast.LENGTH_SHORT).show()
            }
            R.id.nav_Config-> {
                finish()
                val i = Intent(this, Configuracion::class.java )
                i.putExtra("Login", l)
                startActivity(i)
            }
            R.id.nav_Contacto-> {
                finish()
                val i = Intent(this, Informacion::class.java )
                i.putExtra("Login", l)
                startActivity(i)
            }
        }
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

//    fun modifyOptions(navView: NavigationView){
//        var menu : Menu = navView.menu
//        if(l.rol == "admin"){
//            var item:MenuItem = menu.findItem(R.id.nav_JobApp)
//            item.setVisible(false)
//        }else{
//            var item:MenuItem = menu.findItem(R.id.nav_List)
//            item.setVisible(false)
//        }
//    }

}