package exercicios.colecoes

/**
 * EXERCÍCIO 01: GESTÃO DE ESTOQUE
 * 
 * Objetivo:
 * 1. Crie uma lista de preços: listOf(10.0, 55.0, 100.0, 7.50, 200.0, 45.0).
 * 2. Use operadores de coleção para:
 *    a) Filtrar apenas os preços maiores que 50.0.
 *    b) Aplicar um desconto de 10% em todos os preços filtrados (map).
 *    c) Ordenar a lista resultante do menor para o maior.
 * 3. Imprima a lista final e também a soma total de todos os preços com desconto.
 */

fun main() {
    // ESCREVA SEU CÓDIGO AQUI

    val listaDePrecos = listOf(10.0, 55.0, 100.0, 7.50, 200.0, 45.0)

    val listaFiltrada = listaDePrecos.filter { it > 50.0 }
    val listaDescontada = listaFiltrada.map { it * 0.10 }
    val listaOrdenada = listaDescontada.sorted()
    println(listaOrdenada)
    println("Soma da lista com desconto: ${listaDescontada.sum()}")
}
