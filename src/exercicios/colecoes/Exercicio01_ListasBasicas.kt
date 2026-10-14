package exercicios.colecoes

/**
 * EXERCÍCIO 01: OPERAÇÕES BÁSICAS COM LISTAS E MUTABILIDADE
 * 
 * Objetivo:
 * 1. Crie uma lista IMUTÁVEL (listOf) chamada 'frutas' com as frutas:
 *    "Maçã", "Banana", "Laranja", "Uva", "Manga".
 * 
 * 2. Realize as seguintes verificações na lista 'frutas':
 *    - Imprima a quantidade total de frutas na lista (.size).
 *    - Verifique e imprima se a fruta "Banana" está presente na lista (.contains).
 *    - Imprima a primeira e a última fruta usando .first() e .last().
 * 
 * 3. Crie uma lista MUTÁVEL (mutableListOf) chamada 'carrinho' do tipo String inicialmente vazia.
 *    - Adicione 3 produtos individualmente usando .add().
 *    - Adicione mais 2 produtos de uma só vez usando .addAll() passando outra lista.
 *    - Remova um produto pelo nome usando .remove().
 *    - Remova um produto pelo índice usando .removeAt().
 * 
 * 4. Percorra a lista 'carrinho' e imprima cada item com o seu índice (ex: "1. Arroz", "2. Feijão").
 *    (Dica: pode usar .forEachIndexed { index, item -> ... } ou um loop for com .indices).
 */

fun main() {
    // ESCREVA SEU CÓDIGO AQUI

    val fruitas = listOf<String>("Maçã", "Laranja", "Uva", "Manga")
    println(fruitas.size)
    println(fruitas.contains("Banana"))
    println(fruitas.first())
    println(fruitas.last())

    val carrinho = mutableListOf<String>()

    carrinho.add("Arroz")
    carrinho.add("Feijão")
    carrinho.add("Farofa")

    carrinho.addAll(listOf("Carne", "Leite"))

    carrinho.remove("Carne")
    carrinho.removeAt(1)

    carrinho.forEachIndexed { index, item ->
        println("${index + 1}. $item")
    }}
