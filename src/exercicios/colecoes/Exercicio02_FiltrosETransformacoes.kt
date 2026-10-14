package exercicios.colecoes

/**
 * EXERCÍCIO 02: FILTROS E TRANSFORMAÇÕES COM LISTAS (FILTER E MAP)
 * 
 * Objetivo:
 * 1. Crie uma data class 'Funcionario' com as propriedades:
 *    - 'nome' (String)
 *    - 'cargo' (String)
 *    - 'salario' (Double)
 * 
 * 2. No 'main', crie uma lista com 5 funcionários com diferentes cargos e salários
 *    (ex: Desenvolvedor, Designer, Gerente, QA, etc.).
 * 
 * 3. Faça as seguintes operações funcionais na lista:
 *    - Use '.filter' para criar uma lista apenas com funcionários que ganham mais de R$ 5000.0.
 *      Imprima essa lista de funcionários filtrados.
 *    - Use '.map' para criar uma lista contendo apenas os NOMES de todos os funcionários
 *      em letras maiúsculas (.uppercase()). Imprima essa lista de nomes.
 *    - Use '.find' ou '.firstOrNull' para buscar o primeiro funcionário com o cargo "Gerente".
 *      Imprima o nome dele ou "Não encontrado" se não existir.
 *    - Use '.any' para verificar se existe algum funcionário com salário superior a R$ 10.000,0.
 *      Imprima o resultado booleano (true/false).
 */

fun main() {
    // ESCREVA SEU CÓDIGO AQUI
    val funcionarios = listOf(
        Funcionario("João", "Desenvolvedor", 5000.00),
        Funcionario("Maria", "Designer", 6000.00),
        Funcionario("Carlos", "Gerente", 10000.00),
        Funcionario("Ana", "QA", 4500.00),
        Funcionario("Pedro", "Desenvolvedor", 5500.00)
        )

    val funcionarioFiltrados = funcionarios.filter {
        it.salario > 5000.00
    }
    println(funcionarioFiltrados)

    val nomesDosFuncionarios = funcionarios.map {
        it.nome.uppercase()
    }
    println(nomesDosFuncionarios)

    val existeGerente = funcionarios.firstOrNull {
        it.cargo == "Gerente"
    } ?: "Não encontrado"
    println(existeGerente)

    val salarioMaiorQue10k = funcionarios.any {
        it.salario > 10000.00
    }
    println(salarioMaiorQue10k)

    }


data class Funcionario(val nome: String, val cargo: String, val salario: Double)