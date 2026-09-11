package exercicios.flow

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlin.time.Duration.Companion.seconds

/**
 * EXERCÍCIO 02: TRANSFORMANDO NOMES
 * 
 * Objetivo:
 * 1. Crie uma lista de nomes: listOf("ana", "pedro", "maria", "joao").
 * 2. Transforme essa lista em um Flow.
 * 3. Use operadores para:
 *    a) Filtrar nomes que tenham mais de 3 letras.
 *    b) Deixar a primeira letra em maiúscula (capitalize/uppercase).
 *    c) Adicionar o prefixo "Usuário: ".
 * 4. Imprima o resultado final no collect.
 */

fun main() = runBlocking {
    // ESCREVA SEU CÓDIGO AQUI
    val nomes = listOf("ana", "pedro", "maria", "joao")

    nomes.asFlow()
        .filter { it.length > 3 }
        .map { it.replaceFirstChar { char -> char.uppercase() } }
        .map { "Usuário: $it" }
        .collect { println(it) }
}

