package exercicios.dataclass

/**
 * EXERCÍCIO 01: MÉTODOS AUTOMÁTICOS, IGUALDADE E MÉTODO COPY()
 * 
 * Objetivo:
 * 1. Crie uma 'data class Usuario' com as propriedades:
 *    - 'id' (Int)
 *    - 'nome' (String)
 *    - 'email' (String)
 *    - 'ativo' (Boolean, com valor padrão 'true')
 * 
 * 2. No 'main':
 *    - Crie 'usuario1' com id 1, nome "Carlos", email "carlos@email.com".
 *    - Imprima 'usuario1' diretamente no println (observe a formatação automática do .toString()).
 *    - Crie 'usuario2' com EXATAMENTE os mesmos dados de 'usuario1'.
 *    - Verifique se 'usuario1 == usuario2' é verdadeiro e imprima o resultado booleano.
 *    - Crie 'usuario3' a partir de 'usuario1' usando o método .copy(), alterando apenas o email para "carlos.novo@email.com".
 *    - Imprima 'usuario3' e verifique se 'usuario1 == usuario3' é falso.
 */

fun main() {
    // ESCREVA SEU CÓDIGO AQUI
    val usuario1 = Usuario(1, "Carlos", "carlos@email.com")
    println(usuario1)

    val usuario2 = Usuario(1, "Carlos", "carlos@email.com")

    println(usuario1 == usuario2)

    val usuario3 = usuario1.copy(email = "carlos.novo@email.com")
    println(usuario3)
    println(usuario1 == usuario3)
}

data class Usuario(val id: Int, val nome: String, val email: String, val ativo: Boolean = true)