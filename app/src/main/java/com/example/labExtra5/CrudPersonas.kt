package com.example.labExtra5

import android.content.Intent
import android.graphics.Canvas
import android.graphics.Color
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.content.ContextCompat
import androidx.navigation.ui.AppBarConfiguration
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import it.xabaras.android.recyclerview.swipedecorator.RecyclerViewSwipeDecorator
import java.util.*

class CrudPersonas : AppCompatActivity() {
    private lateinit var appBarConfiguration: AppBarConfiguration
    var jobs: JobApps = JobApps.instance
    var l :User = User("test","test","test","test","test")
    lateinit var lista:RecyclerView
    lateinit var adaptador:RecyclerView_Adapter
    lateinit var jobApp: JobAppObj
    var archived = ArrayList<JobAppObj>()
    var position: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        this.setTitle("Publicaciones");
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crud_personas)
        val bundle = intent.extras
        l =  bundle?.getSerializable("Login") as User
        val searchIcon = findViewById<ImageView>(R.id.search_mag_icon)
        searchIcon.setColorFilter(Color.BLACK)


        val cancelIcon = findViewById<ImageView>(R.id.search_close_btn)
        cancelIcon.setColorFilter(Color.BLACK)


        val textView = findViewById<TextView>(R.id.search_src_text)
        textView.setTextColor(Color.BLACK)

        lista = findViewById(R.id.lista)
        lista.layoutManager = LinearLayoutManager(lista.context)
        lista.setHasFixedSize(true)

        findViewById<SearchView>(R.id.person_search).setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                adaptador.filter.filter(newText)
                return false
            }
        })

        getListOfJobs()

        val itemTouchHelperCallback = object : ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP or ItemTouchHelper.DOWN or ItemTouchHelper.START or ItemTouchHelper.END, ItemTouchHelper.RIGHT) {
            override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean {
                val fromPosition: Int = viewHolder.adapterPosition
                val toPosition: Int = target.adapterPosition

                Collections.swap(jobs.getJobApps(), fromPosition, toPosition)

                lista.adapter?.notifyItemMoved(fromPosition, toPosition)

                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {

                position = viewHolder.adapterPosition

                if(direction == ItemTouchHelper.RIGHT){
//                    jobApp = JobAppObj(jobs.getJobApps()[position].titulo_, jobs.getJobApps()[position].raza_, jobs.getJobApps()[position].descripcion_, jobs.getJobApps()[position].foto)
//                    archived.add(jobApp)
//                    jobs.deleteJobApp(position)
//                    lista.adapter?.notifyItemRemoved(position)
//
//                    Snackbar.make(lista,"Publicación eliminada.", Snackbar.LENGTH_LONG).setAction("Undo") {
//                        jobs.getJobApps().add(position, jobApp)
//                        lista.adapter?.notifyItemInserted(position)
//                    }.show()
//                    adaptador = RecyclerView_Adapter(jobs.getJobApps())
//                    lista.adapter = adaptador
               // }else{
                    jobApp = JobAppObj(jobs.getJobApps()[position].titulo_, jobs.getJobApps()[position].raza_, jobs.getJobApps()[position].descripcion_, jobs.getJobApps()[position].foto)
                    archived.add(jobApp)
                    editJobApp(jobApp,position)
                    lista.adapter?.notifyItemRemoved(position)

                    Snackbar.make(lista,"Ver publicación a detalle", Snackbar.LENGTH_LONG).setAction("Undo") {
                        archived.removeAt(archived.lastIndexOf(jobApp))
                        jobs.getJobApps().add(position, jobApp)
                        lista.adapter?.notifyItemInserted(position)
                    }.show()
                    adaptador = RecyclerView_Adapter(jobs.getJobApps())
                    lista.adapter = adaptador
                    //getListOfPersons()
                }
            }

            override fun onChildDraw(c: Canvas, recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, dX: Float, dY: Float, actionState: Int, isCurrentlyActive: Boolean) {

                RecyclerViewSwipeDecorator.Builder(this@CrudPersonas, c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
                //    .addSwipeLeftBackgroundColor(ContextCompat.getColor(this@CrudPersonas, R.color.red))
              //      .addSwipeLeftActionIcon(R.drawable.ic_baseline_delete_24)
                    .addSwipeRightBackgroundColor(ContextCompat.getColor(this@CrudPersonas, R.color.salmon))
                    .addSwipeRightActionIcon(android.R.drawable.ic_menu_view)
                    .create()
                    .decorate()
                super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
            }

        }



        val itemTouchHelper = ItemTouchHelper(itemTouchHelperCallback)
        itemTouchHelper.attachToRecyclerView(lista)



        val add: FloatingActionButton = findViewById(R.id.add)
        add.setOnClickListener { view ->

            Snackbar.make(view, "Add Application", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
            val i = Intent(this, InsertarActivity::class.java)
            l =  bundle?.getSerializable("Login") as User
            i.putExtra("Login",l)
            startActivity(i)
        }

        val back: FloatingActionButton = findViewById(R.id.back)
        back.setOnClickListener {
            val i = Intent(this, MenuAdmin::class.java)
            l =  bundle?.getSerializable("Login") as User
            i.putExtra("Login",l)
            startActivity(i)
        }


    }

    private fun getListOfJobs() {
        val Npersonas = ArrayList<JobAppObj>()
        for (p in jobs.getJobApps()) {
            Npersonas.add(p)
        }
        adaptador = RecyclerView_Adapter(Npersonas)
        lista.adapter = adaptador
    }

    private fun editJobApp(job: JobAppObj, position: Int){
        val i = Intent(this, editarActivity::class.java)
        i.putExtra("Login",l)
        i.putExtra("JobApplication", job)
        i.putExtra("position",position)
        startActivity(i)
    }

}