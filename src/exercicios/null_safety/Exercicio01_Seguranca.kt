package exercicios.null_safety

/**
 * EXERCÍCIO 01: O MESTRE DOS NULOS
 * 
 * Objetivo:
 * 1. Crie uma variável 'nome' que aceite nulo.
 * 2. Tente imprimir o tamanho (length) dessa variável de 3 formas:
 *    a) Usando o operador de chamada segura (?.).
 *    b) Usando o operador Elvis (?:) para retornar 0 caso seja nulo.
 *    c) Usando a função '.let' para imprimir apenas se não for nulo.
 * 3. Crie uma variável 'idadeString' com valor nulo. Converta para Int usando 'toIntOrNull()' 
 *    e use o Elvis para garantir que o resultado final seja 18 se a conversão falhar.
 */

fun main() {
    // ESCREVA SEU CÓDIGO AQUI
    val nome: String? = null
    val idadeString: String? = null

    println(nome?.length)
    println(nome ?: 0)
    println(nome.let { it?.length })
    println(idadeString?.toIntOrNull() ?: 18)
}
