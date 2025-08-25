package classes.mago

import classes.Classe

open class Mago : Classe() {
    override val dadoVida = 4
    override val proficiencias = mutableListOf("cajados", "adagas")

    open fun circuloMaximoMagia(): Int = 9
}