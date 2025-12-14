package aula_27_objetos_anonimos

fun main(){

    val x = 10

    val objectTemp = object  {
        val property : Int = 1
        val property2: String = "Kotlin"

        fun method1(){
            println(x)
        }
    }

    println(objectTemp.property)

    val buttonClickCallback = object : ClickCallback{
        override fun onClick() {
            println("Botão clicado")
        }

    }

    buttonClickCallback.onClick()
}


interface ClickCallback {
    fun onClick()
}