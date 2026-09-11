package exercicios.oop

/**
 * EXERCÍCIO 02: PAGAMENTO DE FUNCIONÁRIOS (POLIMORFISMO)
 * 
 * Objetivo:
 * 1. Crie uma classe abstrata 'Funcionario' com 'nome' e o método abstrato 'calcularSalario()'.
 * 2. Crie a subclasse 'Desenvolvedor' (salário fixo de 5000).
 * 3. Crie a subclasse 'Gerente' (salário fixo de 8000 + bônus de 2000).
 * 4. No main, crie uma lista de Funcionários contendo um de cada.
 * 5. Percorra a lista e imprima o nome e o salário final de cada um.
 */

fun main() {
    // ESCREVA SEU CÓDIGO AQUI

    val desenvolvedor = Desenvolvedor("João")
    val gerente = Gerente("Maria", 2000.00)

    val listaFuncionarios = listOf(desenvolvedor, gerente)

    listaFuncionarios.forEach { func ->
        println("Funcionário: ${func.nome} | Salário: ${func.calcularSalario()}")
    }
}

abstract class Funcionario(
    val nome: String
){
    abstract fun calcularSalario(): Double
}

class Desenvolvedor(
    nome: String
): Funcionario(nome){
    override fun calcularSalario(): Double {
      return 5000.00
    }
}

class Gerente(nome: String, val bonus: Double) : Funcionario(nome) {
    override fun calcularSalario(): Double {
        return 8000.00 + bonus
    }
}

