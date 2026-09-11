package exercicios.coroutines
import kotlinx.coroutines.*
import kotlin.time.Duration.Companion.seconds

/**
 * EXERCÍCIO 01: O LANÇADOR DE TAREFAS
 * 
 * Objetivo: 
 * 1. Crie uma função main usando runBlocking.
 * 2. Dentro do runBlocking, lance duas coroutines usando 'launch'.
 * 3. A primeira coroutine deve imprimir "Tarefa A iniciada", esperar 2 segundos e imprimir "Tarefa A concluída".
 * 4. A segunda coroutine deve imprimir "Tarefa B iniciada", esperar 1 segundo e imprimir "Tarefa B concluída".
 * 5. Observe a ordem das mensagens no console para entender o paralelismo.
 */

fun main() {
    // ESCREVA SEU CÓDIGO AQUI
runBlocking {
    println("Iniciando exercício...")
    launch {
        tarefaA()
    }
    launch {
        tarefaB()
    }

    println("Fim do exercício")

}

}

suspend fun tarefaA() {
    println("Tarefa A iniciada")
    delay(2.seconds)
    println("Tarefa A concluída")
}

suspend fun tarefaB(){
    println("Tarefa B iniciada")
    delay(1.seconds)
    println("Tarefa B concluída")
}