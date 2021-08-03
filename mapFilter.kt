package exercicios

fun main() {
    // A fç Filter percorre uma coleção e seleciona os elementos aos quais a lambda especificada devolve true

    val list = listOf(1,2,3,4)
    println(list.filter { it % 2 == 0 })

    println(list.map { it * it })// [1, 4, 9, 16]

    //#####################

    val people = listOf(Pessoa("Gisele Buntchen", 55), Pessoa("Helena Lima", 95))
    println(people.filter { it.age > 30 }) // [Pessoa(name=Gisele Buntchen, age=55)]

    println(people.map { it.name })
    println(people.filter { it.age > 30 }.map(Pessoa::name )) //[Gisele Buntchen]

    //Precisamos dos nomes das pessoas mais velhas do grupo. Podemos encontrar a maior idade e devolver os nomes

    println(people.filter { it.age == people.maxByOrNull( Pessoa::age)?.age  })//[Pessoa(name=Helena Lima, age=95)]

    //a solução abaixo calcula a idade maxima somente uma vez
    val maxAge = people.maxByOrNull( Pessoa::age)?.age
    println(people.filter { it.age == maxAge }) //[Pessoa(name=Helena Lima, age=95)]

}

data class Pessoa(
    val name: String,
    val age: Int
)