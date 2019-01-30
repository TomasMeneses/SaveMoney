package com.example.tomas.savemoney

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.view.menu.ActionMenuItemView
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.StaggeredGridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.LinearLayout
import android.widget.ListView
import com.example.tomas.savemoney.Adapter.MyAdapter

import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    lateinit var mRecyclerView: RecyclerView
    var dbRef: DatabaseReference? = null
    var firebaseDatabase: FirebaseDatabase? = null
    var myRef: DatabaseReference? = null
    var lstusuarios: List<Users>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        mRecyclerView = findViewById(R.id.recyView)
        firebaseDatabase = FirebaseDatabase.getInstance()
        myRef = firebaseDatabase!!.getReference()

        lstusuarios = usuarios()
        mRecyclerView.adapter = MyAdapter(lstusuarios as ArrayList<Users>, this) // diferente aqui
        val layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)
        mRecyclerView.layoutManager = layoutManager

        imageViewgraf.setOnClickListener {
            val i = Intent(this, GraficosActivity::class.java)
            startActivity(i)
        }
        imageViewPerfil.setOnClickListener {
            val i = Intent(this, PerfilActivity::class.java)
            startActivity(i)
        }

        imageViewAdd.setOnClickListener {
            val i = Intent(this, ListaActivity::class.java)
            startActivity(i)
        }



    }


    fun usuarios(): List<Users>{
        var usuario: ArrayList<Users> = ArrayList()
        val newReference = firebaseDatabase!!.getReference("usuarios")

        newReference.addValueEventListener(object : ValueEventListener {

            override fun onDataChange(p0: DataSnapshot) {


                usuario.clear()

                for (snapshot in p0.children) {

                    val hashMap = snapshot.value as HashMap<String, String>

                    if (hashMap.size > 0) {

                        val userdados = Users(hashMap["email"], hashMap["id"])
                             usuario.add(userdados)

                    }
                }
            }

            override fun onCancelled(p0: DatabaseError) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

        })
        return usuario

    }
    }


