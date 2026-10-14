package exercicios.colecoes

/**
 * EXERCÍCIO 12: CONTAGEM DE FREQUÊNCIA DE ELEMENTOS COM MAP
 * 
 * Objetivo:
 * 1. Dada a seguinte lista de linguagens mencionadas em uma pesquisa:
 *    val linguagens = listOf("kotlin", "java", "kotlin", "python", "kotlin", "java", "c#", "python", "kotlin")
 * 
 * 2. Crie um 'mutableMapOf<String, Int>()' chamado 'frequencia' para contar quantas vezes cada linguagem aparece.
 * 
 * 3. Percorra a lista 'linguagens' com um loop:
 *    - Para cada palavra, incremente a contagem no Map 'frequencia'.
 *      (Dica: você pode usar 'frequencia[linguagem] = (frequencia[linguagem] ?: 0) + 1').
 * 
 * 4. Imprima o Map 'frequencia' completo com os totais de cada linguagem.
 * 
 * 5. Encontre e imprima a linguagem mais votada (com maior contagem) usando o método '.maxByOrNull { it.value }'.
 */

fun main() {
    // ESCREVA SEU CÓDIGO AQUI

      val linguagens = listOf("kotlin", "java", "kotlin", "python", "kotlin", "java", "c#", "python", "kotlin")

    val frequencia = mutableMapOf<String, Int>()

    for (linguagem in linguagens) {
        frequencia[linguagem] = (frequencia[linguagem] ?: 0) + 1
    }
    println(frequencia)

    val linguagemMaisVotada = frequencia.maxByOrNull { it.value }
    println("A linguagem mais votada foi ${linguagemMaisVotada?.key} com ${linguagemMaisVotada?.value} votos")

}
