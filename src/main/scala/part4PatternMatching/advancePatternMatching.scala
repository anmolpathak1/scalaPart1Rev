package part4PatternMatching

import com.sun.org.apache.xpath.internal.functions.FuncFalse

object advancePatternMatching extends App{
  val numbers = List(1)

  val description = numbers match{
    case head :: Nil => println(s"the only element is $head")
    case _ =>
  }

  /*
  * 1. pattern
  * 2.wildcards
  * 3.case classes
  * 4.tuples
  * */

  //for some reason I cannot make it case class but want it to be decomposeable.
  class Person(val name : String,val age : Int)

  object Person /*PersonPattern*/ {
    def unapply(person: Person) : Option[(String,Int)] = Some(person.name,person.age)
    def unapply(age :Int) : Option[String] = Some( if (age < 21) "minor" else "major")
  }

  val bob = new Person("bob",21)

  val greetings = bob match {
    case Person(n,a) /*PersonPattern(n,a)*/ => s"hi my name is $n and age is $a ."
    case _ => "anyhting else."
  }

  val legalStatus = bob.age match{
    case Person(status) => s"Hi I am $status"
  }

  println(greetings)
  println(legalStatus)

  /*exercise*/
  val n = 45
//  val matchPropery = n match {
//    case x if x % 2 == 0 => "is even."
//    case x if x < 10 => "one digit."
//    case _ => "no property."
//  }


  object SingleDigit{
    //make a unapply and do all logic inside it .
    def unapply(x : Int) : Boolean =  x < 10
  }

  object isEven{
    def unapply(x : Int) : Boolean = x % 2 == 0
  }

  val mathProperty = n match {
    case SingleDigit() => "single digit"
    case isEven() => "even number"
    case _ => "no property"
  }

  println(mathProperty)

  //infix  patterns.
  case class Or[A,B](a : A,b :B)
  val either = Or(2,"two")
  val humanDescription = either match{
//    case Or(number,string) => s"$number is written as $string"
    case number Or string => s"$number is written as $string ."
  }

  println(humanDescription)

  val list = List(1,2,3)

  val listPattern = list match {
    case List(1,_*) => "starting with 1 "
    case _ => "matches anything."
  }

  println(listPattern)


  val listOfInteger = Some(Nil)
  val ans = listOfInteger.map(x =>  x :+ 1)
  println(ans)

  abstract class MyList[+A]{
    def head : A = ???
    def tail : MyList[A] = ???
  }

  case object Empty extends MyList[Nothing]
  case class Cons[+A](override val head : A ,override val tail : MyList[A]) extends MyList[A]

  val consList= Cons(1,Empty)

  val consPattern = consList match {
    case Cons(1,_*) => "this is cons "
    case _ => "anything else"
  }

  println(consPattern)

  object MyList{
    def unapplySeq[A](list : MyList[A]) : Option[Seq[A]] = {
      if(list == Empty) Some(Seq.empty)
      else unapplySeq(list.tail).map(list.head +: _)
    }
  }

  val myList : MyList[Int] = Cons(1,Cons(2,Cons(3,Empty)))

  val decomposed = myList match {
    case MyList(1,2,_*) => s"starting with 1, 2"
    case _ => "match anything."
  }

  println(decomposed)

  /*
    val listDemo = List(1,2,3)
    val output = listDemo match {
      case List(1,2,3) => "this is a list aidf"
      case List(1,_*) => "thisn is list"
    }
    println(output)
  */

  //custom return types for unapply
  //isEmpty : Boolean , get : something

  abstract class Wrapper[T]{
    def isEmpty : Boolean
    def get : T
  }

  object PersonWrapper{
    def unapply(person : Person) : Wrapper[String] =  new Wrapper[String]{
      override def isEmpty: Boolean = false
      override def get: String = person.name
    }
  }

  println(bob match{
    case PersonWrapper(n) => s"hello my name is $n"
  })

}
