package com.mateus.trabalho.utils

import com.mateus.trabalho.models.Nota
import java.util.ArrayList

class ArmazenaNotas {
    companion object {
        var notas: MutableList<Nota> = ArrayList()
    }
}