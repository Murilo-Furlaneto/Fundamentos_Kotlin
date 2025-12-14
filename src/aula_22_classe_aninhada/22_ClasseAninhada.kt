package aula_22_classe_aninhada

fun main(){
    val car = Car(model = "Chevrolet Onix", year = 2021)
    val carEngine = Car.Engine()
    val fuelType = Car.Engine.FuelType("Gasolina")
}



class Car(val model: String, val  year: Int){
    class Engine{
        class FuelType(val typeName: String){
            fun fuelCar(){
                println("Abastecendo o carro com $typeName")
            }
        }


        fun start(){
            println("ligando...")
        }
    }
}