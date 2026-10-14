package exercicios.poo

import com.sun.tools.javac.code.TypeAnnotationPosition.field

/**
 * EXERCÍCIO 02: PROPRIEDADES COM GETTERS E SETTERS CUSTOMIZADOS
 * 
 * Objetivo:
 * 1. Crie uma classe 'Produto' com as propriedades:
 *    - 'nome' (String, imutável)
 *    - 'preco' (Double, mutável)
 *    - 'descontoPercentual' (Int, mutável, valor padrão 0)
 * 
 * 2. Adicione validação na propriedade 'preco':
 *    - Use um setter customizado (com 'field') para garantir que o preço nunca seja negativo.
 *      Se for informado um valor menor que 0, atribua 0.0 e exiba um aviso: "Preço não pode ser negativo!".
 * 
 * 3. Adicione duas propriedades calculadas (apenas com getter):
 *    - 'precoComDesconto' (Double): retorna o preço aplicando o desconto percentual.
 *      Exemplo: preço 100.0 com 20% de desconto -> retorna 80.0.
 *    - 'emPromocao' (Boolean): retorna 'true' se 'descontoPercentual' for maior que 0.
 * 
 * 4. No 'main':
 *    - Crie um produto "Notebook" com preço 3000.0 e desconto de 10%.
 *    - Imprima se ele está em promoção e o valor com desconto.
 *    - Tente alterar o preço para -500.0 para testar o setter customizado.
 *    - Imprima o preço atual do produto após a tentativa de alteração.
 */

fun main() {
    // ESCREVA SEU CÓDIGO AQUI
    val notebook = Produto("Notebook", 3000.0, 10)
    println("Em promoção: ${notebook.emPromocao}")
    println("Preço com desconto: ${notebook.precoComDesconto}")
    notebook.preco = -500.0
    println("Preço atual: ${notebook.precoComDesconto}")
}

class Produto(val nome: String, precoInicial: Double, var descontoPercentual: Int = 0) {

    var preco: Double = precoInicial
        set(value) {
            if (value >= 0) {
                field = value
            } else {
                field = 0.0
                println("Preço não pode ser negativo!")
            }
        }

    val precoComDesconto: Double
        get() = preco * (1 - descontoPercentual / 100.0)

    val emPromocao: Boolean
        get() = descontoPercentual > 0
}