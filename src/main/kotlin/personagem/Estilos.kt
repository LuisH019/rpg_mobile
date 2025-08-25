package personagem

import dados.Dado
import rpg.dados.somar
import utils.Console
import kotlin.collections.iterator

class Estilos{
    fun estiloClassico(personagem: Personagem, dados: MutableList<Dado>){
        for((atributo, valor) in personagem.atributos){
            personagem.atributos[atributo] = dados.somar()
        }
    }

    private fun estiloEscolhivel(personagem: Personagem, dados: MutableList<Dado>, isHeroico: Boolean) {
        val console = Console()
        val valoresGerados = mutableListOf<Int>()
        var resultadoSomaDados = 0

        for (i in 1..personagem.atributos.size) {

            resultadoSomaDados = dados.somar()

            if (isHeroico){
                resultadoSomaDados = resultadoSomaDados - (dados.minOfOrNull { it.faceAtual } ?: 0)
            }

            valoresGerados.add(resultadoSomaDados)
        }

        for ((atributo, valor) in personagem.atributos) {
            for (i in 0..valoresGerados.size - 1) {
                println("${(i + 1)} - Valor: ${valoresGerados.get(i)}")
            }

            val opcao = console.inputPlus(
                "Digite qual desses valores vai para ${atributo}: ",
                1,
                valoresGerados.size
            )

            personagem.atributos[atributo] = valoresGerados.get(opcao - 1)

            valoresGerados.removeAt(opcao - 1)

            console.clearConsole()
        }
    }

    fun estiloAventureiro(personagem: Personagem, dados: MutableList<Dado>){
        estiloEscolhivel(
            personagem,
            dados,
            false
        )
    }

    fun estiloHeroico(personagem: Personagem, dados: MutableList<Dado>) {
        estiloEscolhivel(
            personagem,
            dados,
            true
        )
    }
}


