package com.mateus.trabalho

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment


class AtividadePrincipal : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Mostra a tela principal
        setContentView(R.layout.activity_main)


        // Mostra a tela de notas
        val fragment: Fragment = FragmentoNota()

        getSupportFragmentManager().beginTransaction()
            .replace(R.id.fragment_frame, fragment, fragment.javaClass.simpleName).addToBackStack(null).commit();

    }

    fun aoClicarBotaoFlutuante(view: View) {
        val intent = Intent(view.context, AtividadeEditarNota::class.java)
        ContextCompat.startActivity(view.context, intent, null)
    }
}
