package aula_07_colecoes

fun main(){

    // set

    println("===========SET=====================")

    val set = setOf(1,2,3)
    val setRandom = setOf(1,2,3,"kotlin", 5.0, "Bernador", 0..10, "kotlin")

    val setMutable = mutableSetOf(1,2,3,"kotlin", "kotlin2",4.0,5.0)
    setMutable.add(20)
    setMutable.remove(1)

    println(set)
    println(setMutable)

    // map

    println("===========MAP=====================")

    val map = mapOf<Int, String>(Pair(1, "kotlin"), 2 to "Kotlin")

    println(map)
    println(map.keys)
    println(map.values)
    println(map.entries)

    val mapMutable = mutableMapOf(1 to "kotlin", "kotlin" to 1, 30.4 to 4, 0..100 to "aaa")

    println(mapMutable)
    println(mapMutable.entries)

    val hashMap = hashMapOf(
        1 to "kotlin"
    )


}