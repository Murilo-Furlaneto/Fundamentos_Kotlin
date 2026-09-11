package exercicios.flow

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlin.time.Duration.Companion.milliseconds

/**
 * EXERCÍCIO 01: O CONTADOR PROGRESSIVO
 * 
 * Objetivo:
 * 1. Crie uma função que retorna um Flow de inteiros de 1 a 10.
 * 2. O Flow deve emitir cada número com um intervalo de 300ms.
 * 3. No main, colete (collect) esse flow e imprima apenas os números ímpares.
 */

fun main() = runBlocking {
    // ESCREVA SEU CÓDIGO AQUI
    fun main() = runBlocking {
        contadorProgresso()
            .filter { it % 2 != 0 }
            .collect { println(it) }
    }
}

fun contadorProgresso(): Flow<Int> {
    return flow {
        for (i in 1..10){
            delay(300.milliseconds)
            emit(i)
        }
    }
}