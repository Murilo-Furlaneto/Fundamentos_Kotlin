package aula_18_companion_object

fun main(){
    val key = Person.KEY
    val key2 = Person.getKey()
}
// não precisa instanciar uma classe para poder utilizar

class Person{
    companion object {
        const val KEY = "12345678"
        private const val KEY_2 = "1234567890"

        fun getKey() : String =  KEY + KEY_2

    }


}

