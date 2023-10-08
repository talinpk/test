package com.example.test

import java.lang.StringBuilder



private fun gerarSenha(
    descricao: String,
    tamanho: Int,
    usarLetrasMaiusculas: Boolean,
    usarNumeros: Boolean,
    usarCaracteresEspeciais: Boolean
): String {
    val caracteresPermitidos = StringBuilder()


    if (usarLetrasMaiusculas) {
        caracteresPermitidos.append("ABCDEFGHIJKLMNOPQRSTUVWXYZ")
    }


    if (usarNumeros) {
        caracteresPermitidos.append("0123456789")
    }


    if (usarCaracteresEspeciais) {
        caracteresPermitidos.append("!@#$%^&*()_+{}[]|\\:;<>,.?/~")
    }


    val tamanhoCaracteresPermitidos = caracteresPermitidos.length


    if (tamanhoCaracteresPermitidos == 0) {
        return ""
    }

    val senhaGerada = StringBuilder()


    for (i in 0 until tamanho) {
        val indiceAleatorio = (0 until tamanhoCaracteresPermitidos).random()
        val caractereAleatorio = caracteresPermitidos[indiceAleatorio]
        senhaGerada.append(caractereAleatorio)
    }

    /
    return senhaGerada.toString()
}
