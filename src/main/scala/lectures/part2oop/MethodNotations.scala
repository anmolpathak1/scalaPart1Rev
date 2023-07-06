package lectures.part2oop

import scala.language.postfixOps

object MethodNotations extends App{

  class Person(val name : String,favouriteMovie : String){
    def like(movie : String) : Boolean = movie == favouriteMovie
 //   def hangoutWith(person: Person) : String = s"${this.name} is hanging out with ${person.name}"
    def +(person: Person) : String = s"${this.name} is hanging out with ${person.name}"
    def unary_! : String = s"$name, what the heck !"
    def isAlive() : Boolean = true

    def apply() : String = s"Hi my name is $name and i like $favouriteMovie."
  }

  val mary = new Person("Mary","Inception")
  println(mary.like("Inception"))
  println(mary like "Inception")                     //method with single parameter can be called via infix notation.

  // "operators" in scala


  val tom = new Person("Tom","Fight Club")
  // println(tom hangoutWith mary)
  println(tom + mary)


  //prefix notation  - prefix notation only works with - + ~ !

  val x = -1            //eqvilent with 1.unary_-
  val y = 1.unary_-

  println(mary.unary_!)
  println(!mary)


  //postfix nototion - rarely used

  println(mary.isAlive())
  println(mary.isAlive())


  //apply

  println(mary.apply())
  println(mary())             //equivalent to mary.apply() where even we call only object compiler looks for apply method in class.


  // SKipping lecture 13 as its exercise for prefix , infix and postfix operators. (not that important.)
}
