package API.Coroutines

import kotlinx.coroutines.*
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.seconds

/**
 * --- TRATAMENTO DE ERROS (AVANÇADO) ---
 * Exceções em coroutines se propagam para cima.
 * SupervisorJob: Permite que um erro em um filho não cancele os outros irmãos ou o pai.
 */

fun main() = runBlocking {
    
    // 1. CoroutineExceptionHandler: Captura exceções não tratadas.
    val handler = CoroutineExceptionHandler { _, exception ->
        println("ERRO CAPTURADO: ${exception.message}")
    }

    println("--- Exemplo com SupervisorScope ---")
    supervisorScope { // Se um filho falhar, os outros continuam
        val job1 = launch(handler) {
            println("Filho 1 vai falhar agora...")
            throw Exception("Falha crítica no Filho 1")
        }

        val job2 = launch {
            println("Filho 2 continua trabalhando normalmente...")
            delay(500.milliseconds)
            println("Filho 2 terminou com sucesso!")
        }
        
        joinAll(job1, job2)
    }

    println("\n--- Exemplo com Timeout ---")
    try {
        withTimeout(2.seconds) {
            println("Iniciando tarefa que demora demais...")
            delay(5.seconds)
            println("Isso nunca será impresso")
        }
    } catch (e: TimeoutCancellationException) {
        println("Tarefa cancelada por estourar o tempo (Timeout)!")
    }
}
