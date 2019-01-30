package com.example.tomas.savemoney

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.StaggeredGridLayoutManager
import com.example.tomas.savemoney.Adapter.MyAdapter
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_lista.*

class ListaActivity : AppCompatActivity() {

    var lstusuarios: List<Users>? = null
    var firebaseDatabase: FirebaseDatabase? = null
    var myRef: DatabaseReference? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista)

        firebaseDatabase = FirebaseDatabase.getInstance()
        myRef = firebaseDatabase!!.getReference()

        lstusuarios = usuarios()
        val recyclerView = list_recyclerview
        recyclerView.adapter =MyAdapter(lstusuarios as ArrayList<Users>, this)
        val layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)
        recyclerView.layoutManager = layoutManager

    }
    fun usuarios(): List<Users> {

        var usuario: ArrayList<Users> = ArrayList()

        val newReference = firebaseDatabase!!.getReference("usuarios")

        newReference.addValueEventListener(object : ValueEventListener {

            override fun onDataChange(p0: DataSnapshot) {


                usuario.clear()

                for (snapshot in p0.children) {

                    val hashMap = snapshot.value as HashMap<String, String>

                    if (hashMap.size > 0) {

                        val userdados = Users(hashMap["email"], hashMap["Id"])
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
