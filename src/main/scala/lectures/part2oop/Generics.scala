package lectures.part2oop

object Generics extends App{

  class MyList[+A]{
    def add[B >: A](element : B) : MyList[B] = ???
  }

  class MyMap[Key,value]

  val listOfIntegers = new MyList[Int]
  val listOfString = new MyList[String]

  object MyList{                          //objects are not type parameterized.
    def empty[A]: MyList[A] = ???
  }

  val emptyListOfIntegers = MyList.empty[Int]

  //variance problem

  class Animal
  class Cat extends Animal
  class Dog extends Animal


  //list of cat can extend list of Animal ?
 /*3 possible answers
 * 1.Yes  = Covariant(+)
 * 2. No = Invariant
 * 3. hell nio = Contravarinat (-)
 * */

  class CovariantList[+A]
  val animal : Animal = new Cat
  val animalList : CovariantList[Animal] = new CovariantList[Cat]

  //animalList.add(new Dog) ??? HARD QUESTION

  class InvariantList[A]
  val invariantAnimalList : InvariantList[Animal] = new InvariantList[Animal]


  //ContravariantList
  class Trainer[-A]
  val trainer : Trainer[Cat] = new Trainer[Animal]

  //bounded types
  class Cage[A <: Animal](animal: A)         //only accepts types which are subtypes of Animals.
  val cage = new Cage(new Dog)

/*

  inferred type arguments [lectures.part2oop.Generics.Car] do not conform to value <local Cage>'s type parameter bounds [A <: lectures.part2oop.Generics.Animal]
    val newCage = new Cage(new Car)

  class Car
  val newCage = new Cage(new Car)

*/







}
