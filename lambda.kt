package exercicios

fun main() {
  //Fazendo uma busca pelo maior valor SEM lambda
   fun findTheOldest(people: List<Person>) {
      var maxAge = 0
      var theOldest: Person? = null
      for(person in people){
          if(person.age >  maxAge){
              maxAge = person.age
              theOldest = person
          }
      }
      println(theOldest)
   }
//   val people = listOf(Person("Alice",54), Person("Pixulinha", 16))
//    findTheOldest(people)

    // #######  fazendo uma busca em uma cole~ção usando lambda ##########

    val pessoa = listOf(Person("Alice",599), Person("Pixulinha", 160))
    println(pessoa.maxByOrNull { it.age })

    //Todos os códigos acima resumidos nesta linha
    //Fazendo uma busca usando uma referencia a um membro
    //Passando um lambda fora dos parenteses
    pessoa.maxByOrNull (Person::age )
    pessoa.maxByOrNull { p:Person -> p.age }//mesma ciosa da linha de cima Saída Person(name=Alice, age=599)
    println(pessoa.maxByOrNull(Person::age)) //mesma ciosa da linha de cima

    //sintaxe das expressões lambdas

    val soma = { x: Int, y:Int -> x + y}
    println("Soma = ${soma(4,7)}")

   //Referencias a membros
    val getAge = Person::age
    println(getAge)

    println(pessoa.maxByOrNull(Person::age))

    fun salute() = println("salute!!")
    run(::salute)//A referencia a membro ::salute é passada como argumento para a fç da biblioteca run que chama a funçao correspondente
    //Saída Salute!

    //Referencias vinculadas

    val p = Person("Ester", 34)
    val personAgeFunction = Person::age
    println(personAgeFunction(p))// saída 34





}
data class Person(val name: String, val age: Int)
