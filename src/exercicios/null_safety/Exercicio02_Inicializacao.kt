package exercicios.null_safety

/**
 * EXERCÍCIO 02: LATEINIT VS LAZY
 * 
 * Objetivo:
 * 1. Crie uma classe 'Configuracao'.
 * 2. Adicione uma propriedade 'lateinit var bancoDados: String'.
 * 3. Adicione uma propriedade 'val apiKey: String by lazy { ... }' que imprima 
 *    "Gerando chave..." e retorne "ABC-123" apenas quando for acessada.
 * 4. No main:
 *    a) Acesse a 'apiKey' duas vezes e observe quantas vezes o "Gerando chave..." aparece.
 *    b) Inicialize o 'bancoDados' e imprima-o.
 *    c) Tente entender o que aconteceria se você imprimisse 'bancoDados' ANTES de inicializar.
 */

fun main() {
    val configuracao = Configuracao()
    println(configuracao.apiKey)
    println(configuracao.apiKey)
    configuracao.bancoDados = "Banco de Dados Conectado"
    println(configuracao.bancoDados)
}

class Configuracao(){
    lateinit var bancoDados: String
    val apiKey: String by lazy {
        println("Gerando chave...")
        "ABC-123"
    }
}
