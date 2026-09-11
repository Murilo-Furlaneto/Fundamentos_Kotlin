package exercicios.extensoes

/**
 * EXERCÍCIO 01: EXTENSÕES E FUNÇÕES INFIX
 * 
 * Objetivo:
 * 1. Crie uma Extension Function para a classe String chamada 'limparFormatacao()' 
 *    que remova todos os caracteres que não sejam números (dica: use regex ou filter).
 * 2. Crie uma Infix Function para a classe Int chamada 'ate' que retorne a soma de 
 *    todos os números entre o número atual e o número passado (ex: 1 ate 3 = 1+2+3 = 6).
 * 3. No main, use a extensão para limpar um CPF formatado "123.456.789-00" 
 *    e a função infix para calcular "1 ate 10".
 */

fun main() {
    val cpf = "123.456.789-00"
    println("CPF formatado: ${cpf.limparFormatacao()}")

    val sum = 1 ate 10
    println(sum)
}


fun String.limparFormatacao(): String {
    return this.filter { it.isDigit() }
}

infix  fun Int.ate(other: Int): Int {
    var sum = 0
    for (i in this..other) {
        sum += i
    }
    return sum
}
