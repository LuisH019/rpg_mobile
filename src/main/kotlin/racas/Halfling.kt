package racas

import dados.Dado
import habilidades.Ataque
import habilidades.Detector
import habilidades.EquipamentoPermitido
import habilidades.Modificador

class Halfling: Raca(), Ataque, EquipamentoPermitido, Detector, Modificador {
    init {
        movimento = 6
        infravisao = 0
        alinhamento = Alinhamento.NEUTRO
    }

    //Furtivos
    override fun detectar(tipo: String, procura: Boolean, dado: Dado): Boolean {
        if (tipo != "esconder") return false
        dado.rodarDado()
        return dado.faceAtual <= 2
    }

    //Destemidos
    override fun modificar(tipo: String, valor: Int): Int {
        return if (tipo=="jps") valor + 1 else valor
    }

    //BonsDeMira
    override fun ataqueFacilContra(alvo: String): Boolean {
        return alvo == "arremesso"
    }

    //Pequenos
    override fun ataqueDificilContra(alvo: String): Boolean {
        return alvo in listOf("grande", "gigante")
    }

    //Restricoes
    override fun equipamentoPermitido(tipo: String): Boolean {
        return if (tipo=="armaGrande") true else false
    }
}
