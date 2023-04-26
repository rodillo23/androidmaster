package com.rodolfofigueroa.androidmaster
fun main() {
    val edad = edadActual(1985)
    showMyName("Rodillo")
    showMyAge(edad)
    val suma = sumar(10,16)
    println(suma)
}
fun showMyName(nombre:String){
    println("Me llamo $nombre")
}

fun showMyAge(age:Int = 30){
    println("Tengo $age años")
}

fun edadActual(anioNac:Int):Int{
    val anioAct = 2023
    return anioAct - anioNac
}

fun sumar(num1:Int, num2:Int) = num1 + num2

fun variablesNumericas(){
    /*
   *VARIABLES NUMERICAS
   */

    //Int -2,147,483,647 a 2,147,483,647
    val age:Int = 38
    var age2:Int = 50

    //Long -9,223,372,036,854,775,807 a -9,223,372,036,854,775,807
    val example:Long = 50

    //Float 6 decimales
    val floatExample:Float = 5.876543F

    //Double 14 decimales
    val doubleExample:Double = 3241.1515489636

    val res = age + floatExample.toInt()
}

fun variablesBoolean(){
    /*
    * VARIABLES BOOLEANAS
    */
    val booleanExample:Boolean = true
}

fun variablesAlfanumericas(){
    /*
    * VARIABLES ALFANUMERICAS
    */

    //Char
    val charExample1:Char = 'a'
    val charExample2:Char = '1'
    val charExample3:Char = '@'

    //String
    val stringExample:String = "Rodolfo Figueroa Chávez"
    println("Hola me llamo $stringExample")

}