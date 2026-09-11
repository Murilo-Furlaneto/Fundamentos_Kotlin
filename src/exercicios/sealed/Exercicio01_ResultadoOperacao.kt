package exercicios.sealed

/**
 * EXERCÍCIO 01: ESTADOS DE UMA OPERAÇÃO (SEALED CLASSES)
 * 
 * Cenário: Muito comum no Android para representar estados da tela (Loading, Success, Error).
 * 
 * Objetivo:
 * 1. Crie uma Sealed Class chamada 'Resultado'.
 * 2. Crie 3 subclasses:
 *    - 'Sucesso' (data class que recebe uma String com os dados).
 *    - 'Erro' (data class que recebe uma String com a mensagem de erro).
 *    - 'Carregando' (object).
 * 3. Crie uma função 'processarResultado(res: Resultado)' que use um 'when' 
 *    para imprimir uma mensagem diferente para cada estado.
 * 4. No main, simule a chamada da função passando cada um dos estados.
 */

fun main() {
    processarResultado(Resultado.Carregando)
    processarResultado(Resultado.Sucesso("Dados atualizados!"))
    processarResultado(Resultado.Erro("Falha na conexão!"))
}

sealed class Resultado() {
    data class Sucesso(val data: String) : Resultado()
    data class Erro(val message: String) : Resultado()
    object Carregando : Resultado()
}

fun processarResultado(res: Resultado) {
    when (res) {
        is Resultado.Sucesso -> println("Sucesso: ${res.data}")
        is Resultado.Erro -> println("Erro: ${res.message}")
        is Resultado.Carregando -> println("Carregando...")
    }

}