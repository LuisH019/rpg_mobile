package classes.mago

class Ilusionista : Mago() {

    override fun circuloMaximoMagia(): Int = 6

    private val magiasExclusivas = mutableSetOf("Ilusão", "Som Ilusório", "Ilusão Melhorada", "Miragem")
    private var usosExclusivosRestantes: Int = 1

    fun conheceMagiaExclusiva(nomeMagia: String): Boolean {
        return magiasExclusivas.contains(nomeMagia)
    }

    fun conjurarMagiaExclusiva(nomeMagia: String): Boolean {
        if (!conheceMagiaExclusiva(nomeMagia)) {
            println("Magia '$nomeMagia' não é exclusiva do Ilusionista ou não está no grimório.")
            return false
        }
        if (usosExclusivosRestantes > 0) {
            usosExclusivosRestantes -= 1
            println("Conjurou '$nomeMagia' como magia exclusiva (uso grátis diário).")
            return true
        } else {
            println("Sem usos exclusivos restantes hoje — use um espaço de magia memorizada para conjurar '$nomeMagia'.")
            return true
        }
    }

    fun dificuldadeJPContraMagiaExclusiva(): String = "difícil"

    fun restaurarUsosExclusivos() {
        usosExclusivosRestantes = 1
    }
}