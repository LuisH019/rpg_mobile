package habilidades

interface Ataque {
    fun ataqueFacilContra(alvo: String): Boolean{
        return false
    }
    fun ataqueDificilContra(alvo: String): Boolean{
        return false
    }
}