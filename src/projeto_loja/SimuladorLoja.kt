package projeto_loja

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlin.time.Duration.Companion.seconds

/**
 * --- DESAFIO: SIMULADOR DE LOJA VIRTUAL ---
 * 
 * Objetivo: Integrar os conhecimentos de Coroutines, Flow, Sealed Classes e Extensions.
 * 
 * Requisitos:
 * 1. Crie uma Extension Function em Double chamada 'paraMoeda()' que retorne "R$ 0.00" (formatado).
 * 2. Crie uma Sealed Class 'TipoPagamento' com: Pix, Cartao(numero: String), Boleto.
 * 3. Crie uma Sealed Class 'StatusPedido' com: Pendente, Processando, Aprovado, Recusado.
 * 4. Crie uma função 'processarPagamento(valor: Double, tipo: TipoPagamento)' que:
 *    - Retorne um FLOW de 'StatusPedido'.
 *    - Emita 'Processando' imediatamente.
 *    - Espere 2 segundos (simulando banco).
 *    - Se for 'Cartao' e o número começar com "444", emita 'Recusado'.
 *    - Caso contrário, emita 'Aprovado'.
 */

fun main() = runBlocking {
    val valorCompra = 150.50
    println("--- Bem-vindo à Loja Kotlin ---")
    // Use sua extensão aqui para imprimir o valor: println("Total da compra: ${valorCompra.paraMoeda()}")

    println("Total da compra: ${valorCompra.paraMoeda()}")

    // Simule um pagamento:
     val tipo = TipoPagamento.Cartao("1234...")
    
    // Chame a função e faça o collect do Flow para mostrar os status na tela
    processarPagamento(valorCompra, tipo).collect { status ->
        println("Status do pedido: $status")
    }
}

// --- IMPLEMENTE AS CLASSES E FUNÇÕES ABAIXO ---
fun Double.paraMoeda() : Double {
    return this.toBigDecimal().setScale(2).toDouble();
}

sealed class TipoPagamento(){
    object Pix : TipoPagamento()
    data class Cartao(val numero: String) : TipoPagamento()
    object Boleto : TipoPagamento()
}

sealed class  StatusPedido(){
    object Pendente: StatusPedido()
    object Processando: StatusPedido()
    object Aprovado: StatusPedido()
    object Recusado: StatusPedido()
}

fun processarPagamento(valor: Double, tipo: TipoPagamento) : Flow<StatusPedido> {
  return  flow {
        emit(StatusPedido.Processando)
        delay(2.seconds)
        if (tipo is TipoPagamento.Cartao && tipo.numero.startsWith("444")) {
            emit(StatusPedido.Recusado)
        }
        else {
            emit(StatusPedido.Aprovado)
        }
    }

}