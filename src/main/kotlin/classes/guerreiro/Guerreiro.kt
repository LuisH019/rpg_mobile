package classes.guerreiro

import classes.Classe

open class Guerreiro : Classe() {
    override val dadoVida = 10
    override val proficiencias = mutableListOf("todas as armas", "todas as armaduras", "escudos")

    open fun ataqueExtraDisponivel(): Boolean = nivel >= 6
}