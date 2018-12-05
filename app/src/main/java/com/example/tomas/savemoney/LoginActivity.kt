package com.example.tomas.savemoney

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnLogin.setOnClickListener {

            val i = Intent(this, HomeActivity::class.java)
            startActivity(i)
        }
        btnCadastrar.setOnClickListener {
            val i = Intent(this, CadastroActivity::class.java)
            startActivity(i)
        }
    }
}
