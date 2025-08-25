package classes.clerigo

import classes.Classe

open class Clerigo : Classe() {
    override val dadoVida = 8
    override val proficiencias = mutableListOf("armas impactantes", "armaduras leves", "armaduras médias", "escudos")

    open fun podeCurarMilagrosamente(): Boolean = true
    open fun podeAfastarMortosVivos(): Boolean = true
}