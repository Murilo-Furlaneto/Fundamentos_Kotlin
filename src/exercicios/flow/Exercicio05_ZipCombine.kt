package exercicios.flow

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

/**
 * EXERCÍCIO 05: COMBINANDO FLUXOS
 * 
 * Objetivo:
 * 1. Crie o 'flowNomes' com ("João", "Maria", "Pedro").
 * 2. Crie o 'flowSobrenomes' com ("Silva", "Oliveira", "Santos").
 * 3. Use o operador 'zip' para combinar os dois e emitir o nome completo.
 * 4. Resultado esperado: "João Silva", "Maria Oliveira", etc.
 */

fun main() = runBlocking {
    // ESCREVA SEU CÓDIGO AQUI
    val flowNomes = flowOf("João", "Maria", "Pedro")
    val flowSobrenomes = flowOf("Silva", "Oliveira", "Santos")

    flowNomes.zip(flowSobrenomes) { nome, sobrenome ->
        "$nome $sobrenome"
    }.collect { nomeCompleto ->
        println(nomeCompleto)
    }
}
