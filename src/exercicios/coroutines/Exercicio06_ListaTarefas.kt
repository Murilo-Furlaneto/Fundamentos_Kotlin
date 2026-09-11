package exercicios.coroutines

import kotlinx.coroutines.*
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.seconds

/**
 * EXERCÍCIO 06: MULTIPLAS TAREFAS EM PARALELO
 * 
 * Objetivo:
 * 1. Crie uma lista de nomes de arquivos: listOf("foto1.jpg", "video.mp4", "documento.pdf").
 * 2. Para CADA arquivo, lance uma coroutine usando 'async' que simule um upload (delay de 1s).
 * 3. Armazene os resultados (Deferred) em uma lista.
 * 4. Use '.awaitAll()' na lista para esperar todos terminarem.
 * 5. Imprima "Todos os uploads concluídos: [lista de nomes]".
 */

fun main() = runBlocking {
    // ESCREVA SEU CÓDIGO AQUI

    val listaDeArquivos = listOf("foto1.jpg", "video.mp4", "documento.pdf")
    val listaDeUploads = mutableListOf<Deferred<String>>()

    for (arquivo in listaDeArquivos){
        val upload = async {
            delay(1.seconds)
            "Upload concluído: $arquivo"
        }
        listaDeUploads.add(upload)
    }
    val resultados =listaDeUploads.awaitAll()
    println("Todos os uploads concluídos: $resultados")
}
