package exercicios.colecoes

/**
 * EXERCÍCIO 03: ORDENAÇÃO, AGRUPAMENTO E AGREGAÇÃO EM LISTAS
 * 
 * Objetivo:
 * 1. Crie uma data class 'Tarefa' com as propriedades:
 *    - 'id' (Int)
 *    - 'titulo' (String)
 *    - 'concluida' (Boolean)
 *    - 'prioridade' (Int)  // 1 = Alta, 2 = Média, 3 = Baixa
 * 
 * 2. No 'main', crie uma lista com 5 tarefas (algumas concluídas e outras pendentes, com diferentes prioridades).
 * 
 * 3. Realize as seguintes operações:
 *    - Ordene as tarefas por prioridade (da mais alta/1 para a mais baixa/3) usando '.sortedBy { it.prioridade }'
 *      e imprima a lista ordenada.
 *    - Calcule a média da prioridade de todas as tarefas usando '.map { it.prioridade }.average()' ou '.average()'.
 *    - Agrupe as tarefas pelo seu status de conclusão usando '.groupBy { it.concluida }'.
 *      Isso retornará um Map<Boolean, List<Tarefa>>. Imprima quantas tarefas estão concluídas (true) e quantas pendentes (false).
 *    - Encontre a tarefa de maior prioridade (menor número de prioridade) que ainda NÃO foi concluída.
 */

fun main() {
    // ESCREVA SEU CÓDIGO AQUI
    val tarefas = listOf(
        Tarefa(1, "Tarefa 1", false, 1),
        Tarefa(2, "Tarefa 2", true, 2),
        Tarefa(3, "Tarefa 3", false, 3),
        Tarefa(4, "Tarefa 4", true, 1),
        Tarefa(5, "Tarefa 5", false, 2)
    )

    val tarefasOrdenadas = tarefas.sortedBy { it.prioridade }
    println(tarefasOrdenadas)

    val mediaPrioridade = tarefas.map { it.prioridade }.average()

    val tarefasAgrupadas = tarefas.groupBy { it.concluida }

    val tarefasConcluidas = tarefasAgrupadas[true]?.size ?: 0
    val tarefasPendentes = tarefasAgrupadas[false]?.size ?: 0

    println("Tarefas concluídas: $tarefasConcluidas")
    println("Tarefas pendentes: $tarefasPendentes")

    val tarefaPendentePrioritaria = tarefas
        .filter { !it.concluida }
        .minByOrNull { it.prioridade }

    println("Tarefa pendente mais urgente: ${tarefaPendentePrioritaria?.titulo}")

}


data class Tarefa(val id: Int, val titulo: String, val concluida: Boolean, val prioridade: Int)