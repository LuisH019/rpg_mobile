// DadoExt.kt
package rpg.dados

import dados.Dado

fun MutableList<Dado>.somar(): Int {
    for (dado in this) {
        dado.rodarDado()
    }
    return this.sumOf { it.faceAtual }
}
