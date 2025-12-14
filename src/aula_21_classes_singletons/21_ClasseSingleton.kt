package aula_21_classes_singletons

fun main(){
    DataBaseUtil.connect()
}


object DataBaseUtil {
    val url: String = "jdbc:mysql://localhost:8080/mydb"
    val user: String = "admin"
    val password: String = "admin"

    fun connect(){
        println("Conectando ao database $url | Usuário: $user | senha: $password ")
    }
}

data object DatabaseHelper{}