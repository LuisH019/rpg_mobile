package racas

import dados.Dado
import habilidades.Detector
import habilidades.Imunidade
import habilidades.Modificador

class Elfo: Raca(), Detector, Imunidade, Modificador {
    init {
        movimento = 9
        infravisao = 18
    }

    //Percepção Natural
    override fun detectar(tipo: String, procura: Boolean, dado: Dado): Boolean {
        if (tipo != "portaSecreta") return false
        dado.rodarDado()
        return if (procura) dado.faceAtual <= 2 else dado.faceAtual == 1
    }

    //Graciosos e Arma Racial
    override fun modificar(tipo: String, valor: Int): Int {
        return if (tipo == "jp") valor + 1 else if (tipo == "arco") valor + 1 else valor
    }

    //Imunidades
    override fun eImune(efeito: String): Boolean {
        return efeito in listOf("sono", "paralisia_ghoul")
    }
}
