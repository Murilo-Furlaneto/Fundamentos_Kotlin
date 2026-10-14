package exercicios.enums

/**
 * EXERCÍCIO 02: PRIORIDADE DE TAREFAS (PROPRIEDADES E MÉTODOS)
 *
 * Cenário: um aplicativo precisa exibir prioridades de tarefas de forma legível.
 *
 * Objetivo:
 * 1. Crie um enum chamado 'Prioridade' com os valores 'BAIXA', 'MEDIA' e 'ALTA'.
 * 2. Cada valor deve guardar uma descrição para exibição e um número que
 *    represente seu nível (por exemplo, quanto maior o número, maior a prioridade).
 * 3. Crie no enum um método que informe se a prioridade é urgente. Considere
 *    urgente apenas a prioridade 'ALTA'.
 * 4. No main, percorra as prioridades e exiba o nome, a descrição, o nível e
 *    se cada uma é urgente.
 * 5. Use 'valueOf' para obter a prioridade 'MEDIA' a partir do texto "MEDIA"
 *    e exiba seus dados.
 *
 * Requisito: os dados e o método devem pertencer ao próprio enum.
 */

fun main(){
    for (prioridade in Prioridade.values()){
        println("Nome: " + prioridade.name + "-" + "\nDescrição:" + prioridade.descricao + "-" + "\nNúmero:" + prioridade.numero + "-" + "\nPrioridade:" + prioridade.ehUrgente())
    }

    val prioridadeMedia = Prioridade.valueOf("MEDIA")


}

enum class Prioridade(val descricao: String, val numero: Int) {
    BAIXA("Baixa", 1), MEDIA ("Media", 2), ALTA ("Alta", 3);

    fun ehUrgente(): Boolean {
        return when (this) {
            ALTA -> true
            else -> false
        }
    }


}