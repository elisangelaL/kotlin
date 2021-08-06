package exercicios

fun main() {

    //#### MAP #####
    val numbers = setOf(1,2,3,4,5,6,7,67,5,43,1,2)
    println(numbers.map { it * 3 })
    println(numbers.mapIndexed { index, valor -> valor * index  }) //deve ser valor sobre indice , respectvamente

    //Se a transformação produzir nulo em certos elementos, você pode filtrar o nulo
    println(numbers.mapNotNull { if (it == 2) null else it * 3 })//pula o numero 2 [3, 9, 12, 15, 18, 21, 201, 129]
    println(numbers.mapIndexedNotNull { index, valor -> if (index == 0)null else valor * index  })//[2, 6, 12, 20, 30, 42, 469, 344]

    val numbersMap = mapOf("key1" to 1, "key2" to 2, "key3" to 3, "key11" to 11)
    println(numbersMap.mapKeys { it.key.uppercase() }) //{KEY1=1, KEY2=2, KEY3=3, KEY11=11}
    println(numbersMap.mapValues { it.value + it.key.length })//{key1=5, key2=6, key3=7, key11=16}

    //#### ZIP #### Retorna uma List de Pair
    val colors = listOf("red", "brown", "grey")
    val animals = listOf("fox", "bear", "wolf")
    println(colors zip animals)// [(red, fox), (brown, bear), (grey, wolf)]

    val twoAnimals = listOf("fox", "bear")
    var tupla = colors.zip(twoAnimals)
    println(colors.zip(twoAnimals)) //[(red, fox), (brown, bear)]
    val teste = tupla.size
    val par = tupla[0]
    val (x, y) = Pair(tupla[0].first,tupla[0].second)
    println(x)//red
    println(y)//fox

    //##### UNZIP #####

    val numPairs = listOf("one" to 1, "two" to 2, "three" to 3, "four" to 4)
    println(numPairs.unzip()) //([one, two, three, four], [1, 2, 3, 4])

    //#########  ASSOCIATE ############
    //As transformações de associação permitem construir mapas a
    // partir dos elementos da coleção e certos valores associados a eles.

    val n = listOf("one", "two", "three", "four")
    println(n.associateWith { it.length })//{one=3, two=3, three=5, four=4}
    println(n.associateBy { it.first().uppercaseChar() })//{O=one, T=three, F=four}
    println(n.associateBy(keySelector = {it.first().uppercaseChar()}, valueTransform = {it.length}))//{O=3, T=5, F=4}
        val names = listOf("Alice Adams", "Brian Brown", "Clara Campbell")

    //###### FLATTEN #######
//Se você opera coleções aninhadas, pode achar úteis as
// funções de biblioteca padrão que fornecem acesso simples aos elementos da coleção aninhada.

    val numbersSet = listOf(setOf(1,2,3), setOf(4,5,6), setOf(1,2))
    println(numbersSet)//[[1, 2, 3], [4, 5, 6], [1, 2]]
    println(numbersSet.flatten())//[1, 2, 3, 4, 5, 6, 1, 2]

    //#### flatMap() ####
    val container = listOf(
        StringContainer(listOf("one", "two", "three")),
        StringContainer(listOf("four", "five", "six")),
        StringContainer(listOf("seven", "eight"))
    )
    println(container.flatMap { it.values })//[one, two, three, four, five, six, seven, eight]

    // ##### String representation #####
    val numeros = listOf("one", "two", "three", "four")
    println(numeros)//[one, two, three, four]
    println(numeros.joinToString())//one, two, three, four

    val listString = StringBuffer("A lista dos numeros: ")
    numeros.joinTo(listString)
    println(listString)//A lista dos numeros: one, two, three, four

    //### SEPARATOR | PREFIX | POSTFIX
    println(numeros.joinToString(separator = " # ", prefix = "Início: ", postfix = ": Fim")) //Início: one # two # three # four: Fim

    // #### LIMIT ####

    val num = (1..100)
    println(num)//1..100
    println(num.toList())// [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, até 100]
    println(num.joinToString(limit = 10, truncated = "<...>")) //1, 2, 3, 4, 5, 6, 7, 8, 9, 10, <...>

    val lista = listOf("one", "two", "three", "four")
    println(lista.joinToString { "Elemento: ${it.uppercase()}" })//Elemento: ONE, Elemento: TWO, Elemento: THREE, Elemento: FOUR

}

data class StringContainer(val values: List<String>)