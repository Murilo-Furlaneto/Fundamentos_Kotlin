package exercicios.logica

/**
 * EXERCÍCIO 01: CONTROLE DE FLUXO E RANGES
 * 
 * Objetivo:
 * 1. Use um loop 'for' e um Range para imprimir os números de 20 até 1 (em ordem decrescente).
 * 2. Mas altere o loop para pular de 2 em 2 (dica: use 'downTo' e 'step').
 * 3. Dentro do loop, use uma expressão 'when' para:
 *    - Se o número for 10, imprimir: "Metade do caminho!".
 *    - Se o número for 18 ou 4, imprimir: "Número da sorte: X".
 *    - Para os outros números, apenas imprimir o número normalmente.
 */

fun main() {
    println("Início do loop")
    for (i in 20 downTo 1 step 2){
        when (i) {
            10 -> println("Metade do caminho!")
            18, 4 -> println("Número da sorte: $i")
            else -> println(i)
        }
    }
    println("Fim do loop")
}
