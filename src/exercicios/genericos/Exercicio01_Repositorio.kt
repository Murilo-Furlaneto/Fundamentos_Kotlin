package exercicios.genericos

/**
 * EXERCÍCIO 01: REPOSITÓRIO GENÉRICO
 * 
 * Objetivo:
 * 1. Crie uma classe 'Repositorio<T>' que armazena uma lista privada de itens do tipo T.
 * 2. Adicione os métodos:
 *    - 'adicionar(item: T)': adiciona na lista.
 *    - 'listarTodos()': retorna a lista.
 * 3. No main, crie um repositório para 'String' e outro para um objeto 'Produto(nome, preco)'.
 * 4. Adicione itens e liste-os para provar que a classe funciona com qualquer tipo.
 */

data class Produto(val nome: String, val preco: Double)

fun main() {
    // ESCREVA SEU CÓDIGO AQUI
}
