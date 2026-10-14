package exercicios.colecoes

/**
 * EXERCÍCIO 07: FILTROS COM MÚLTIPLAS CONDIÇÕES E FILTERNOT
 * 
 * Objetivo:
 * 1. Crie uma 'data class Livro':
 *    - 'titulo' (String)
 *    - 'autor' (String)
 *    - 'anoPublicacao' (Int)
 *    - 'paginas' (Int)
 *    - 'disponivel' (Boolean)
 * 
 * 2. No 'main', crie uma lista com 6 livros variados (diferentes anos, números de páginas e disponibilidades).
 * 
 * 3. Aplique os seguintes filtros:
 *    - Encontre todos os livros **disponíveis** que tenham **mais de 200 páginas** (use 'filter' com '&&').
 *    - Encontre todos os livros publicados **após o ano 2000**.
 *    - Use o **.filterNot { ... }** para obter uma lista dos livros que **NÃO estão disponíveis** (emprestados).
 * 
 * 4. Imprima o resultado de cada filtro formatado.
 */

fun main() {
    // ESCREVA SEU CÓDIGO AQUI
    val livros = listOf(
        Livro("Livro 1", "Autor 1",
            2000, 300, true),
        Livro("Livro 2", "Autor 2",
            2005, 250, true),
        Livro("Livro 3", "Autor 3",2007, 300, false),
        Livro("Livro 4", "Autor 4",
            2010, 400, true),
        Livro("Livro 5", "Autor 5",
            2015, 500, false),
        Livro("Livro 6", "Autor 6",
            2020, 600, true)
    )

    val livrosDiponiveisCom200Paginas = livros.filter {
        it.disponivel && it.paginas > 200
    }

    println("Livros com mais de 200 paginas: $livrosDiponiveisCom200Paginas")

    val livrosPublicadosDepoisDe2000 = livros.filter {
        it.anoPublicacao > 2000
    }

    println("Livros publicados após o ano 2000: $livrosPublicadosDepoisDe2000")

    val livrosNaoDisponiveis = livros.filterNot {
        it.disponivel
    }

    println("Livros não disponíveis: $livrosNaoDisponiveis")
}

data class Livro(val titulo: String, val autor: String, val anoPublicacao: Int, val paginas: Int, val disponivel: Boolean)