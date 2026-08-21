package API.Coroutines

import kotlinx.coroutines.*

import kotlin.time.Duration.Companion.milliseconds

/**
 * --- O QUE SÃO COROUTINES? ---
 * Coroutines são "threads leves". Elas permitem escrever código assíncrono (que não trava a execução)
 * de forma sequencial e fácil de ler.
 *
 * Conceitos Básicos:
 * 1. Suspend Functions: Funções que podem ser pausadas e retomadas depois.
 * 2. Coroutine Builders: Funções que iniciam uma coroutine (launch, async, runBlocking).
 * 3. Coroutine Scope: Define o "tempo de vida" da coroutine.
 */

fun main() = runBlocking { // runBlocking: Bloqueia a thread atual até que tudo aqui dentro termine.
    println("1. [runBlocking] Iniciou")

    // launch: Inicia uma coroutine que "dispara e esquece". Não retorna resultado.
    val job = launch {
        fazerTarefaDemorada("Cozinhar")
    }

    // async: Inicia uma coroutine que RETORNA um valor (Deferred).
    val resultadoAssincrono = async {
        buscarDadosDoBanco()
    }

    println("2. Fazendo outras coisas enquanto as coroutines trabalham...")

    // await(): Espera o resultado do async.
    val dados = resultadoAssincrono.await()
    println("3. Dados recebidos: $dados")

    // join(): Espera o launch terminar (opcional, runBlocking já espera por padrão).
    job.join()

    println("4. [runBlocking] Finalizou")
}

suspend fun fazerTarefaDemorada(nome: String) {
    println("   -> Iniciando $nome...")
    delay(1000.milliseconds) // delay: Suspende a coroutine sem travar a thread.
    println("   -> $nome concluído!")
}

suspend fun buscarDadosDoBanco(): String {
    delay(500.milliseconds)
    return "Usuário: João Silva"
}
