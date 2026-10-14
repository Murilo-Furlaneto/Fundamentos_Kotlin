package exercicios.funcoes_basicas

/**
 * EXERCÍCIO 01: PARÂMETROS NOMEADOS, PADRÃO E VARARG
 * 
 * Objetivo:
 * 1. Crie uma função chamada 'criarMensagem' que recebe:
 *    - 'remetente' (String)
 *    - 'mensagem' (String)
 *    - 'urgente' (Boolean, com valor padrão 'false')
 *    - A função deve retornar uma String formatada. Se for urgente, adicione "🚨 IMPORTANTE:" no início.
 * 
 * 2. Crie uma função chamada 'somarNumeros' que use 'vararg' para receber vários números inteiros (Int)
 *    e retorne a soma de todos eles.
 * 
 * 3. No main:
 *    - Chame 'criarMensagem' usando parâmetros nomeados (mudando a ordem deles na chamada).
 *    - Chame 'criarMensagem' sem passar o parâmetro 'urgente' (deixando usar o padrão).
 *    - Chame 'somarNumeros' passando 5 números diferentes e imprima o resultado.
 */

fun main() {
    println(
        criarMensagem("Fulano", "Olá, tudo bem?", true)
    )
    println(criarMensagem("Fulano", "Olá, tudo bem?"))
    somarNumeros(1, 2, 3, 4, 5)
}


fun criarMensagem(remetente: String, mensagem: String, urgente: Boolean = false): String {
    return if (urgente) "🚨 IMPORTANTE: O $remetente esta te enviando essa mensagem: $mensagem" else "O $remetente esta te enviando essa mensagem: $mensagem"
}

fun somarNumeros(vararg numeros: Int) {
    var soma = 0
    for (numero in numeros) {
        soma += numero
    }
    println(soma)
}
