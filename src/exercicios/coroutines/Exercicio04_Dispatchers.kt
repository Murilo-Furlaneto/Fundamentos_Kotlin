package exercicios.coroutines

import kotlinx.coroutines.*
import kotlin.time.Duration.Companion.seconds

/**
 * EXERCÍCIO 04: TROCA DE CONTEXTO (DISPATCHERS)
 * 
 * Objetivo:
 * 1. No main (runBlocking), imprima a thread atual.
 * 2. Crie uma função suspensa 'processarImagem' que simule um cálculo pesado.
 * 3. Dentro dessa função, use 'withContext(Dispatchers.Default)' para garantir que 
 *    o cálculo rode na thread de processamento.
 * 4. Imprima a thread de dentro do withContext para confirmar a mudança.
 * 5. Retorne uma String "Imagem Processada".
 */

fun main() = runBlocking {
    // ESCREVA SEU CÓDIGO AQUI
    println("Thread atual: ${Thread.currentThread().name}")
    val resultado = processarImagem()
    println(resultado)
}

suspend fun processarImagem(): String {
    return withContext(Dispatchers.Default) {
        println("Thread dentro do withContext: ${Thread.currentThread().name}")
        delay(2.seconds)
        "Imagem Processada"
    }
}