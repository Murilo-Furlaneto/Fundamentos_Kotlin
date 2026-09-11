package exercicios.coroutines

import kotlinx.coroutines.*
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.seconds

/**
 * EXERCÍCIO 05: CANCELAMENTO COOPERATIVO
 * 
 * Objetivo:
 * 1. Lance uma coroutine (job) que rode um loop de 1 a 100.
 * 2. Em cada repetição, imprima o número e espere 100ms.
 * 3. No main, espere 500ms e cancele a coroutine (job.cancel()).
 * 4. Verifique se a coroutine realmente para de imprimir após o cancelamento.
 * 
 * Dica: O 'delay' já é cooperativo, então ele deve parar sozinho. 
 * Se você usasse um loop infinito sem delay, precisaria verificar 'isActive'.
 */

fun main() = runBlocking {
    // ESCREVA SEU CÓDIGO AQUI

    val coroutineJob1 = launch {
        contador()
    }
    delay(500.milliseconds)
    coroutineJob1.cancel()
    println("Fim do exercício")
}

suspend fun contador() {
    for (i in 1..100){
        println(i)
        delay(100.milliseconds)
    }
}