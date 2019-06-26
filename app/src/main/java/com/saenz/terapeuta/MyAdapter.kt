package com.saenz.terapeuta

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_items.view.*
import android.content.res.Resources
import android.util.Log

import com.saenz.terapeuta.Paciente

//import com.saenz.terapeuta.R

class MyAdapter(private val myDataset: List<Paciente>) :  RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): MyAdapter.MyViewHolder {
        // create a new view
       // val view = LayoutInflater.from(parent.context).inflate(R.layout.list_items, parent, false)
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_items,parent,false)
        // set the view's size, margins, paddings and layout parameters

        return MyViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        val pacientes = myDataset[position]
        holder.setData( pacientes)
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = myDataset.size

    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){


        fun setData(pacientes: Paciente?){
            itemView.txvTitle.text = pacientes!!.nombre
            itemView.setOnClickListener {

                var nombre:String=pacientes.nombre
                var apellido:String=pacientes.apellido
                var edad:String=pacientes.edad
                var direccion:String=pacientes.direccion

                val intent:Intent = Intent( itemView.context,Datos::class.java)
                intent.putExtra("Nombre",nombre)
                intent.putExtra("Apellido",apellido)
                intent.putExtra("Edad",edad)
                intent.putExtra("Direccion",direccion)
                itemView.context.startActivity(intent)
            }


        }
    }
}