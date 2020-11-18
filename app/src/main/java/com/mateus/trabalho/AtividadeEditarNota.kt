package com.mateus.trabalho

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.mateus.trabalho.models.Nota
import com.mateus.trabalho.utils.ArmazenaNotas
import java.util.*


class AtividadeEditarNota : AppCompatActivity() {
    lateinit var nota : Nota
    lateinit var  editText: EditText
    lateinit var  sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.editar_nota)

        // Pega as notas no banco de dados
        sharedPreferences =
            getSharedPreferences("NOTAS", Context.MODE_PRIVATE)

        editText = findViewById<EditText>(R.id.edit_text)
        editText.text.clear()
        val extras = intent.extras
        // Se for em modo de editar essa variável terá valor
        if(extras != null) {
            // Recebe a nota enviada por parâmetro
            val item = extras["NOTA"] as Nota
            nota = item

            editText.text.append(item.texto)
        } else { // Nesse caso é para adicionar uma nova
            nota = Nota(UUID.randomUUID(), "")
        }

    }

    override fun onPause() {
        super.onPause()
        // Coloca em modo de edição o banco de dados local
        val editor = sharedPreferences.edit()
        // Adiciona a nota no banco de dados
        editor.putString(nota.id.toString(), editText.text.toString())
        // Caso seja uma nova nota, isto é, não está armazenada. Adiciona na lista da tela inicial
        if (!ArmazenaNotas.notas.contains(nota)) {
            ArmazenaNotas.notas.add(nota)
        }

        // Confirma as alterações no banco de dados
        editor.apply()

    }
}
