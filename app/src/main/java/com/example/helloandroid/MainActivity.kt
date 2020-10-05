package com.example.helloandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.example.helloandroid.domain.LoginService
import com.example.helloandroid.extensions.alert

class MainActivity : LogActivity() {

    private var count = 0


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(savedInstanceState != null) {
            count = savedInstanceState.getInt("count")
        }
        Log.d("faculdade", "Count: $count")

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

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d("faculdade", "Salvando estado")
        count++
        outState.putInt("count", count)
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
            finish()
        val intent = Intent(this, HomeActivity::class.java)
            val args = Bundle()
            args.putSerializable("usuario", user)
            intent.putExtras(args)
            startActivity(intent)
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