package personagem

import classes.Classe
import racas.Raca
import kotlin.collections.iterator

class Personagem(val raca: Raca, val classe: Classe) {
    val atributos = mutableMapOf(
        "forca" to 0,
        "destreza" to 0,
        "constituicao" to 0,
        "inteligencia" to 0,
        "sabedoria" to 0,
        "carisma" to 0
    )

    fun exibirAtributos(){
        println("=======================")
        println("ATRIBUTOS DO PERSONAGEM")
        for ((atributo, valor) in this.atributos) {
            println("$atributo: $valor")
        }
        println("=======================")
    }
}