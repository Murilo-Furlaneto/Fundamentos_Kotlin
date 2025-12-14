package aula_04_operadores_logicos

fun main(){

    val a = true
    val b = false
    val c = true

    val result = a && b
    val result2 = a && c


    println("Operador E:")
    println(result)
    println(result2)

    val result3 = a || b
    val result4 = a || c

    println("Operador OU:")
    println(result3)
    println(result4)


    val e = true
    val f = !e

    println("Operador NÃO:")
    println(f)

    val l = 10
    val k = 3
    println(l % k)
}