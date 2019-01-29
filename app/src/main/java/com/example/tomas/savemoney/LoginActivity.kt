package com.example.tomas.savemoney

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import kotlinx.android.synthetic.main.activity_login.*
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    var mAuth = FirebaseAuth.getInstance()
//    var mAuth : FirebaseAuth? = null
//    var mAuthListening : FirebaseAuth.AuthStateListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnLogin.setOnClickListener {

            login()
//            val i = Intent(this, HomeActivity::class.java)
//            startActivity(i)
        }
        btnCadastrar.setOnClickListener {
            val i = Intent(this, CadastroActivity::class.java)
            startActivity(i)
        }
    }

    fun login(){
//        val emailTxt = findViewById<View>(R.id.editTxtMail)
//        val senhaTxt = findViewById<View>(R.id.editTxtSenha)

        val email = editTxtMail.text.toString()
        val senha = editTxtSenha.text.toString()

        if(!email.isEmpty() && !senha.isEmpty()){
            mAuth.signInWithEmailAndPassword(email,senha)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful){
                        val i = Intent(this, HomeActivity::class.java)
                        startActivity(i)
                    }else{
                        Toast.makeText(this,R.string.erro,Toast.LENGTH_SHORT).show()
                    }
                }
        }else{
            Toast.makeText(this,R.string.preencher,Toast.LENGTH_SHORT).show()
        }
    }


}
