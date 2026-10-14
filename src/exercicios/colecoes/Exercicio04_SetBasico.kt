package exercicios.colecoes

/**
 * EXERCÍCIO 04: UNICIDADE E CONJUNTOS BÁSICOS (SET)
 * 
 * Objetivo:
 * 1. Crie uma lista com emails duplicados:
 *    val emailsDuplicados = listOf("ana@email.com", "joao@email.com", "ana@email.com", "carlos@email.com", "joao@email.com")
 * 
 * 2. Converta a lista 'emailsDuplicados' para um Set usando '.toSet()'.
 *    - Imprima o tamanho da lista original (.size).
 *    - Imprima o tamanho do Set resultante e exiba os seus elementos (observe como as duplicatas sumiram).
 * 
 * 3. Crie um 'mutableSetOf<String>()' chamado 'convidados':
 *    - Adicione "Maria" e "Pedro".
 *    - Tente adicionar "Maria" novamente e guarde o retorno do método .add("Maria") em uma variável (Boolean).
 *      Imprima o valor retornado (deve ser 'false', indicando que o elemento já existia e não foi adicionado).
 *    - Remova "Pedro" usando .remove("Pedro").
 *    - Verifique se "Maria" está no conjunto usando .contains("Maria") ou 'in'.
 */

fun main() {
    // ESCREVA SEU CÓDIGO AQUI

    val emailduplicado = listOf("ana@email.com", "joao@email.com", "ana@email.com", "carlos@email.com", "joao@email.com")
    println(emailduplicado.size)
    println(emailduplicado.toSet().size)

    val convidados = mutableSetOf<String>()

    convidados.add("Maria")
    convidados.add("Pedro")

    val addMaria = convidados.add("Maria")
    println(addMaria)

    convidados.remove("Pedro")

    println(convidados.contains("Maria"))
    println("Maria" in convidados)
}
