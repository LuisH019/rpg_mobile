package classes.clerigo

import dados.Dado

class Academico : Clerigo() {
    var alinhamentoNeutro: Boolean = true
    var usaApenasImpactantes: Boolean = true

    override fun podeCurarMilagrosamente(): Boolean = false
    override fun podeAfastarMortosVivos(): Boolean = false

    fun conhecimentoAcademico(dado: Dado): Boolean {
        dado.rodarDado()
        val limite = if (nivel < 3) 2 else 3
        val sucesso = dado.faceAtual in 1..limite
        println("Conhecimento Acadêmico (${if (nivel < 3) "1-2" else "1-3"} em 1d6): ${if (sucesso) "sucesso" else "falha"}")
        return sucesso
    }

    fun decifrarLinguagens(dado: Dado): Boolean {
        if (nivel < 3) {
            println("Ainda não pode Decifrar Linguagens (requer 3º nível).")
            return false
        }
        dado.rodarDado()
        val sucesso = dado.faceAtual in 1..3
        println("Decifrar Linguagens (1-3 em 1d6): ${if (sucesso) "sucesso" else "falha"}")
        return sucesso
    }

    fun lendasETradicoes(dado: Dado): Boolean {
        if (nivel < 6) {
            println("Ainda não pode Lendas e Tradições (requer 6º nível).")
            return false
        }

        dado.rodarDado()

        val sucesso = dado.faceAtual in 1..3
        println("Lendas e Tradições (1-3 em 1d6): ${if (sucesso) "sucesso" else "falha"}")
        return sucesso
    }
}