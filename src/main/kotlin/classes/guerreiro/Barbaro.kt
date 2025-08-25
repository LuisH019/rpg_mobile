package classes.guerreiro

import dados.Dado
import kotlin.math.max

class Barbaro : Guerreiro() {
    var usaApenasCouro: Boolean = true
    var usaItemMagico: Boolean = false

    fun camuflagemNatural(dado: Dado): Boolean {
        dado.rodarDado()
        val sucesso = dado.faceAtual in 1..2
        println("Camuflagem natural: ${if (sucesso) "sucesso" else "falha"} (1-2 em 1d6)")
        return sucesso
    }

    fun escalar(alturaMetros: Int, dado: Dado): Boolean {
        dado.rodarDado()
        val sucesso = dado.faceAtual in 1..3
        if (sucesso) {
            println("Escalada bem-sucedida (1-3 em 1d6).")
            return true
        } else {
            val alturaQueda = max(1, alturaMetros / 2)
            val dadosQueda = max(1, alturaQueda / 3)
            var dano = 0
            repeat(dadosQueda) {
                val q = Dado(6); q.rodarDado(); dano += q.faceAtual
            }
            println("Falha na escalada: caiu ~${alturaQueda}m e sofreu ${dano} de dano (${dadosQueda}d6).")
            return false
        }
    }

    fun surpresaSelvagem(ambienteNatural: Boolean, dado: Dado): Boolean {
        if (!ambienteNatural) return false
        dado.rodarDado()
        val sucesso = dado.faceAtual in 1..4
        println("Surpresa selvagem no ermo: ${if (sucesso) "sim" else "não"} (1-4 em 1d6)")
        return sucesso
    }

    fun chanceDeSerSurpreendidoNoErmo(dado: Dado): Boolean {
        dado.rodarDado()
        val surpreendido = dado.faceAtual == 1
        println("Bárbaro surpreendido no ermo? ${if (surpreendido) "sim (1 em 1d6)" else "não"}")
        return surpreendido
    }
}