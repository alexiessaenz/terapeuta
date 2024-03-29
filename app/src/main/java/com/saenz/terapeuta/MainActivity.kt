package com.saenz.terapeuta

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var rvadapter: RecyclerView.Adapter<*>
    private lateinit var viewlayoutManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewlayoutManager = LinearLayoutManager(this)

        rvadapter = PacienteAdapter(Supplier.pacientes)



        rv.apply {
            layoutManager = viewlayoutManager
            adapter = rvadapter

        }


    }




}