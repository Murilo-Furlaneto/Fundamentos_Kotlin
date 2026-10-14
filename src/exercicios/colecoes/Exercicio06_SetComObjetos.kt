package exercicios.colecoes

/**
 * EXERCÍCIO 06: SET COM OBJETOS PERSONALIZADOS (DATA CLASS E EQUALS/HASHCODE)
 * 
 * Objetivo:
 * 1. Crie uma 'data class Usuario(val id: Int, val email: String)'.
 * 
 * 2. No 'main', crie um 'mutableSetOf<Usuario>()' chamado 'usuariosCadastrados'.
 * 
 * 3. Tente adicionar os seguintes usuários ao Set:
 *    - Usuario(1, "ana@gmail.com")
 *    - Usuario(2, "carlos@hotmail.com")
 *    - Usuario(1, "ana@gmail.com") // Exatamente igual ao primeiro
 *    - Usuario(3, "pedro@gmail.com")
 * 
 * 4. Imprima a quantidade de usuários no Set (deve ser 3, pois o objeto repetido foi ignorado automaticamente).
 * 
 * 5. Use a função '.filter { ... }' no Set de usuários para encontrar apenas os usuários que possuem
 *    email com o domínio "@gmail.com" e imprima essa lista.
 */

fun main() {
    // ESCREVA SEU CÓDIGO AQUI
    val usuariosCadastrados = mutableSetOf<Usuario>()
    usuariosCadastrados.add(Usuario(1, "ana@gmail.com"))
    usuariosCadastrados.add(Usuario(2, "carlos@hotmail.com"))
    usuariosCadastrados.add(Usuario(1, "ana@gmail.com"))
    usuariosCadastrados.add(Usuario(3, "pedro@gmail.com"))

    println("Tamanho da lista: ${usuariosCadastrados.toSet().size}")
    println(usuariosCadastrados.filter { it.email.contains("@gmail.com") })
}

data class Usuario(val id: Int, val email: String)