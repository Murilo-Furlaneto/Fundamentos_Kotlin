package exercicios.data_classes

/**
 * EXERCÍCIO 01: DATA CLASSES E DESTRUCTURING
 * 
 * Objetivo:
 * 1. Crie uma Data Class 'Endereco' com (rua, numero, cidade).
 * 2. No main, crie uma instância de 'Endereco'.
 * 3. Use a declaração de desestruturação (destructuring declaration) para extrair 
 *    a 'rua' e a 'cidade' em variáveis separadas em uma única linha.
 * 4. Use o método '.copy()' para criar um novo endereço na mesma rua e cidade, 
 *    mas com um número diferente.
 * 5. Imprima ambos os endereços.
 */

fun main() {
    var endereco = Endereco("Rua A", 123, "São Paulo")
    var (rua, _, cidade) = endereco
    println("Rua: $rua, Cidade: $cidade")
}

data class Endereco(
    val rua: String,
    val numero: Int,
    val cidade: String,
)
