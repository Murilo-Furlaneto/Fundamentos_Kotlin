package API.Flows

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlin.time.Duration.Companion.milliseconds

/**
 * --- OPERADORES DE FLOW ---
 * Podemos transformar os dados antes que eles cheguem ao collect, 
 * assim como fazemos com listas (map, filter).
 * 
 * flowOn: Altera o contexto (thread) apenas dos operadores ACIMA dele.
 */

fun main() = runBlocking {
    
    val flowOrigem = (1..5).asFlow() // Cria um flow a partir de um range

    println("--- Usando Operadores ---")

    flowOrigem
        .filter { it % 2 == 0 } // Deixa passar apenas números pares
        .map { "Número par: $it" } // Transforma o Int em String
        .collect { println(it) }

    println("\n--- Exemplo com flowOn (Troca de Thread) ---")

    flow {
        emit("Iniciando busca no banco...")
        println("Thread de emissão: ${Thread.currentThread().name}")
        delay(500.milliseconds)
        emit("Dados recuperados!")
    }
    .flowOn(Dispatchers.IO) // A emissão acontece na thread de IO
    .collect { valor ->
        // O collect acontece na thread que chamou (neste caso, Main/runBlocking)
        println("Recebido: $valor na thread: ${Thread.currentThread().name}")
    }
}
