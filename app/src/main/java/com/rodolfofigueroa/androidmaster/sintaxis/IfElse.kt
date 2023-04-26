package com.rodolfofigueroa.androidmaster

fun main() {
    ifBasico()
}

fun ifMultiple(){
    val age = 18
    val parentPermission = true
    val imHappy = true

    if (age >= 18){
        if (parentPermission){
            if (imHappy){
                println("Beber cerveza")
            }
        }
    }

    if (age >= 18 && parentPermission && imHappy){
        println("Beber cerveza")
    }
}

fun ifBasico(){
    val name = "Samantha"

    if (name == "rodo"){
        println("La variable name es $name")
    }else{
        println("Este no es $name")
    }
}

fun ifAnidado(){
    val animal = "perro"

    if (animal == "perro"){
        print("Es un perro")
    }else if(animal == "gato"){
        println("Es un Gato")
    }else if (animal == "pajaro"){
        println("Es un pajaro")
    }else{
        println("No es ninguno de los anteriores")
    }
}