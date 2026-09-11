package exercicios.oop

/**
 * EXERCÍCIO 01: SISTEMA BANCÁRIO SIMPLES
 * 
 * Objetivo:
 * 1. Crie uma classe 'ContaBancaria' com:
 *    - Propriedades: 'titular' (String) e 'saldo' (Double, inicia em 0.0).
 *    - Método 'depositar(valor: Double)': Aumenta o saldo.
 *    - Método 'sacar(valor: Double)': Diminui o saldo se houver fundos, senão imprime erro.
 *    - Método 'exibirSaldo()': Imprime o nome do titular e o saldo atual.
 * 2. No main, crie uma instância da conta, faça um depósito, um saque com sucesso e tente um saque maior que o saldo.
 */

fun main() {
    // ESCREVA SEU CÓDIGO AQUI
    val conta = ContaBancaria("João")
    conta.depositar(100.0)
    conta.sacar(50.0)
    conta.sacar(150.0)

}

class ContaBancaria(
    val titular: String,
    var saldo: Double = 0.0,
) {
    fun depositar(valor: Double) {
        if (valor != 0.0) {
            saldo += valor
        }
        else {
            println("Valor inválido!")
        }
        println("Novo saldo: $saldo")
    }

    fun sacar(valor: Double) {
        if (valor <= saldo) {
            saldo -= valor
        }
        else {
            println("Saldo insuficiente!")
        }
        println("Novo saldo: $saldo")
    }


    fun exibirSaldo() {
        println("Titular: $titular")
        println("Saldo: $saldo")
    }

}