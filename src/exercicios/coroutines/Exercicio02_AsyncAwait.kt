package exercicios.coroutines

import kotlinx.coroutines.*
import kotlin.time.Duration.Companion.seconds

/**
 * EXERCÍCIO 02: SOMA ASSÍNCRONA
 * 
 * Objetivo:
 * 1. Crie duas funções suspensas: 'buscarPrecoProdutoA' (retorna 50) e 'buscarPrecoProdutoB' (retorna 75).
 * 2. Ambas as funções devem simular um atraso de 1.5 segundos.
 * 3. No main, dispare ambas simultaneamente usando 'async'.
 * 4. Aguarde o resultado de ambos usando 'await'.
 * 5. Some os valores e imprima: "O valor total da compra é: X".
 * 
 * Desafio: O tempo total de execução não deve passar de 2 segundos!
 */

fun main() = runBlocking {
    // ESCREVA SEU CÓDIGO AQUI
    val precoA = async { buscarPrecoProdutoA() }
    val precoB = async { buscarPrecoProdutoB() }
    val soma = somaDosProdutos(precoA.await(), precoB.await())
    println("O valor total da compra é: $soma")
}

suspend fun buscarPrecoProdutoA(): Int {
    delay(1.5.seconds)
    return 50
}
suspend fun buscarPrecoProdutoB() : Int {
    delay(1.5.seconds)
    return 75;
}

fun somaDosProdutos(precoA: Int, precoB: Int): Int {
    return precoA + precoB
}
