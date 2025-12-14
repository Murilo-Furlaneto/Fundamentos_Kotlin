package aula_19_classes_abstratas

fun main(){
 val dog = Dog(5)
 dog.sound()
}


open class Animal(val name: String){
   open val age:Int = 0

  open  fun sound(){
        println("$name: som")
    }
}

class Dog(override val age: Int) : Animal(name = "cachorro"){
    override fun sound() {
        println("$name: AU!")
    }


}