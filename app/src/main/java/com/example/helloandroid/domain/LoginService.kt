package com.example.helloandroid.domain

class LoginService {
    fun login(login: String, senha: String): Usuario? {
        if (login == "enzo" && senha == "123") {
            return Usuario("Enzo", "a@a.com")
        } else if( login == "teste" && senha == "123") {
            return Usuario("Teste", "b@b.com")
        }
        return null
    }
}