package exercicios.funcoes

/**
 * EXERCÍCIO 01: CALCULADORA FLEXÍVEL
 * 
 * Objetivo:
 * 1. Crie uma função chamada 'executarOperacao' que recebe dois números (Int) 
 *    e uma função lambda '(Int, Int) -> Int'.
 * 2. No main, use a 'executarOperacao' para realizar:
 *    - Uma soma.
 *    - UMa multiplicação.
 *    - Uma subtração (passando a lambda diretamente entre chaves).
 * 3. Imprima os resultados.
 */
fun main() {
    // 1. A função de ordem superior (recebe outra função como parâmetro)
    fun executarOperacao(a: Int, b: Int, operacao: (Int, Int) -> Int): Int {
        return operacao(a, b)
    }

    // 2. Usando com funções prontas (referência ::)
    val resultadoSoma = executarOperacao(10, 5, ::soma)
    println("Soma: $resultadoSoma")

    val resultadoMult = executarOperacao(10, 5, ::multiplicacao)
    println("Multiplicação: $resultadoMult")

    // 3. Usando com LAMBDA (passando a lógica diretamente entre chaves)
    // O Kotlin permite que se o último parâmetro for uma função, você coloque as chaves fora dos parênteses
    val resultadoSub = executarOperacao(10, 5) { x, y ->
        x - y
    }
    println("Subtração (via Lambda): $resultadoSub")
}

// Funções de apoio
fun soma(a: Int, b: Int): Int = a + b
fun multiplicacao(a: Int, b: Int): Int = a * b
fun subtracao(a: Int, b: Int): Int = a - b