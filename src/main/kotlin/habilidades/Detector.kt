package habilidades

import dados.Dado

interface Detector {
    fun detectar(tipo: String, procura: Boolean, dado: Dado): Boolean
}