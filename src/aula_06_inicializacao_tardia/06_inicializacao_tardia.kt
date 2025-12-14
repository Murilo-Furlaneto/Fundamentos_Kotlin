package aula_06_inicializacao_tardia

import kotlin.properties.Delegates

fun main(){
    lateinit var a: String

    a = "Kotlin"


    val b: String by lazy {
        "Kotlin lazy"
    }


     var c: Int by Delegates.notNull<Int>()

    c = 10

}