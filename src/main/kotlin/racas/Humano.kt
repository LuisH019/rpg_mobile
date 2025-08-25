package racas

import habilidades.Modificador

class Humano: Raca(), Modificador {
    init {
        movimento = 9
        alinhamento = Alinhamento.values().random()
    }

    //Aprendizado e Adaptabilidade
    override fun modificar(tipo: String, valor: Int): Int{
        return if (tipo == "xp") (valor * 1.1).toInt()
        else if (tipo=="jp") valor + 1
        else valor
    }
}