package lectures.part2oop

object Inheritance extends App{

  //single class inheritance - a class can extend oonly one class at a time.
//  final class Animal{
  sealed class Animal{
    val creatureType = "wild"
    //private def eat = println("nomnom")
//    protected def eat = println("nomnom")
//     final def eat = println("nomnom")
      def eat = println("nomnom")
  }

  class Cat extends Animal{
    def crunch = {
      eat
      println("crunch crunch.")
    }
  }

  val cat = new Cat
//  cat.eat
  cat.crunch

  //constructors.
  class Person(name : String,age : Int){
    def this(name : String) = this(name,0)
  }
  class Adult(name : String,age : Int,idCard : String) extends Person(name,age)


  //overriding
  class Dog(override val creatureType: String) extends Animal{
//    override val creatureType: String = "Domestic"
    override def eat: Unit = {
      super.eat
      println("crunch,crunch ")
    }
  }

  val dog = new Dog("Domestic")
  dog.eat
  println(dog.creatureType)

  //type substitution.

  val unknownAnimal : Animal = new Dog("K9")
  unknownAnimal.eat


  //super

  //preventing overrides
  /*
  * 1. - use final on member.
  * 2  - use final on the entire class.
  * 3. - seal the class = extend class in this file , prevent extension  in other files.
  * */
}
