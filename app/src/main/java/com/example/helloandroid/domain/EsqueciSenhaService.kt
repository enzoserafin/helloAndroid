package com.example.helloandroid.domain

class EsqueciSenhaService {
    fun recuperarSenha(login: String): Boolean {
        return login == "enzo" || login == "teste"
    }
}