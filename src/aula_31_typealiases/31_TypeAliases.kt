package aula_31_typealiases

fun main(){
    val estudantes = mapOf(
        "Alice" to listOf(5,6,7,8),
        "Bruno" to listOf(4,7,9)
    )

    processaNotas(estudantes)

    val (nome, idade) = Pessoa("João", 25)
    println("$nome tem $idade anos")
}
data class Pessoa(val nome: String, val idade: Int)

fun mathOperation(a: Int, b: Int, operation: Operation) : Int {
    return operation(a,b)
}

typealias Operation = (Int, Int) -> Int

typealias  MapaDeEstudantes = Map<NomeDoAluno, NotasDoAluno>


fun processaNotas(mapaDeEstudantes: MapaDeEstudantes){
    for ((nomes,notas) in mapaDeEstudantes){
        println("Estdante $nomes | Notas: $notas")
    }
}

typealias  NotasDoAluno = List<Int>

typealias  NomeDoAluno = String