package lectures.part2oop

object AnonymousClasses  extends App{

  abstract class Animal{   //trait  as well
    def eat : Unit
  }

  val funnyAnimal : Animal = new Animal {
    override def eat: Unit = println("hahahhaah")
  }
  /* equivalent with
  *
  * class AnonymousClasses$$anon$1 extends Animal {
  *   override def eat : Unit = println("hahahhaah")
  * }
  * val funnyAnimal = new AnonymousClasses$$anon$1
  * */

  println(funnyAnimal.getClass)

  class Person(name : String){
    def sayHi : Unit = println(s"Hi my name is $name , how can I be of service.")
  }

  val jim = new Person("Jim"){
    override def sayHi: Unit = println(s"Hi my name is jim ,how can I be of service ?")
  }

}

/*
* RULES -
* pass in required constructor arguments if needed.
* implement all abstract fields / methods.
*
* works for all traits and classes(abstract or not).
 */
