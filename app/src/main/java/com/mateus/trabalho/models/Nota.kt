package com.mateus.trabalho.models

import java.io.Serializable
import java.util.*

data class Nota(val id:UUID, val texto: String) : Serializable {
    override fun toString(): String = "$texto"
    override fun hashCode(): Int {
        return id.toString().hashCode()
    }

    override fun equals(other: Any?): Boolean {
        if(other is Nota) {
            return other.id == this.id
        } else {
            return false
        }
    }
}