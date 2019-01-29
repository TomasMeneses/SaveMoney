package com.example.tomas.savemoney

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.LinearLayout
import android.widget.ListView
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        recycleView_main.layoutManager = LinearLayoutManager(this)

        imageViewgraf.setOnClickListener {
            val i = Intent(this, GraficosActivity::class.java)
            startActivity(i)
        }
        imageViewPerfil.setOnClickListener {
            val i = Intent(this, PerfilActivity::class.java)
            startActivity(i)
        }


    }
}
