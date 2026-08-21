package aula_10_funcoes
fun main() {
    val num = 7
    isEven(num)

}
fun isEven(num: Int) {
    println("${num} É par? ${num % 2 == 0}")
}

fun sumOfTwoNumbers(){
    println(2 + 2)
}

// Essa função evidencia o tipo de retorno e pasa os parâmetros
fun sumOfTwoNumbers(a: Int, b: Int) : Int {
    return a + b
}