package exercicios.colecoes


/**
 * EXERCÍCIO 09: DESAFIO PRÁTICO DE E-COMMERCE (SISTEMA DE FILTROS)
 * 
 * Objetivo:
 * 1. Crie uma 'data class Produto':
 *    - 'id' (Int)
 *    - 'nome' (String)
 *    - 'categoria' (String) // ex: "Eletrônicos", "Roupas", "Livros"
 *    - 'preco' (Double)
 *    - 'avaliacao' (Double) // ex: 4.5
 *    - 'emEstoque' (Boolean)
 * 
 * 2. Crie uma função fora do main chamada 'buscarProdutos':
 *    fun buscarProdutos(
 *        produtos: List<Produto>,
 *        categoria: String? = null,
 *        precoMaximo: Double? = null,
 *        apenasEmEstoque: Boolean = false,
 *        avaliacaoMinima: Double? = null
 *    ): List<Produto>
 * 
 * 3. Dentro da função 'buscarProdutos', encadeie ou aplique filtros na lista de produtos:
 *    - Se 'categoria' não for nula, filtre apenas pela categoria.
 *    - Se 'precoMaximo' não for nulo, filtre por produtos com preço <= precoMaximo.
 *    - Se 'apenasEmEstoque' for true, filtre apenas por produtos com emEstoque == true.
 *    - Se 'avaliacaoMinima' não for nula, filtre por produtos com avaliação >= avaliacaoMinima.
 * 
 * 4. No 'main':
 *    - Crie uma lista com 6 produtos diversos.
 *    - Faça diferentes chamadas da função 'buscarProdutos' testando combinações de filtros (ex: apenas "Eletrônicos" em estoque até R$ 2000,0).
 */

fun main() {
    // ESCREVA SEU CÓDIGO AQUI
    val produtos = listOf(
        Produto(1, "Notebook", "Eletrônicos", 3000.0, 4.5, true),
        Produto(2, "Camiseta", "Roupas", 50.0, 4.0, true),
        Produto(3, "Livro", "Livros", 30.0, 4.8, true),
        Produto(4, "Smartphone", "Eletrônicos", 2000.0, 4.2, false),
        Produto(5, "Calça", "Roupas", 80.0, 4.3, true),
        Produto(6, "Revista", "Livros", 10.0, 4.6, true),
    )

    println(buscarProdutos(produtos, apenasEmEstoque = true))
    println(buscarProdutos(produtos, precoMaximo = 2000.0))
    println(buscarProdutos(produtos, categoria = "Eletrônicos", precoMaximo = 2000.0))
    println(buscarProdutos(produtos, avaliacaoMinima = 4.0))
    println(buscarProdutos(produtos, categoria = "Eletrônicos", apenasEmEstoque = true))
    println(buscarProdutos(produtos, precoMaximo = 2000.0, apenasEmEstoque = true))
    println(buscarProdutos(produtos, avaliacaoMinima = 4.0, apenasEmEstoque = true))
    println(buscarProdutos(produtos, categoria = "Eletrônicos", precoMaximo = 2000.0, apenasEmEstoque = true))
    println(buscarProdutos(produtos, categoria = "Eletrônicos", precoMaximo = 2000.0, avaliacaoMinima = 4.0))
    println(buscarProdutos(produtos, categoria = "Eletrônicos", precoMaximo = 2000.0, avaliacaoMinima = 4.0, apenasEmEstoque = true))
}

data class Produto(val id: Int, val nome: String, val categoria: String, val preco: Double, val avaliacao: Double, val emEstoque: Boolean)

fun buscarProdutos(
    produtos: List<Produto>,
    categoria: String? = null,
    precoMaximo: Double? = null,
    apenasEmEstoque: Boolean = false,
    avaliacaoMinima: Double? = null
): List<Produto> {
    var resultado = produtos

    if (categoria != null) {
        resultado = resultado.filter { it.categoria == categoria }
    }
    if (precoMaximo != null) {
        resultado = resultado.filter { it.preco <= precoMaximo }
    }
    if (apenasEmEstoque) {
        resultado = resultado.filter { it.emEstoque }
    }
    if (avaliacaoMinima != null) {
        resultado = resultado.filter { it.avaliacao >= avaliacaoMinima }
    }

    return resultado
}