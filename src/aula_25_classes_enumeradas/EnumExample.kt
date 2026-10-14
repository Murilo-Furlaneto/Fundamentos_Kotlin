package aula_25_classes_enumeradas

fun main(){
    val priority = Priority.LOW
    println(priority)
    println(priority.color)

    val priority2 = Priority.valueOf("LOW")
    println(priority2)

    for (priority in Priority.values()){
        println(priority.color)
    }
}

enum class Priority(val color: String) {
    LOW("green"),MEDIUM("organge"), HIGH("red");

    val number: Int
        get() = when(this) {
            LOW -> 1
            MEDIUM -> 2
            HIGH -> 3
        }

}