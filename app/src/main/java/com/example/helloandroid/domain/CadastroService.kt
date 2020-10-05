package com.example.helloandroid.domain

import android.util.Log

class CadastroService {
    fun cadastrar (model: CadastroModel): Boolean {
        Log.d("faculdade", "Cadastro $model")
        return true
    }
}