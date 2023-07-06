package lectures.part2oop

object OOBasics extends App{

  val person = new Person("John",26)

  //class parameter are not class member.
 // println(person.name)
//  println(person.age)
//  person.greet("don")
//  person.greet()

  val myCounter = new counter(10)
  myCounter.dec().currentCount()

}
// constructor.
class Person(name : String,val age : Int) {
  //body
  val x = 2
  println(1 + 3)

  def greet(name : String): Unit = println(s"${this.name} says : Hi $name")
  def greet() : Unit = println(s"hi I am $name")

  //multiple constructor.
  def this(name : String) = this(name,0)


}

/*Novel and a Writer
  *
  * Writer : First name , surname ,year
  * -method fullname
  *
  * Novel :name,year of release,author
  *  -authorAge
  *  -isWritterBy(author)
  *  -copy(new year of release) -= new instance of Novel
  * */

class Writer(firstName : String,surname : String,val year : Int){
  def fullname() : String = {
    firstName + " " + surname
  }
}

class Novel(name : String,yor : Int,author : Writer){

  def authorAge() : Int =  author.year
  def isWrittenBy(author : Writer)  = ???
  def copy(newYor  : Int) = new Novel(name,newYor,author)
}

/*
* counter class
*  - recieves an int value
*  - method current count
*  - method to increment/decrement => new counter
*  - overload inc/dec to recieve an amount
* */


class counter(num : Int){
  def currentCount() : Unit = print(num)

  def inc() : counter = new counter(num + 1)
  def dec() : counter = new counter(num - 1)

  def inc(amount : Int) = new counter(num + amount)
  def dec(amount : Int) = new counter(num - amount)
}
