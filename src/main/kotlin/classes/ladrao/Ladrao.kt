package classes.ladrao

import classes.Classe

open class Ladrao : Classe() {
    override val dadoVida = 6
    override val proficiencias = mutableListOf("armas leves", "armas de arremesso", "armaduras leves")

    open fun podeAtaqueFurtivo(): Boolean = true
    open fun ouvirRuidos(): Boolean = true
}