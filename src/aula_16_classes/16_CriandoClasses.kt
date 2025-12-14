package aula_16_classes

import kotlin.random.Random

fun main(){
    val jose: Person = Person(name = "José", "Silva", 20)
    val maria: Person = Person("Maria", "Rodrigues")
    println(jose)
    println(jose.work())
    println(jose.fullname)
    println(maria.work())
    println(maria.fullname)
}




class Person(val name: String = "Desconhecido", val lastname: String,  val age: Int = 0){

    val fullname: String ="$name $lastname"

    private val password: String = name + Random.nextInt(100)

    private fun usePassword(){
        println(password)
    }


    fun work(){
        usePassword()
        println("${name},${age} trabalhando...")
    }
}