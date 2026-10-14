package exercicios.colecoes

/**
 * EXERCÍCIO 08: VARIANTES PODEROSAS DO FILTER
 * (filterNotNull, filterIsInstance e filterIndexed)
 * 
 * Objetivo:
 * 1. **filterNotNull**:
 *    Dada a lista com valores nulos:
 *    val listaComNulos = listOf("Kotlin", null, "Java", null, "Python", "C#")
 *    Use '.filterNotNull()' para remover todos os nulos e imprima a lista resultante.
 * 
 * 2. **filterIsInstance**:
 *    Dada a lista heterogênea:
 *    val elementosMisto = listOf("Texto", 10, 3.14, "Outro Texto", 42, true, 100)
 *    Use '.filterIsInstance<Int>()' para extrair apenas os números inteiros (Int) e imprima a lista.
 * 
 * 3. **filterIndexed**:
 *    Dada a lista de nomes:
 *    val nomes = listOf("Ana", "Bruno", "Carlos", "Daniela", "Eduardo", "Fernanda")
 *    Use '.filterIndexed { index, _ -> index % 2 == 0 }' para filtrar apenas os nomes que estão em posições PARES da lista (índices 0, 2, 4...).
 *    Imprima os nomes filtrados.
 */

fun main() {
    // ESCREVA SEU CÓDIGO AQUI
    val listaComNulos = listOf("Kotlin", null, "Java", null, "Python", "C#")
    println("Lista sem valores nulos: ${listaComNulos.filterNotNull()}")

    val elementosMisto = listOf("Texto", 10, 3.14, "Outro Texto", 42, true, 100)
    println("Números inteiros: ${elementosMisto.filterIsInstance<Int>()}")

    val nomes = listOf("Ana", "Bruno", "Carlos", "Daniela", "Eduardo", "Fernanda")
    println("Nomes pares: ${nomes.filterIndexed { index, _ -> index % 2 == 0 }}")
}
