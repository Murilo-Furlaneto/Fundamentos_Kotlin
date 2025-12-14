package desafios.desafio_02

fun main() {
    calculaIMC()
}

fun calculaIMC() {
    println("Bem-vindo à calculadora de IMC")

    val altura = lerDouble("Insira sua altura (m): ")
    val peso = lerDouble("Insira seu peso (kg): ")

    try {
        validarDados(altura, peso)

        val imc = calcularIMC(peso, altura)
        val classificacao = classificarIMC(imc)

        println("Seu IMC é %.2f".format(imc))
        println("Classificação: $classificacao")

    } catch (e: IllegalArgumentException) {
        println(e.message)
    }
}

fun lerDouble(mensagem: String): Double {
    print(mensagem)
    return readlnOrNull()?.toDoubleOrNull()
        ?: throw IllegalArgumentException("Valor inválido")
}

fun validarDados(altura: Double, peso: Double) {
    require(peso in 1.0..400.0) { "Peso inválido" }
    require(altura >= 1.10) { "Altura inválida" }
}

fun calcularIMC(peso: Double, altura: Double): Double =
    peso / (altura * altura)

fun classificarIMC(imc: Double): String =
    when {
        imc < 18.5 -> "Baixo peso"
        imc < 25.0 -> "Peso normal"
        imc < 30.0 -> "Sobrepeso"
        imc < 35.0 -> "Obesidade grau I"
        imc < 40.0 -> "Obesidade grau II"
        else -> "Obesidade grau III"
    }
