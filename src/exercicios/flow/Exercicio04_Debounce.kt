package exercicios.flow

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlin.time.Duration.Companion.milliseconds

/**
 * EXERCÍCIO 04: SIMULADOR DE BUSCA (DEBOUNCE)
 * 
 * Cenário: O usuário está digitando em uma barra de pesquisa. Você não quer fazer 
 * uma busca no banco a cada letra digitada, mas apenas quando ele parar de digitar por 500ms.
 * 
 * Objetivo:
 * 1. Crie um flow que emite as letras: "K", "Ko", "Kot", (pausa 600ms), "Kotl", "Kotlin".
 * 2. Use o operador 'debounce(500.milliseconds)'.
 * 3. Colete o resultado e veja quais termos de busca realmente seriam enviados ao servidor.
 */

fun main() = runBlocking {
    // ESCREVA SEU CÓDIGO AQUI
    val flowDigitação = flow {
        emit("K")
        emit("Ko")
        emit("Kot")
        delay(600.milliseconds)
        emit("Kotl")
        emit("Kotlin")
    }
        .debounce(500.milliseconds)
        .collect { println(it) }

}
