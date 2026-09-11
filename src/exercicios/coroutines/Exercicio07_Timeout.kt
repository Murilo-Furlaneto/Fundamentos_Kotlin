package exercicios.coroutines

import kotlinx.coroutines.*
import kotlin.time.Duration.Companion.seconds

/**
 * EXERCÍCIO 07: TIMEOUT COM FALLBACK
 * 
 * Cenário: Você está tentando baixar a foto de perfil de um usuário. Se demorar mais de 2 segundos,
 * você deve usar uma "imagem_padrao.png" em vez de deixar o usuário esperando.
 * 
 * Objetivo:
 * 1. Crie uma função suspensa 'baixarFotoPerfil' que demore 3 segundos e retorne "foto_linda.jpg".
 * 2. No main, use 'withTimeoutOrNull' para chamar essa função com um limite de 2 segundos.
 * 3. Se o resultado for nulo (estourou o tempo), imprima "Usando: imagem_padrao.png".
 * 4. Se o resultado for válido, imprima "Usando: $resultado".
 */

fun main() = runBlocking {
    // ESCREVA SEU CÓDIGO AQUI
    val resultado = withTimeoutOrNull(2.seconds) {
        baixarFotoPerfil()
    }
    if (resultado == null) println("Usando: imagem_padrao.png")
    else println("Usando: $resultado")
}

suspend fun baixarFotoPerfil(): String {
    delay(3.seconds)
    return "foto_linda.jpg"
}
