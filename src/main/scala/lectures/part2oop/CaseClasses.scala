package lectures.part2oop

object CaseClasses extends App{

  /*
  * equals ,hashcode,toString
  * */

  case class Person(name : String,age : Int)

  //1.class parameters are fields.
  val jim = new Person("jim",34)

  println(jim.name)

  //2.sensible toString
  //println(instance) = println(instance.toString) -> syntactic sugar.
  println(jim)


  //3.equals and hashcode implemented OOTB.
  val jim2 = new Person("jim",34)

  //equals here compare the two objects based on contents not on reference.
  println(jim == jim2)

  //4.case classes have handy copy method.
  val jim3 =jim.copy(age = 45)
  println(jim3)

  //5.case classes have companion objects.
  val thePerson = Person

  val mary = Person("mary",23)

  //6.case classes are serializable.

  //7.case classes have extractor pattern. = can be used in pattern matching.


  //case classes do not get companion objects as they are already object
  case object UnitedKingdom{
    def name : String = "The UK of GB"
  }
}
