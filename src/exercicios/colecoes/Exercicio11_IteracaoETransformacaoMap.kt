package exercicios.colecoes

/**
 * EXERCÍCIO 11: ITERAÇÃO E TRANSFORMAÇÕES EM MAPS (FILTERVALUES E MAPVALUES)
 * 
 * Objetivo:
 * 1. Crie um Map de notas de alunos:
 *    val notasAlunos = mapOf(
 *        "Ana" to 8.5,
 *        "Bruno" to 6.0,
 *        "Carlos" to 9.0,
 *        "Daniela" to 5.5,
 *        "Eduardo" to 7.0
 *    )
 * 
 * 2. Iteração com Destructuring:
 *    - Use um loop 'for ((nome, nota) in notasAlunos)' para percorrer o mapa.
 *    - Para cada aluno, imprima se ele está "Aprovado" (nota >= 7.0) ou "Reprovado" (nota < 7.0).
 * 
 * 3. Filtro e Transformação de Map:
 *    - Use '.filterValues { ... }' para criar um novo Map contendo apenas os alunos com nota >= 7.0 (Aprovados) e imprima esse Map.
 *    - Use '.mapValues { ... }' para transformar o Map original em um novo Map <String, String> onde o valor
 *      seja "Aprovado" se nota >= 7.0 ou "Reprovado" caso contrário. Imprima esse novo Map.
 */

fun main() {
    // ESCREVA SEU CÓDIGO AQUI
    val notasAlunos = mapOf(
               "Ana" to 8.5,
                "Bruno" to 6.0,
                "Carlos" to 9.0,
                "Daniela" to 5.5,
                "Eduardo" to 7.0
                    )

    for ((nome, nota) in notasAlunos) {
        if (nota >= 7.0) {
            println("$nome está Aprovado")
        } else {
            println("$nome está Reprovado")
        }
    }

    val alunosAprovados = notasAlunos.filterValues { it >= 7.0 }
    println(alunosAprovados)

    val alunosComStatus = notasAlunos.mapValues { (nome, nota) ->
        if (nota >= 7.0) {
            "Aprovado"
        } else {
            "Reprovado"
        }
    }
    println(alunosComStatus)
}
