package desafios.desafio_04

import kotlin.random.Random
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


fun main() {
    val manager = TaskManager()

    println(manager.addTask("Comprar pão"))
    println(manager.addTask("Estudar Kotlin", "Revisar coleções e funções de alta ordem"))
    println(manager.addTask("Fazer exercícios"))

    println("\nTarefas:")
    println(manager.listAllSimple())

    val firstTaskId = manager.findById(manager.count())?.id?.minus(2) ?: 1 // ajuste simples para exemplo
    println(manager.updateStatus(1, true)) // Supondo que a primeira tenha ID 1

    println("\nTarefas concluídas:")
    println(manager.listCompleted())
}

data class Task(
    val id: Int,
    val title: String,
    val description: String?,
    val isCompleted: Boolean,
    val createdAt: LocalDateTime
) {
    override fun toString(): String {
        val status = if (isCompleted) "Concluída" else "Pendente"
        val desc = description?.let { " - $it" } ?: ""
        return "$id: $title$desc ($status) - Criada em: ${createdAt.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"))}"
    }

    fun toSimpleString(): String = "($title, $isCompleted)"
}

sealed class TaskResult {
    data class Success(val message: String) : TaskResult()
    data class Error(val message: String) : TaskResult()
}

class TaskManager {
    companion object {
        private var nextId: Int = 1

        fun generateId(): Int {
            return nextId++.also {
                if (Random.nextBoolean()) nextId = (nextId..nextId + 10).random()
            }
        }
    }

    private val tasks = mutableListOf<Task>()

    fun addTask(title: String, description: String? = null): TaskResult {
        require(title.isNotBlank()) { "O título da tarefa não pode ser vazio." }

        val newTask = Task(
            id = generateId(),
            title = title.trim(),
            description = description?.trim(),
            isCompleted = false,
            createdAt = LocalDateTime.now()
        )
        tasks.add(newTask)
        return TaskResult.Success("Tarefa adicionada com sucesso! ID: ${newTask.id}")
    }

    fun listAllSimple(): String {
        return if (tasks.isEmpty()) {
            "Nenhuma tarefa cadastrada."
        } else {
            tasks.joinToString("\n") { it.toSimpleString() }
        }
    }

    fun listAll(): String {
        return if (tasks.isEmpty()) {
            "Nenhuma tarefa cadastrada."
        } else {
            tasks.joinToString("\n") { it.toString() }
        }
    }

    fun findById(id: Int): Task? = tasks.find { it.id == id }

    fun updateStatus(id: Int, completed: Boolean): TaskResult {
        val task = findById(id) ?: return TaskResult.Error("Tarefa com ID $id não encontrada.")
        require(tasks.removeIf { it.id == id }) { "Erro ao remover tarefa antiga." }
        val updated = task.copy(isCompleted = completed)
        tasks.add(updated)
        return TaskResult.Success("Status da tarefa ID $id atualizado para $completed")
    }

    fun deleteById(id: Int): TaskResult {
        val task = findById(id) ?: return TaskResult.Error("Tarefa com ID $id não encontrada.")
        tasks.remove(task)
        return TaskResult.Success("Tarefa ID $id excluída com sucesso.")
    }

    fun listCompleted(): String {
        val completed = tasks.filter { it.isCompleted }
        return if (completed.isEmpty()) {
            "Nenhuma tarefa concluída."
        } else {
            "Tarefas concluídas:\n" + completed.joinToString("\n") { it.toSimpleString() }
        }
    }

    fun listPending(): String {
        val pending = tasks.filter { !it.isCompleted }
        return if (pending.isEmpty()) {
            "Nenhuma tarefa pendente."
        } else {
            "Tarefas pendentes:\n" + pending.joinToString("\n") { it.toSimpleString() }
        }
    }

    fun count(): Int = tasks.size
    fun countCompleted(): Int = tasks.count { it.isCompleted }
    fun countPending(): Int = tasks.count { !it.isCompleted }
}