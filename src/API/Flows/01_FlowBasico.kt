package API.Flows

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlin.time.Duration.Companion.milliseconds

/**
 * --- O QUE É UM FLOW? ---
 * Um Flow é um fluxo de dados assíncrono que emite múltiplos valores sequencialmente.
 * Pense nele como uma "Lista Assíncrona" ou um "Stream".
 * 
 * Características:
 * 1. Cold (Frio): O código dentro do flow só começa a rodar quando alguém chama 'collect'.
 * 2. Assíncrono: Pode emitir valores sem travar a thread principal.
 * 3. Sequencial: Os valores são processados um após o outro.
 */

fun main() = runBlocking {
    println("--- Iniciando Flow Básico ---")

    // Criando um flow usando o builder flow { ... }
    val numeroFlow = flow {
        for (i in 1..3) {
            delay(500.milliseconds) // Simula um processamento demorado
            println("Emitindo: $i")
            emit(i) // Envia o valor para quem está escutando
        }
    }

    println("O Flow foi criado, mas nada aconteceu ainda...")

    // collect: É um operador terminal que "ativa" o flow
    numeroFlow.collect { valor ->
        println("Recebido no collect: $valor")
    }

    println("--- Flow Finalizado ---")
}
