package aula_07_colecoes

fun main(){

    // array
    val array: Array<Int> = arrayOf(1,6,9,33,90)
    val array2: Array<String> = arrayOf("1","2","3")

    println("===========ARRAY=====================")

    println(array.joinToString(prefix = "[", postfix = "]", separator = " | "))
    println(array2.joinToString())

    val array3: Array<Int> = arrayOf(6,7,8,9,10)

    val arraySum = array + array3

    println(arraySum.joinToString())


    // List

    val list = listOf(1,2,3, "1", false, 1..3, 4.0,10,20,1)
    val mutableList = mutableListOf(1,2,3)

    mutableList.add(4)

    println("===========LIST=====================")
    println(mutableList)

    val listInt = list.filterIsInstance<Int>()

    println(listInt)

    val listIntHigherThan2 = list.filter { it is Int && it > 2  }

    println(listIntHigherThan2)


    val listIntMessy = listOf(9,8,70,1,3,750,8,16,32_550,2, -110)
    val listStringMessy = listOf("Bernado", "Alice", "Jhonatan", "Roberto", "Clara")

    println(listStringMessy.sorted())
    println(listIntMessy.sorted())

    val intMax = listIntMessy.max()
    val inMin = listIntMessy.min()

    println(inMin)
    println(intMax)


    val findFirstOdd = list.find { it is Int && it % 2 != 0 }
    val findLastOdd = list.findLast { it is Int && it % 2 != 0 }

    println(findFirstOdd)
    println(findLastOdd)

    val booleanMapIntHigherThan10 =  listIntMessy.map {
        it > 10
    }

    println(booleanMapIntHigherThan10)

    println(list.first())
    println(list.last())
    println(list.subList(0,3))
    println(list[3])
    println(list.indexOf(4))
    println(list.indices)
    println(list.size)

}