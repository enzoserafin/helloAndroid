package com.example.helloandroid


import android.os.Bundle
import com.example.helloandroid.domain.EsqueciSenhaService
import com.example.helloandroid.extensions.alert
import kotlinx.android.synthetic.main.activity_esqueci_senha.*

class EsqueciSenhaActivity : LogActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_esqueci_senha)

        btEnviar.setOnClickListener {
            onClickEnviar()
        }
    }

    private fun onClickEnviar() {
        val login = tLogin.text.toString()
        var service = EsqueciSenhaService()
        val ok:Boolean = service.recuperarSenha(login)
        if (ok) {
            alert("Sua nova senha foi enviada para o seu e-mail.") {
                finish()
            }
        } else {
            alert("Ocorreu um erro ao recuperar a senha.")
        }
    }
}