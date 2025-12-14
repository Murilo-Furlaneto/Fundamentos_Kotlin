package aula_09_lacos_repeticao

fun main(){
    // for
    println("===========FOR=====================")
    val list = listOf(1,2,3,4,5,10)

    for (item in list){
        println(item)
    }

    list.forEach {
        println(it)
    }

    list.forEachIndexed {
        index, item -> println("index = $index | item = $item")
    }

    // while
    println("===========WHILE=====================")
    var index = 1
    val maxLimit = 5

    while ( index <= maxLimit){
        println("$index ...")
        index++
    }

    //do-while
    println("===========DO WHILE=====================")
    var index2 = 1

    do {
        println(index2)

        if(index2 == 3)
            break

        index2++
    } while (index2 <= 5)

    // laços aninhados
    println("===========LOÇOS ANINHADOS=====================")

  loop@  for (i in 1..3){
        for (j in 1..3){
            if(i == 2 && j ==2){
                break@loop
            }
            println("i = $i | j = $j")
        }
    }

    // repeat
    println("===========REPEAT=====================")

    var index3 = 1
    repeat(5){
        println(index3)
        index3++
    }

    var i = 5
    var soma = 0
    repeat(5) { i ->
        soma += i
    }
    println(soma)
}