package exercicios.coroutines

import kotlinx.coroutines.*
import kotlin.time.Duration.Companion.milliseconds

/**
 * EXERCÍCIO 08: BUSCA PARALELA COM ERRO
 * 
 * Cenário: Você precisa buscar dados de dois servidores. O Servidor A funciona, 
 * mas o Servidor B está fora do ar e lança um erro.
 * 
 * Objetivo:
 * 1. Crie 'buscarServidorA' (retorna "Dados A" após 500ms).
 * 2. Crie 'buscarServidorB' (lança Exception("Erro 404") após 300ms).
 * 3. No main, use 'async' para ambos.
 * 4. Tente pegar os resultados com 'await()'.
 * 5. Use try-catch para garantir que o erro do Servidor B não quebre o programa e 
 *    você consiga pelo menos mostrar os dados do Servidor A.
 */

fun main() = runBlocking {
    supervisorScope {
        val servA = async { buscarServidorA() }
        val servB = async { buscarServidorB() }

        try {
            val dadosA = servA.await()
            println("Resultado A: $dadosA")
        } catch (e: Exception) {
            println("Erro A: ${e.message}")
        }

        try {
            val dadosB = servB.await()
            println("Resultado B: $dadosB")
        } catch (e: Exception) {
            println("Servidor B falhou como esperado: ${e.message}")
        }
    }
    println("Fim do programa - tudo correu bem!")
}
suspend fun buscarServidorA() : String {
    return "Dados A"
}

suspend fun buscarServidorB() : String {
    delay(300.milliseconds)
    throw Exception("Erro 404")
}
