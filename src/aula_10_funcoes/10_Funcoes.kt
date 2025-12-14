package aula_10_funcoes

fun main(){
    val num = 7
    isEven(num)

}


fun isEven(num: Int)  {
    println("${num} É par? ${num % 2 == 0 }" )
}