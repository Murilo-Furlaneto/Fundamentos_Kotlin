package exercicios.enums

/**
 * EXERCÍCIO 01: DIAS DA SEMANA (ENUM BÁSICO)
 *
 * Objetivo:
 * 1. Crie um enum chamado 'DiaDaSemana' com os sete dias da semana.
 * 2. Crie uma função que receba um 'DiaDaSemana' e informe se ele é dia útil
 *    ou fim de semana.
 * 3. Use 'when' para tratar todos os valores do enum.
 * 4. No main, percorra todos os dias e mostre o nome do dia e a classificação.
 *
 * Dica: use 'entries' para obter todos os valores do enum.
 */

fun main(){
    for (dia in DiaDaSemana.entries){
        println(dia.name + "-" + dia.ehDiaUtil())
    }
}


enum class DiaDaSemana(val dia: Int) {
    DOMINGO(1),
    SEGUNDA(2),
    TERCA(3),
    QUARTA(4),
    QUINTA(5),
    SEXTA(6),
    SABADO(7);

    fun ehDiaUtil(): Boolean {
        return when (this) {
            DOMINGO, SABADO -> false
            else -> true
        }
    }
}
