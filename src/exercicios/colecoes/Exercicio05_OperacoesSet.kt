package exercicios.colecoes

/**
 * EXERCÍCIO 05: OPERAÇÕES DE CONJUNTOS (UNION, INTERSECT, SUBTRACT)
 * 
 * Objetivo:
 * 1. Crie dois conjuntos de disciplinas cursadas por dois alunos:
 *    val disciplinasAlunoA = setOf("Matemática", "Física", "Química", "História")
 *    val disciplinasAlunoB = setOf("Física", "Biologia", "História", "Geografia")
 * 
 * 2. Realize as seguintes operações entre os conjuntos:
 *    - União (.union ou +): Crie um conjunto com TODAS as disciplinas cursadas por pelo menos um aluno (sem duplicatas).
 *    - Intersecção (.intersect): Crie um conjunto contendo apenas as disciplinas que AMBOS os alunos cursam em comum.
 *    - Subtração (.subtract ou -): Crie um conjunto com as disciplinas que o 'Aluno A' cursa, mas o 'Aluno B' NÃO cursa.
 * 
 * 3. Imprima o resultado de cada uma das 3 operações com mensagens explicativas.
 */

fun main() {
    // ESCREVA SEU CÓDIGO AQUI
    val disciplinasAlunoA = setOf("Matemática", "Física", "Química", "História")
    val disciplinasAlunoB = setOf("Física", "Biologia", "História", "Geografia")

    val uniao = disciplinasAlunoA.union(disciplinasAlunoB)
    println(uniao)

    val intersecao = disciplinasAlunoA.intersect(disciplinasAlunoB)
    println(intersecao)

    val subtracao = disciplinasAlunoA.subtract(disciplinasAlunoB)
    println(subtracao)
}
