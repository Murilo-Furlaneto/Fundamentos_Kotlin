package API.Flows

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlin.time.Duration.Companion.milliseconds

/**
 * --- HOT FLOWS: STATEFLOW E SHAREDFLOW ---
 * Diferente do Flow comum (Cold), estes são HOT (Quentes).
 * Eles existem independentemente de haver um coletor ou não.
 * 
 * 1. StateFlow: Ótimo para manter ESTADO (ex: UI State). 
 *    - Sempre tem um valor inicial.
 *    - Sempre emite o ÚLTIMO valor para novos coletores.
 * 
 * 2. SharedFlow: Ótimo para EVENTOS (ex: mostrar um Toast, navegar).
 *    - Não tem valor inicial por padrão.
 *    - Pode configurar o "replay" (quantos valores antigos enviar para novos coletores).
 */

fun main() = runBlocking {

    println("--- Exemplo MutableStateFlow ---")
    val uiState = MutableStateFlow("Aguardando...") // Valor inicial obrigatório

    val job = launch {
        uiState.collect { estado ->
            println("UI recebeu: $estado")
        }
    }

    delay(500.milliseconds)
    uiState.value = "Carregando dados..." // Atualizando o estado
    delay(500.milliseconds)
    uiState.value = "Sucesso!"
    
    // Novo coletor após o estado já ter mudado
    println("Novo coletor entrando...")
    val jobNovoColetor = launch {
        uiState.collect { estado ->
            println("Novo coletor recebeu IMEDIATAMENTE: $estado")
        }
    }

    delay(100.milliseconds)
    job.cancel()
    jobNovoColetor.cancel()
    println("\n--- Fim do Exemplo ---")
}
