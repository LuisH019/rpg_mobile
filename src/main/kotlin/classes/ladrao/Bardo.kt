package classes.ladrao

import dados.Dado

class Bardo : Ladrao() {
    override fun podeAtaqueFurtivo(): Boolean = false 

    fun influenciar(tornarHostil: Boolean = false, dado: Dado): Boolean {
        dado.rodarDado()
        val sucesso = dado.faceAtual in 1..2
        val mod = if (tornarHostil) -1 else +1
        println("Influenciar (1-2 em 1d6): ${if (sucesso) "sucesso (modificador ${mod} no teste de reação)" else "falha"}")
        return sucesso
    }

    fun inspirar(dado: Dado): Boolean {
        dado.rodarDado()
        val sucesso = dado.faceAtual in 1..2  // exige ao menos uma rodada atuando; aqui simplificado
        println("Inspirar aliados: ${if (sucesso) "sucesso (testes/ataques 1 passo mais fáceis)" else "falha"}")
        return sucesso
    }

    fun fascinar(dado: Dado): Boolean {
        dado.rodarDado()
        val sucesso = dado.faceAtual in 1..2
        println("Fascinar audiência (1-2 em 1d6): ${if (sucesso) "sucesso" else "falha"}")
        return sucesso
    }
}