package exercicios.poo

/**
 * EXERCÍCIO 01: CLASSE BÁSICA, ATRIBUTOS E MÉTODOS
 * 
 * Objetivo:
 * 1. Crie uma classe chamada 'ContaBancaria' com:
 *    - 'titular' (String, imutável)
 *    - 'saldo' (Double, mutável, valor inicial padrão 0.0)
 * 
 * 2. Adicione os seguintes métodos na classe 'ContaBancaria':
 *    - 'depositar(valor: Double)': aumenta o saldo se o valor for maior que 0.
 *      Se o valor for <= 0, exiba a mensagem: "Valor de depósito inválido!".
 *    - 'sacar(valor: Double): Boolean': verifica se o valor é maior que 0 e se há saldo suficiente.
 *      Se houver saldo, deduz do saldo, exibe "Saque de R$X realizado!" e retorna true.
 *      Se não houver saldo suficiente, exibe "Saldo insuficiente!" e retorna false.
 *    - 'exibirExtrato()': imprime o nome do titular e o saldo atual formatado.
 * 
 * 3. No 'main':
 *    - Crie uma conta para o titular "Maria" com saldo inicial de 100.0.
 *    - Faça um depósito de 50.0.
 *    - Tente realizar um saque de 200.0 (deve falhar por saldo insuficiente).
 *    - Realize um saque de 70.0 (deve ter sucesso).
 *    - Exiba o extrato final da conta.
 */

fun main() {
  val  contaMaria = ContaBancaria("Maria", 100.0)
    contaMaria.depositar(50.0)
    contaMaria.sacar(200.0)
    contaMaria.sacar(70.0)
    contaMaria.exibirSaldo()
}


class ContaBancaria(val titular: String, var saldo: Double = 0.0){

    fun depositar(valor: Double) {
        if(valor > 0) {
            saldo += valor
        } else {
            println("Valor de depósito inválido!")
        }
    }

    fun sacar(valor: Double) : Boolean{
        if(saldo >= valor) {
            saldo -= valor
            println("Saque de R$$valor realizado!")
            return true
        } else {
            println("Saldo insuficiente!")
            return false
        }
    }

    fun exibirSaldo() {
        println("Titular: $titular, Saldo: $saldo")
    }
}