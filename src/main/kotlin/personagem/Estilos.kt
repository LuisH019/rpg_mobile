package personagem

import dados.Dado
import rpg.dados.somar
import kotlin.collections.iterator

class Estilos{
    fun estiloClassico(dados: MutableList<Dado>): Map<String, Int>{
        val atributos = mutableMapOf(
            "forca" to 0,
            "destreza" to 0,
            "constituicao" to 0,
            "inteligencia" to 0,
            "sabedoria" to 0,
            "carisma" to 0
        )
        for((atributo, valor) in atributos){
            atributos[atributo] = dados.somar()
        }
        return atributos
    }

    private fun estiloEscolhivel(dados: MutableList<Dado>, isHeroico: Boolean): List<Int> {
        val valoresGerados = mutableListOf<Int>()
        var resultadoSomaDados = 0

        for (i in 1..6) {
            resultadoSomaDados = dados.somar()

            if (isHeroico){
                resultadoSomaDados = resultadoSomaDados - (dados.minOfOrNull { it.faceAtual } ?: 0)
            }
            valoresGerados.add(resultadoSomaDados)
        }
        return valoresGerados
    }

    fun estiloAventureiro(dados: MutableList<Dado>): List<Int>{
        return estiloEscolhivel(
            dados,
            false
        )
    }

    fun estiloHeroico(dados: MutableList<Dado>): List<Int> {
        return estiloEscolhivel(
            dados,
            true
        )
    }
}