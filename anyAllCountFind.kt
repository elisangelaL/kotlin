package exercicios

fun main() {
    val canBeClub27 = {p:Pessoa -> p.age <= 27}
    println(canBeClub27)

    val people = listOf(Pessoa("Alice", 27), Pessoa("Helena", 18), Pessoa("Ester", 44))
    //o retorno dessa variavel é um boolean
    //verficando se todos tem <= 27 anos
    println(people.all( canBeClub27))//false

    //Se precisar verificar se há pelo menos um elemento correspondente, usar o any

    println(people.any(canBeClub27))//true

    val list = listOf(1,2,3)
    println(list.any { it != 3 })//true Existe algum element diferente de 3

    //Se quiser saber quantos elementos satisfazem a esse predicado {p:Pessoa -> p.age <= 27}

    println(people.count(canBeClub27))// 2
    //tb posso usar
    println(people.filter(canBeClub27).size)//2

    //para encontrar um elemnto que satisfaça o predicado , utilize a fç find
    //devolve o primeiro elemento correspondente se houver muitos, ou null se nenhum deles satisfazer ao predicado
    println(people.find(canBeClub27))
    println(people.firstOrNull(canBeClub27))//retorna o primeiro elemento que for encontrado ou null se não for

}