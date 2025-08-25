package classes

abstract class Classe {
    open val dadoVida: Int = 0
    open val proficiencias: MutableList<String> = mutableListOf()
    var nivel: Int = 1
        private set

    open fun descricaoClasse() {

    }

    open fun subirNivel() {
        nivel += 1
    }
}