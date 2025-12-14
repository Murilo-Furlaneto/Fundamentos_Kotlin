package aula_05_nulos

fun main(){
    var  a: String? = null


    var result: String = a ?: "1"

    println(result)

    var b: Int = -1

    b = a?.toInt() ?: 0

    println(b)

    if(a != null){
        println(a.toInt())
    }



    b?.let {
        println(it)
    }
}