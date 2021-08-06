package exercicios

import java.lang.StringBuilder

fun main() {

    //with, apply, run--> this
    //let, also --> it
    //usando with para gerar o alfabeto

    fun alphabet(): String{
        val stringBuilder = StringBuilder()
        return with(stringBuilder){
            for (letter in 'A'..'Z'){
                this.append(letter)
            }
            this.toString()
        }
    }
    alphabet()

    //OUTRO EXEMPLO
    val numbers = mutableListOf("one","two", "three" )
    with(numbers){
        val firstItem = first()
        val lastItem = last()
        println("O primeiro elemento = $firstItem, O útimo elemento = $lastItem")
    }

     //apply exemplo
    var numberList = mutableListOf<Double>()
    numberList.also { println("Populando a Lista") }
        .apply {
            add(2.71)
            add(3.87)
            add(9.0)
            add(23.4)
        }.also { println("ordenando a lista") }.sort()
    println(numberList)

//###########  EXEMPLO APPLY

    val adam = Pexoa("Adam").apply {
        age = 20
        city = "London"
    }
    println(adam) // Pexoa(name=Adam, age=20, city=London)

    //EXEMPLO COM MAP E FILTER

    val number = mutableListOf("one", "two", "three", "four", "five")
    val reusltlist = number.map { it.length }.filter { it > 3 }
    println(reusltlist)

    //mesmo ex acima com let

    val lista = mutableListOf("one", "two", "three", "four", "five")
     lista.map { it.length }.filter { it > 3 }.let(::println)}


data class Pexoa(
    var name: String,
    var age: Int = 0,
    var city: String = ""
)