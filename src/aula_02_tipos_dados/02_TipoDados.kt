package aula_02_tipos_dados


fun main(){
    // númericos
    val byte: Byte = -128
    val short: Short = 32_500
    val int: Int = 1_000_000
    val long: Long = 31829831931289123


    // pontos flutuantes
    val float: Float = 3.14f
    val double: Double = 3.14

    // texto
    val char: Char = 'a'
    val string: String = "palavra"

    // boolean
    val boolean: Boolean = true

    // conversão
    var text = "5"
    val numberFromstring = Integer.parseInt(text)

}