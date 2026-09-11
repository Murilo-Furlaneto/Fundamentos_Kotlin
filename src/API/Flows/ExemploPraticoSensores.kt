package API.Flows

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlin.random.Random
import kotlin.time.Duration.Companion.seconds

/**
 * --- EXEMPLO PRÁTICO: MONITOR DE TEMPERATURA ---
 * Simulando um sensor que emite a temperatura a cada segundo.
 * O StateFlow mantém o valor atual para a "tela".
 */

class SensorTemperatura {
    // SharedFlow para eventos de alerta (ex: Superaquecimento)
    private val _alertas = MutableSharedFlow<String>()
    val alertas = _alertas.asSharedFlow()

    // StateFlow para a temperatura atual
    private val _temperaturaAtual = MutableStateFlow(25.0)
    val temperaturaAtual = _temperaturaAtual.asStateFlow()

    suspend fun iniciarLeitura() {
        while (true) {
            delay(1.seconds)
            val novaTemp = 20.0 + Random.nextDouble() * 20.0
            _temperaturaAtual.value = novaTemp
            
            if (novaTemp > 35.0) {
                _alertas.emit("⚠️ ALERTA: Temperatura crítica: ${String.format("%.1f", novaTemp)}°C")
            }
        }
    }
}

fun main() = runBlocking {
    val sensor = SensorTemperatura()

    // Simula a UI escutando a temperatura atual
    launch {
        sensor.temperaturaAtual.collect { temp ->
            println("[TELA] Temperatura atual: ${String.format("%.1f", temp)}°C")
        }
    }

    // Simula um sistema de segurança escutando alertas
    launch {
        sensor.alertas.collect { alerta ->
            println("[SEGURANÇA] $alerta")
        }
    }

    // Inicia o sensor (roda por 5 segundos no exemplo)
    withTimeoutOrNull(5.seconds) {
        sensor.iniciarLeitura()
    }
    
    println("Fim do monitoramento.")
}
