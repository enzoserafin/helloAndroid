package com.example.helloandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.helloandroid.domain.CadastroModel
import com.example.helloandroid.domain.CadastroService
import com.example.helloandroid.extensions.alert
import kotlinx.android.synthetic.main.activity_cadastro.*

class CadastroActivity : LogActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        btCadastrar.setOnClickListener{
            onClickCadastrar()
        }
    }

    private fun onClickCadastrar() {
        val termosOk = checkTermos.isChecked
        if (!termosOk) {
            alert("Aceite os termos par continuar")
        } else {
            val model = getCadastroModel()
            val service = CadastroService()
            val ok: Boolean = service.cadastrar(model)
            if (ok) {
                alert("Cadastro realizado com suscesso. \nSua senha foi enviada para o seu e-mail") {
                    finish()
                }
            } else {
                alert("Ocorreu um erro ao cadastrar")
            }
        }
    }

    private fun getCadastroModel(): CadastroModel {
        val model = CadastroModel()
        model.nome = tNome.text.toString()
        model.login = tLogin.text.toString()
        model.email = tEmail.text.toString()
        model.sexo = if (radioSexo.checkedRadioButtonId == R.id.radioMasculino) "M" else "F"
        return model
    }
}