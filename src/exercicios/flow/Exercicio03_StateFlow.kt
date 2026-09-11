package exercicios.flow

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.seconds

/**
 * EXERCÍCIO 03: SIMULADOR DE DOWNLOAD
 * 
 * Objetivo:
 * 1. Crie um MutableStateFlow chamado 'progresso' que inicia em 0.
 * 2. Lance uma coroutine que incremente esse valor de 10 em 10 a cada 500ms, até chegar em 100.
 * 3. No main, colete o 'progresso' e imprima: "Download: X%".
 * 4. Quando chegar em 100, imprima "Download Concluído!" e encerre a coroutine.
 */

fun main() = runBlocking {
    // 1. Criamos o Estado Inicial
    val progresso = MutableStateFlow(0)

    // 2. Lançamos a coroutine que SIMULA o download em background
    val jobDownload = launch {
        while (progresso.value < 100) {
            delay(500.milliseconds)
            progresso.value += 10 // Atualiza o estado
        }
    }

    // 3. Escutamos o progresso (como se fosse a tela do celular)
    // Usamos 'takeWhile' para parar de escutar quando chegar em 100
    progresso.takeWhile { it <= 100 }.collect { valor ->
        println("Download: $valor%")

        if (valor == 100) {
            println("Download Concluído!")
            // Como o loop do jobDownload já terminou (valor é 100),
            // a coroutine de download vai encerrar naturalmente.
        }
    }
}