package exercicios.poo

/**
 * EXERCÍCIO 03: BLOCO INIT E CONSTRUTORES SECUNDÁRIOS
 * 
 * Objetivo:
 * 1. Crie uma classe 'Aluno' com:
 *    - Construtor primário que recebe 'nome' (String), 'nota1' (Double) e 'nota2' (Double).
 * 
 * 2. Adicione um bloco 'init':
 *    - Verifique se as notas estão entre 0.0 e 10.0.
 *    - Se 'nota1' ou 'nota2' forem menores que 0 ou maiores que 10, exiba o aviso:
 *      "Aviso: Nota inválida detectada para o aluno X!".
 * 
 * 3. Adicione um construtor secundário:
 *    - Deve receber apenas o 'nome' (String) e definir ambas as notas com valor inicial 0.0.
 *      (Lembre-se de delegar para o construtor primário usando ': this(...)').
 * 
 * 4. Adicione as propriedades calculadas (getter):
 *    - 'media' (Double): retorna a média aritmética entre nota1 e nota2.
 *    - 'aprovado' (Boolean): retorna 'true' se a média for maior ou igual a 7.0.
 * 
 * 5. No 'main':
 *    - Crie um aluno "Carlos" usando o construtor primário com notas 8.5 e 7.0.
 *    - Crie um aluno "Ana" usando o construtor secundário (apenas o nome).
 *    - Crie um aluno "João" com uma nota inválida (ex: 12.0) para testar o bloco 'init'.
 *    - Imprima a média e o status de aprovação de cada um.
 */

fun main() {
    val carlos = Aluno("Carlos", 8.5, 7.0)
    val ana = Aluno("Ana")
    val joao = Aluno("João", 12.0, 10.0)

    println("${carlos.nome}: Média = ${carlos.media}, Aprovado = ${carlos.aprovado}")
    println("${ana.nome}: Média = ${ana.media}, Aprovado = ${ana.aprovado}")
    println("${joao.nome}: Média = ${joao.media}, Aprovado = ${joao.aprovado}")
}
class Aluno(val nome: String, var nota1: Double, var nota2: Double) {
    init {
        for (nota in listOf(nota1, nota2)) {
            if (nota < 0.0 || nota > 10.0) {
                println("Aviso: Nota inválida detectada para o aluno $nome!")
            }
        }
    }

    constructor( nome: String) : this(nome, 0.0, 0.0)

    val media: Double
    get() = (nota1 + nota2) / 2

    val aprovado: Boolean
    get() = media >= 7.0

}