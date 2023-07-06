package lectures.part2oop


/*  TAKEAWAYS
* scalA DOES NOT HAVE STATIC VALUES/methods
*
* SCALA OBJECTS
* are in thier own class.
* are the only instance.
* single pattern in one line !

*
* SCALA COMPANIONS.
* can access each other's private members.
* scala is more object oriented than java.*/


object objects extends App{

  //SCALA DOES NOT HAVE CLASS LEVEL FUNCTIONALITY. (STATIC MEMBERS ARE NOT THERE).it has object . object do not recieve parameters

  object Person{
    //"stati"/"class" -level functionality
    val N_eye = 2
    def canfly : Boolean = false

    //factory method
//    def build(mother : Person,father : Person) : Person = new Person("bobbie")   // - can be converted to aplpy

    def apply(mother : Person,father : Person) : Person = new Person("Bobbie")
  }

  class Person(val name : String){
    // instance level functionality
  }

  println(Person.N_eye)
  println(Person.canfly)

  /*
  // Scala objects are SINGLETON Objects without adding any additional code.
  val mary = Person
  val john = Person
  println(mary == john)
  */

  val mary = new Person("mary")
  val john = new Person("John")
//  Person.build(mary,john)

  Person(mary,john)


  //scala applications  = SCala object with def main(args : Array[String]) : Unit

}
