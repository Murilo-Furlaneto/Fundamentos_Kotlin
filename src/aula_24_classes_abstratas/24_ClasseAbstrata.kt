package aula_24_classes_abstratas

fun main(){
    val car = Car(model = "Chevrolet Onix", year = 2021, color = "Branco")
    val bike = Bike(color = "Preto")

    println(car)

    println(bike.maxSpeed)
    println(bike.wheelsAmount)
    bike.info()
}

abstract class Vehicle(val color: String) {
    abstract val maxSpeed: Int
    abstract val wheelsAmount: Int

   abstract fun startMovement()

    fun info(){
        println("""
            Velocidade Máxima = $maxSpeed km/h
            Quantidade de Rodas = $wheelsAmount
        """.trimIndent())
    }
}

class Car(val model: String, val year: Int, color: String) : Vehicle(color = color){
    override val maxSpeed: Int
        get() = 150
    override val wheelsAmount: Int
        get() = 4

    override fun startMovement() {
        println("Ligando motor..")
    }

    override fun toString(): String {
         super.info()
        return "$model, $year"
    }

}

class Bike(color: String) : Vehicle(color = color) {
    override val maxSpeed: Int
        get() = 40
    override val wheelsAmount: Int
        get() = 2

    override fun startMovement() {
        println("Pedalando...")
    }

}