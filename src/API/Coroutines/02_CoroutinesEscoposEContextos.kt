package API.Coroutines

import kotlinx.coroutines.*
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.seconds

/**
 * --- DISPATCHERS E CONTEXTOS ---
 * O Dispatcher determina em qual thread a coroutine será executada.
 *
 * 1. Dispatchers.Default: Para tarefas pesadas de CPU (cálculos, processamento).
 * 2. Dispatchers.IO: Para tarefas de rede, banco de dados ou arquivos.
 * 3. Dispatchers.Main: Para interagir com a interface do usuário (Android/UI).
 * 4. Dispatchers.Unconfined: Não recomendado para uso geral.
 */

fun main() = runBlocking {
    println("Main iniciada na thread: ${Thread.currentThread().name}")

    // Mudando o contexto com withContext
    val resultado = withContext(Dispatchers.Default) {
        println("Calculando algo pesado na thread: ${Thread.currentThread().name}")
        (1..1000).sum()
    }
    println("Resultado do cálculo: $resultado")

    // Hierarquia (Structured Concurrency)
    // Se o pai for cancelado, todos os filhos também são.
    val paiJob = launch {
        launch {
            try {
                println("Filho 1 trabalhando...")
                delay(10.seconds)
            } finally {
                println("Filho 1 foi limpo (cancelado)")
            }
        }

        launch {
            println("Filho 2 trabalhando...")
            delay(1.seconds)
            println("Filho 2 terminou")
        }
    }

    delay(500.milliseconds)
    println("Cancelando o pai...")
    paiJob.cancelAndJoin() // Cancela o pai e espera a limpeza dos filhos.
    
    println("Fim da execução")
}
