package com.rodolfofigueroa.androidmaster

fun main() {
    getMonth(2)
    getTrimester(12)
    getSemester(13)
    result("Hola")
}

fun result(value:Any){
    when(value){
        is Int -> println("Es un numero y sumando = ${value + value}")
        is String -> println("Es un string")
        is Boolean -> if(value) println("Es un booleano y es true")
    }
}

/*fun getSemester(month:Int):String{
    val result = when(month){
        in 1..6 -> "Primer Semestre"
        in 7..12 -> "Segundo Semestre"
        !in 1..12 -> "Mes no válido"
        else -> "kjfdkadshfk"
    }
    return result
}*/

fun getSemester(month:Int) = when(month){
        in 1..6 -> "Primer Semestre"
        in 7..12 -> "Segundo Semestre"
        !in 1..12 -> "Mes no válido"
        else -> "kjfdkadshfk"
    }

fun getMonth(month:Int){
    when(month){
        1 -> println("Enero")
        2 -> println("Febrero")
        3 -> println("Marzo")
        4 -> println("Abril")
        5 -> println("Mayo")
        6 -> println("Junio")
        7 -> println("Julio")
        8 -> println("Agosto")
        9 -> println("Septiembre")
        10 -> println("Octubre")
        11 -> println("Noviembre")
        12 -> println("Diciembre")
        else -> println("No existe el mes")
    }
}

fun getTrimester(month:Int){
    when(month){
        1,2,3 -> println("Primer Trimestre")
        4,5,6 -> println("Segundo Trimestre")
        7,8,9 -> println("Tercero Trimestre")
        10,11,12 -> println("Cuarto Trimestre")
        else -> println("trimestre no válido")
    }
}