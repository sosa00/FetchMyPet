package com.example.labExtra5

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import kotlin.collections.ArrayList

class RecyclerView_Adapter(private var items: ArrayList<JobAppObj>): RecyclerView.Adapter<RecyclerView.ViewHolder>(), Filterable {

    var itemsList: ArrayList<JobAppObj>? = null

    lateinit var mcontext: Context

    class PersonHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    init {
        this.itemsList = items
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val personListView = LayoutInflater.from(parent.context).inflate(R.layout.templatepersonas, parent, false)
        val sch = PersonHolder(personListView)
        mcontext = parent.context
        return sch
    }

    override fun getItemCount(): Int {
        return itemsList?.size!!
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = itemsList?.get(position)
        holder.itemView.findViewById<TextView>(R.id.tvNombre)?.text = item?.titulo_
        holder.itemView.findViewById<TextView>(R.id.tvDes)?.text = item?.raza_
        holder.itemView.findViewById<ImageView>(R.id.ivFoto).setImageResource(item?.foto!!)


        holder.itemView.setOnClickListener {
           // val intent = Intent(mcontext, MainActivity::class.java)
           // intent.putExtra("passselectedcountry", itemsList?.get(position))
          //  mcontext.startActivity(intent)
            Log.d("Selected:", itemsList?.get(position)?.titulo_.toString())

        }
    }


    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val charSearch = constraint.toString()
                if (charSearch.isEmpty()) {
                    itemsList = items
                } else {
                    val resultList = ArrayList<JobAppObj>()
                    for (row in items) {
                        if (row.titulo_.toLowerCase().contains(charSearch.toLowerCase())) {
                            resultList.add(row)
                        }
                    }
                    itemsList = resultList
                }
                val filterResults = FilterResults()
                filterResults.values = itemsList
                return filterResults
            }

            @Suppress("UNCHECKED_CAST")
            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                itemsList = results?.values as ArrayList<JobAppObj>
                notifyDataSetChanged()
            }

        }
    }
}

