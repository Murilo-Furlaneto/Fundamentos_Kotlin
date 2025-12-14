package aula_25_classes_enumeradas

fun main(){
    val north = Direction.NORTH

  //  println(north.name)
  //  println(north.ordinal)

 //   north.addDirection(direction = Direction.EAST)

 //   Direction.sumDirection(firstDirection = Direction.SOUTH, Direction.WEST)

    //entries

    Direction.entries.forEach { item ->
        println(item)
    }

    // ValueOf

    println(Direction.valueOf("SOUTH").ordinal)

}

enum class Direction(val description: String) {
    NORTH(description = "Direção norte"), // 0
    SOUTH("Direção sul"), // 1
    EAST(description = "Direção leste"), // 2
    WEST(description = "Direção oeste"); // 3

    companion object{
        fun sumDirection(firstDirection: Direction, secondDirection: Direction){
            println(firstDirection.description)
            println(secondDirection.description)
        }
    }

    fun addDirection(direction: Direction){
        println(this.description)
        println(direction.description)
    }

}