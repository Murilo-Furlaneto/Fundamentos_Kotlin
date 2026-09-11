package exercicios.coroutines

import kotlinx.coroutines.*
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.seconds

/**
 * EXERCÍCIO 03: PROTEÇÃO CONTRA FALHAS
 * 
 * Objetivo:
 * 1. Crie um 'supervisorScope'.
 * 2. Dentro dele, lance duas coroutines.
 * 3. A Coroutine 1 deve lançar uma Exception após 500ms.
 * 4. A Coroutine 2 deve imprimir "Estou viva!" após 1 segundo.
 * 5. Verifique se a falha da Coroutine 1 NÃO cancela a Coroutine 2.
 * 
 * Dica: Use um CoroutineExceptionHandler para não travar o programa com a exceção da Coroutine 1.
 */

fun main() = runBlocking {
    // 1. Criamos um Handler para capturar a exceção e não deixar o app fechar
    val handler = CoroutineExceptionHandler { _, exception ->
        println("ERRO TRATADO: ${exception.message}")
    }

    println("Iniciando supervisão...")

    supervisorScope {
        // Coroutine 1: Vai falhar
        launch(handler) {
            delay(500L) // 500ms (ou 0.5.seconds)
            throw Exception("Falha na Coroutine 1")
        }

        // Coroutine 2: Deve continuar viva
        launch {
            delay(1.seconds)
            println("Estou viva! (Coroutine 2 não foi afetada pela falha da 1)")
        }
    }

    println("Fim do exercício")
}
