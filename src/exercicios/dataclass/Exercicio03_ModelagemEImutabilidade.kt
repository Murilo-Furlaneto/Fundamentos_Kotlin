package exercicios.dataclass

/**
 * EXERCÍCIO 03: IMUTABILIDADE E ATUALIZAÇÃO DE ESTADO
 * 
 * Objetivo:
 * 1. Crie uma 'data class CarrinhoItem':
 *    - 'produtoNome' (String)
 *    - 'precoUnitario' (Double)
 *    - 'quantidade' (Int)
 * 
 * 2. Adicione uma propriedade calculada dentro do corpo da classe:
 *    - 'precoTotal: Double' (com getter customizado: get() = precoUnitario * quantidade).
 * 
 * 3. No 'main':
 *    - Crie uma instância inicial de 'item1' para "Fone Bluetooth", preço 150.0 e quantidade 1.
 *    - Imprima 'item1' e seu 'precoTotal'.
 *    - Simule o usuário aumentando a quantidade no aplicativo para 3 itens.
 *      Como as propriedades de uma data class imutável não devem ser alteradas diretamente,
 *      crie um 'itemAtualizado' usando .copy(quantidade = 3).
 *    - Imprima 'itemAtualizado' e o seu novo 'precoTotal'.
 *    - Imprima 'item1' novamente para comprovar que o objeto original não foi modificado.
 */

fun main() {
    // ESCREVA SEU CÓDIGO AQUI
}
