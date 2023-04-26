package com.rodolfofigueroa.androidmaster

fun main() {
    val weekDays = arrayOf("Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo")

    val lastPosition = weekDays.size-1
    println(weekDays[lastPosition])

    weekDays[0] = "LunesDay"

    println(weekDays[0])

    //for in
    //for (position in weekDays.indices){
      //  println(weekDays[position])
    //}

    /*for ((position, value) in weekDays.withIndex()){
        println(value)
    }*/

    for (weekday in weekDays){
        println("Hoy es $weekday")
    }

    //weekDays.forEach { day -> println(day) }
}