package aula_23_classes_internas

fun main(){
    val carEngine = Car("Chevrolet Onix", 2022).Engine()
    carEngine.start()

    val carEngineFuelType = carEngine.Fuel("Gasolina")
    carEngineFuelType.fuelCar()
}


class Car(val model: String, val year: Int){
   inner class Engine {

       inner class Fuel(val typeName: String){
           fun fuelCar(){
               println("Abastecendo o carro $model, $year com $typeName")
               start()
           }
       }

        fun start(){
            println("Ligando o carro do modelo $model e ano $year...")
        }
    }
}