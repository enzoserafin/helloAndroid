package com.example.helloandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.example.helloandroid.domain.LoginService
import com.example.helloandroid.extensions.alert

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btLogin).setOnClickListener{
            onClickLogin()
        }

        findViewById<TextView>(R.id.btEsqueciSenha).setOnClickListener{
            onEsqueciSenha()
        }

        findViewById<TextView>(R.id.btCadastrar).setOnClickListener{
            onClickCadastrar()
        }
    }

    private fun onClickLogin() {
        val tLogin = findViewById<TextView>(R.id.tLogin)
        val tSenha = findViewById<TextView>(R.id.tSenha)

        val login = tLogin.text.toString()
        val senha = tSenha.text.toString()
        Log.d("faculdade", "Login: $login, senha: $senha")

        val loginRep = LoginService()
        val user = loginRep.login(login, senha)
        if (user != null) {
            startActivity(Intent(this,HomeActivity::class.java))
            finish()
        } else {
            alert("Login incorreto, digite os dados novamente")
        }
    }
    private fun onEsqueciSenha() {
        startActivity(Intent(this,EsqueciSenhaActivity::class.java))
    }

    private fun onClickCadastrar() {
        startActivity(Intent(this,CadastroActivity::class.java))
    }
}