package com.example.tomas.savemoney

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_cadastro.*
import java.util.*

class CadastroActivity : AppCompatActivity(){

    var mAuth = FirebaseAuth.getInstance()
    var firebaseDatabase: FirebaseDatabase? = null
    var dbRef: DatabaseReference? = null
    var selected: Uri? = null




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        firebaseDatabase = FirebaseDatabase.getInstance()
        dbRef = firebaseDatabase!!.reference

        btnCadastrar.setOnClickListener {
            registrar()
        }
    }

    fun registrar() {
        var email = editTxtMail.text.toString()
        var senha = editTxtSenha.text.toString()
        var senhaconf = editTxtSenhaConf.text.toString()

        var uuid = UUID.randomUUID()
        var uuidString = uuid.toString()


        if (email.isEmpty() && senha.isEmpty() && senhaconf.isEmpty()) {
            Toast.makeText(this, R.string.preencher, Toast.LENGTH_SHORT).show()


        } else {
            if (senha.equals(senhaconf)) {
                mAuth.createUserWithEmailAndPassword(email, senha).addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        val user = mAuth!!.currentUser
                        val userEmail = user!!.email.toString()

                        dbRef!!.child("usuarios").child(uuidString).child("Id").setValue(uuidString)
                        dbRef!!.child("usuarios").child(uuidString).child("email").setValue(userEmail)
                        dbRef!!.child("usuarios").child(uuidString).child("senha").setValue(senha)
                        Toast.makeText(this, R.string.sucesso, Toast.LENGTH_SHORT).show()
                        val i = Intent(this, LoginActivity::class.java)
                        startActivity(i)
                    } else {
                        Toast.makeText(this, R.string.preencher, Toast.LENGTH_SHORT).show()
                    }
                }
            }

        }
    }
}



