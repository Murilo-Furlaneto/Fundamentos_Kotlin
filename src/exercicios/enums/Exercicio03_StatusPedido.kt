package exercicios.enums

/**
 * EXERCÍCIO 03: STATUS DE PEDIDO (ENUM E LÓGICA DE NEGÓCIO)
 *
 * Cenário: uma loja acompanha os pedidos desde a confirmação até a entrega.
 *
 * Objetivo:
 * 1. Crie um enum chamado 'StatusPedido' com os valores 'PENDENTE',
 *    'PAGO', 'ENVIADO', 'ENTREGUE' e 'CANCELADO'.
 * 2. Crie uma função que receba um status e retorne uma mensagem adequada
 *    para o cliente usando 'when'.
 * 3. Crie outra função que receba um status e indique se o pedido ainda pode
 *    ser cancelado. Considere que pode ser cancelado enquanto estiver
 *    'PENDENTE' ou 'PAGO'.
 * 4. No main, percorra todos os status e exiba a mensagem e a informação
 *    sobre a possibilidade de cancelamento.
 * 5. Faça uma simulação de um pedido que passa por 'PENDENTE', 'PAGO',
 *    'ENVIADO' e 'ENTREGUE', exibindo a mensagem em cada etapa.
 *
 * Requisito: trate todos os valores do enum explicitamente nos 'when'.
 */

fun main() {
    for (status in StatusPedido.values()) {
        println(status.mensagem())
        println(status.podeSerCancelado())
    }

    val pedido = StatusPedido.PENDENTE
    println(pedido.mensagem())
    println(pedido.podeSerCancelado())

    val pedido2 = StatusPedido.PAGO
    println(pedido2.mensagem())
    println(pedido2.podeSerCancelado())

    val pedido3 = StatusPedido.ENVIADO
    println(pedido3.mensagem())
    println(pedido3.podeSerCancelado())

}

enum class StatusPedido(val descricao: String) {
    PENDENTE("Pendente"), PAGO("Pago"), ENVIADO("Enviado"), ENTREGUE("Entregue"), CANCELADO("Cancelado");

    fun podeSerCancelado() : Boolean {
        return when(this) {
            PENDENTE,PAGO -> true
            else -> false
        }
    }

    fun mensagem(): String {
        return when (this) {
            PENDENTE -> "Seu pedido está pendente."
            PAGO -> "Seu pedido foi pago."
            ENVIADO -> "Seu pedido foi enviado."
            ENTREGUE -> "Seu pedido foi entregue."
            CANCELADO -> "Seu pedido foi cancelado."
        }
    }
}

