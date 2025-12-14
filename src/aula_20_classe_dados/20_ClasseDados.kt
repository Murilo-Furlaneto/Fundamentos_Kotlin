package aula_20_classe_dados

fun main(){
    val userClass = UserClass("joao", 20)
    val userdataClass = UserDataClass("joao2", 21)


    // tostring
    println(userdataClass)
    println(userClass)

    //equals
    val jose = UserDataClass("José", 32)
    val maria = UserDataClass("maria", 22)
    val jose2 = UserDataClass("José", 32)

    println(jose == jose2)


    // copy
    val copymaria = maria.copy(age = 50)
}


class UserClass(val name: String, val age: Int)

data class UserDataClass(val name: String, val age: Int)