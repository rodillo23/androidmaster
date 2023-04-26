package com.rodolfofigueroa.androidmaster

fun main() {
    mutableList()
}

fun mutableList(){
    val technologies:MutableList<String> = mutableListOf("Kotlin", "Android", "JS", "React", "Node")
    technologies.add(0, "React Native")
    println(technologies)

    if (technologies.isNotEmpty()){
        technologies.forEach { println(it) }
    }
}

fun inmutableList(){
    val readOnly:List<String> = listOf("Lunes", "Martes","Miercoles", "Jueves", "Viernes", "Sabado", "Domingo")
    println(readOnly.size)
    println(readOnly)
    println(readOnly[0])
    println(readOnly.last())
    println(readOnly.first())

    val example = readOnly.filter { it -> it.contains("a") }
    println(example)

    readOnly.forEach { it -> println("Hola $it") }
}