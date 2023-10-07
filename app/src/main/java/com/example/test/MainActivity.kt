package com.example.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.SeekBar

class MainActivity : AppCompatActivity() {

    private lateinit var editTextDescription: EditText
    private lateinit var seekBarSize: SeekBar
    private lateinit var checkBoxUpperCase: CheckBox
    private lateinit var checkBoxNumbers: CheckBox
    private lateinit var checkBoxSpecialChars: CheckBox
    private lateinit var buttonAlterar: Button
    private lateinit var buttonEditar: Button
    private lateinit var buttonCancelar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicialize os componentes de UI
        editTextDescription = findViewById(R.id.editTextDescription)
        seekBarSize = findViewById(R.id.seekBarSize)
        checkBoxUpperCase = findViewById(R.id.checkBoxUpperCase)
        checkBoxNumbers = findViewById(R.id.checkBoxNumbers)
        checkBoxSpecialChars = findViewById(R.id.checkBoxSpecialChars)
        buttonAlterar = findViewById(R.id.buttonAlterar)
        buttonEditar = findViewById(R.id.buttonEditar)
        buttonCancelar = findViewById(R.id.buttonCancelar)

        // Configurar um ouvinte de clique para o botão "Alterar"
        buttonAlterar.setOnClickListener {
            // Obtenha os valores das configurações do usuário
            val descricao = editTextDescription.text.toString()
            val tamanho = seekBarSize.progress
            val usarLetrasMaiusculas = checkBoxUpperCase.isChecked
            val usarNumeros = checkBoxNumbers.isChecked
            val usarCaracteresEspeciais = checkBoxSpecialChars.isChecked

            // Chame uma função para gerar a senha com base nas configurações do usuário
            val senhaGerada = gerarSenha(
                descricao,
                tamanho,
                usarLetrasMaiusculas,
                usarNumeros,
                usarCaracteresEspeciais
            )

            // Exiba a senha gerada ou faça algo com ela
            // Por exemplo, exiba-a em um TextView ou em um Toast
        }

        // Configurar um ouvinte de clique para o botão "Editar"
        buttonEditar.setOnClickListener {
            // Implemente a ação desejada quando o botão "Editar" for clicado
        }

        // Configurar um ouvinte de clique para o botão "Cancelar"
        buttonCancelar.setOnClickListener {
            // Implemente a ação desejada quando o botão "Cancelar" for clicado
        }
    }

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

        return senhaGerada.toString()
    }
}

