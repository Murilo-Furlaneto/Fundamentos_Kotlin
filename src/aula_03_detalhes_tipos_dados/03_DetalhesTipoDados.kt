package aula_03_detalhes_tipos_dados

fun main(){

    val age: Int = 20

    // adicionar meses em formato decimal ao inteiro da idade (converter idade em um tipo inteiro de dado numerico flutuante)

    var ageDouble: Double = age.toDouble()

    val monthPerPecente: Double = 1.0/12

    println("AgeDouble =  + $ageDouble monthPercente = ${monthPerPecente.toString()}")

    // 2 meses depois..
    ageDouble +=  2 * monthPerPecente

    val ageText: String = "A idade é: " +  ageDouble.toString().plus(" anos.")
    println(ageText)

}