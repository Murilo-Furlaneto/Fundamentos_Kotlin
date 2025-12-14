package aula_17_personalizando_propriedade

fun main(){
    val joao = Person("João")
    joao.height = 175.9

    println("Altura: ${joao.height}")
    println("Idade: ${joao.age }")

    joao.age = -10

}


class Person(val name: String){
    var age: Int = 0
        set(value) {
            if(value >= 0) field = value
            else println("Idade não pode ser negativa")
        }

    var height: Double = 0.0
        get() = Math.ceil(field)


}