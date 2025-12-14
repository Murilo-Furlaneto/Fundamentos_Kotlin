package aula_30_destructuring

fun main(){
    val (name, lastName, age) = Person("José", "Silva", 40)

    val (a,b) = Pair<String, String>("a", "b")

    val (c,d,e) = Triple<Int, Boolean, Double>(10,false,5.0)

    val (animalName,animalAge) = Animal("Cachorro", 3)

}

data class Person(val name: String,val lastname: String ,val age: Int)

class Animal(val name: String, val age: Int){
    operator fun component1() = name
    operator  fun component2() = age
}