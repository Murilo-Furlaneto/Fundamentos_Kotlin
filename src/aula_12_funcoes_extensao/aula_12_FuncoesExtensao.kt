package aula_12_funcoes_extensao

fun main(){
    println("radar".ispalindrome())
    println("banana".ispalindrome())
    println(20.234.format(2))
}


fun String.ispalindrome() : Boolean {
    return this == this.reversed()
}

fun Double.format(decimalDigits: Int) : String {
    return "%.${decimalDigits}f".format(this)
}