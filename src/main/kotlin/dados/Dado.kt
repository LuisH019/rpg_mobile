package dados

import java.util.Random

class Dado(var numFaces: Int) {
    var faceAtual: Int = 0

    fun rodarDado(){
        val gerador = Random()

        faceAtual = gerador.nextInt(numFaces) + 1
    }
}