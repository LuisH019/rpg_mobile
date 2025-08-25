package utils

class Console {
    fun clearConsole() {
        print("\u001b[H\u001b[2J")
        System.out.flush()
    }

    fun printErrorMessage() {
        println()
        println("\u001B[31mErro: Valor Inválido!")
        println("\u001B[33mDigite novamente.")
        println("\u001B[0m")
    }

    fun inputPlus(textoInput: String, min: Int, max: Int): Int {
        var valor: Int
        while (true) {
            print(textoInput)
            val input = readLine()

            val parsedValue = input?.toIntOrNull()

            if (parsedValue == null) {
                printErrorMessage()
            } else {
                if (parsedValue < min || parsedValue > max) {
                    printErrorMessage()
                } else {
                    valor = parsedValue
                    break
                }
            }
        }
        return valor
    }

}