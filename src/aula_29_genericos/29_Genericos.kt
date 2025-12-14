package aula_29_genericos

fun main(){

    printItem("Kotlin")
    println(true)

    val container1 = Container<Product>(listOf(
        Product("Laranja", 10),
        Product("Maçã", 20)
    ))

    container1.showItems()
}

fun <T> printItem(item: T){
    println(item)
}

class Container<T>(val items: List<T>) {
    fun showItems(){
        println("""
            Itens do container: ${items.joinToString()}
        """.trimIndent())
    }
}

data class Product(val name: String, val amount: Int)