package racas

import habilidades.Ataque
import habilidades.Detector
import habilidades.Modificador
import dados.Dado

class Anao: Raca(), Ataque, Detector, Modificador{
    init {
        movimento = 6
        infravisao = 18
        alinhamento = Alinhamento.ORDEM
    }

    //Mineradores
    override fun detectar(tipo: String, procura: Boolean, dado: Dado): Boolean {
        if (tipo != "pedra") return false
        dado.rodarDado()
        return if (procura) dado.faceAtual <= 2 else dado.faceAtual == 1
    }

    //Vigoroso
    override fun modificar(tipo: String, valor: Int): Int {
        return if (tipo == "jpc") valor + 1 else valor
    }

    //Armas Grandes
    override fun equipamentoPermitido(tipo: String): Boolean {
        return if (tipo == "armasGrandes") false else true
    }

    //Inimigos
    override fun ataqueFacilContra(alvo: String): Boolean {
        return alvo in listOf("orc", "ogro", "hobgoblin")
    }
}
