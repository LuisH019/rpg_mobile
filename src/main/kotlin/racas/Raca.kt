package racas

import habilidades.EquipamentoPermitido

abstract class Raca: EquipamentoPermitido {
    var movimento = 0
    var infravisao = 0
    var alinhamento = Alinhamento.NEUTRO

    fun exibirInformacoes(){

    }
}