package exercicios.objetos

import aula_22_classe_aninhada.Car

/**
 * EXERCÍCIO 01: COMPANION OBJECTS E FACTORY
 * 
 * Objetivo:
 * 1. Crie uma classe 'Carro' com as propriedades 'modelo' e 'ano'.
 * 2. Adicione um 'companion object' à classe 'Carro'.
 * 3. Dentro do companion object, crie uma função "fábrica" chamada 'criarTesla(ano: Int)'
 *    que retorne uma instância de Carro com o modelo já definido como "Tesla Model S".
 * 4. No main, crie um carro normal pelo construtor e um Tesla usando a função do companion object.
 * 5. Imprima os detalhes de ambos.
 */

fun main() {
    val carro1 = Carro("Honda Civic", 2020)
    val carro2 = Carro.criarTesla(2023)

    println(imprimirDetalhesCarro(carro1))
    println(imprimirDetalhesCarro(carro2))
}

class Carro(val modelo: String, val ano: Int) {
    companion object {
        fun criarTesla(ano: Int): Carro {
            return Carro("Tesla Model S", ano)
        }
    }
}

fun imprimirDetalhesCarro(carro: Carro): String {
    return "Modelo: ${carro.modelo}, Ano: ${carro.ano}"
}