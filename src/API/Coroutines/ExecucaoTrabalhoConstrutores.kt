package API.Coroutines

import kotlinx.coroutines.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.time.Duration.Companion.milliseconds

/**
 * --- EXEMPLO PRÁTICO: CONSTRUÇÃO DE UMA CASA ---
 * Este arquivo utiliza a metáfora de uma obra para demonstrar a concorrência.
 * 
 * - Pedir materiais (async): Você faz o pedido e continua trabalhando enquanto espera.
 * - Trabalhar (launch): Tarefas que podem ser feitas em paralelo.
 * - await(): Só podemos instalar o material quando ele chegar.
 */

enum class BuildingMaterial(val description: String, val deliveringTimeInMillis: Long) {
    DOORS("PORTAS", 500), 
    WINDOWS("JANELAS", 1_000), 
    ROOF("TELHADO", 3_000)
}

fun getTimeNow(): String = SimpleDateFormat("hh:mm:ss.SSS", Locale.getDefault()).format(Date())

suspend fun order(material: BuildingMaterial): BuildingMaterial {
    println("${getTimeNow()} > [PEDIDO] Solicitando ${material.description}...")
    delay(material.deliveringTimeInMillis.milliseconds)
    println("${getTimeNow()} > [CHEGOU] ${material.description} estão na obra!")
    return material
}

suspend fun doWork(task: String) {
    println("${getTimeNow()} > [TRABALHANDO] Iniciando: $task")
    delay(1000.milliseconds)
    println("${getTimeNow()} > [OK] Concluído: $task")
}

fun main() = runBlocking {
    println("${getTimeNow()} --- INÍCIO DA OBRA ---")

    // async inicia a entrega dos materiais em paralelo (background)
    // Cada pedido demora um tempo diferente, mas todos começam "ao mesmo tempo"
    val doorsOrder = async { order(BuildingMaterial.DOORS) }
    val windowsOrder = async { order(BuildingMaterial.WINDOWS) }
    val roofOrder = async { order(BuildingMaterial.ROOF) }

    // Enquanto os materiais não chegam, os pedreiros sobem as paredes (tarefa independente)
    doWork("SUBIR PAREDES")

    // launch cria "equipes" diferentes para cada instalação
    launch {
        // await() suspende APENAS esta coroutine até o material chegar
        val mat = doorsOrder.await()
        doWork("INSTALAR ${mat.description}")
    }

    launch {
        val mat = windowsOrder.await()
        doWork("INSTALAR ${mat.description}")
    }

    launch {
        val mat = roofOrder.await()
        doWork("INSTALAR ${mat.description}")
    }

    println("${getTimeNow()} --- AGUARDANDO FINALIZAÇÃO TOTAL ---")
}
