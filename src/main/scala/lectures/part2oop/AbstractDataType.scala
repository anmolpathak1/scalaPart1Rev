package lectures.part2oop

object AbstractDataType extends App{

  //abstract

  abstract class Animal{
    val creatureType : String
    def eat : Unit
  }

  class Dog extends Animal{
    override val creatureType: String = "Cannine"

    override def eat: Unit = println("Crunch Crunch")
  }

  //trait
  trait Carnivore{
//    val x: Int
    def eat(animal: Animal) : Unit
    val preferrredMeal : String = "fresh meat"
  }

  class Crocodile extends Animal with Carnivore {
    override val creatureType: String = "croc"

    override def eat: Unit = println("nomnomnom")

    override def eat(animal: Animal): Unit = println(s"I am a croc eating a ${animal.creatureType}")
  }

  //traits vs abstract classes
  /*
  * 1 - / traits do not have constructor parameters
  * 2 - / multiple traits may be inherited by the same class
  * 3 - traits = behaviour , abstract class = "thing"
  * */
}
