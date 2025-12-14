package aula_28_classes_e_interfaces_seladas

fun main(){
    val contacts : Result = Database.getContacts()
    val isContactInserted: Result = Database.insertContact("Fernando")
    val isContactUpdated : Result = Database.updateContact(1, "Fernando")

    handleResult(contacts)
    handleResult(isContactInserted)
    handleResult(isContactUpdated)
}



sealed class Result {
    data class Sucess(val data: String) : Result()
    data class Error(val exception: Exception) : Result()
    data object Loading : Result()

}

fun handleResult(result: Result) {
    println(
        when (result) {
            is Result.Error -> "Houve um erro! ${result.exception.message}"
            Result.Loading -> "Carregando..."
            is Result.Sucess -> "Sucesso ! ${result.data}"
        }
    )
}

object Database {
    fun getContacts() : Result {
        return Result.Sucess(data = listOf("João", "José", "Maria").joinToString())
    }

    fun insertContact(contact: String) : Result {
        return Result.Error(IllegalArgumentException("O contato a ser inserido possui caracteres inválidos."))
    }

    fun updateContact(id: Int, newContact: String) : Result {
        return Result.Loading
    }
}


sealed interface  Animal {
    data class Dog(val breed: String) : Animal {
        override fun sound(): String {
            return "Au"
        }
    }

    data class Cat(val color: String) : Animal {
        override fun sound(): String {
            return "Miau"
        }
    }

    fun sound() : String
}