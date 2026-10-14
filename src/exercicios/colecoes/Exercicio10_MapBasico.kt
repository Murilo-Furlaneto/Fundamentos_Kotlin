package exercicios.colecoes

/**
 * EXERCÍCIO 10: OPERAÇÕES BÁSICAS COM MAP (CHAVE-VALOR)
 * 
 * Objetivo:
 * 1. Crie um Map IMUTÁVEL chamado 'dicionario' associando palavras em inglês (chaves)
 *    para o português (valores) usando a sintaxe 'chave to valor':
 *    "apple" to "maçã", "car" to "carro", "house" to "casa", "book" to "livro"
 * 
 * 2. Faça leituras no 'dicionario':
 *    - Imprima a tradução de "car" usando 'dicionario["car"]'.
 *    - Imprima o resultado de buscar uma palavra inexistente "phone" usando 'dicionario["phone"]' (deve retornar null).
 *    - Use '.getOrDefault("phone", "Tradução não encontrada")' para exibir uma mensagem padrão quando a chave não existir.
 * 
 * 3. Crie um Map MUTÁVEL (mutableMapOf) chamado 'estoqueProdutos' do tipo <String, Double>:
 *    - Adicione 3 produtos com seus preços: "Notebook" to 3500.0, "Mouse" to 80.0, "Teclado" to 150.0.
 *    - Atualize o preço do "Mouse" para 95.0 usando 'estoqueProdutos["Mouse"] = 95.0'.
 *    - Remova o "Teclado" do mapa usando '.remove("Teclado")'.
 *    - Imprima todas as chaves do estoque usando '.keys' e todos os valores usando '.values'.
 */

fun main() {
    // ESCREVA SEU CÓDIGO AQUI
    val dicionario = mapOf(
        "apple" to "maçã",
        "car" to "carro",
        "house" to "casa",
        "book" to "livro"

    )

    println(dicionario["car"])
    println(dicionario["phone"])
    println(dicionario.getOrDefault("phone", "Tradução não encontrada"))

    val estoqueProdutos = mutableMapOf<String, Double>(
        "Notebook" to 3500.0,
        "Mouse" to 80.0,
        "Teclado" to 150.0
    )

    estoqueProdutos["Mouse"] = 95.0
    estoqueProdutos.remove("Teclado")

    println(estoqueProdutos.keys)
    println(estoqueProdutos.values)

    estoqueProdutos.forEach { keys, values ->
        println("$keys: $values")
    }
}
